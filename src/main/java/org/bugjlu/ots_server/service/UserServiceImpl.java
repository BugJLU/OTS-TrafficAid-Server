package org.bugjlu.ots_server.service;

import org.bugjlu.ots_server.assistService.IntimacyService;
import org.bugjlu.ots_server.assistService.MapService;
import org.bugjlu.ots_server.dao.ContactDao;
import org.bugjlu.ots_server.dao.UserDao;
import org.bugjlu.ots_server.po.Contact;
import org.bugjlu.ots_server.po.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    
    @Autowired
    UserDao userDao;

    @Autowired
    ContactDao contactDao;
    
    @Override
    public Boolean addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public User updateUserInfo(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public User changeLocation(String id, String gx, String gy) {
        return userDao.updateGeo(id, gx, gy);
    }

    @Override
    public User getUser(String id) {
        return userDao.getUser(id);
    }

    @Override
    public List<User> getUserAround(String id, int distance) {
        List<User> allUser = userDao.getAllUser();
        User currentUser = userDao.getUser(id);
        if (allUser == null || currentUser == null) return null;

        List<User> nearbyUser = new ArrayList<>();
        for (User u:
             allUser) {
            int dist = getDistanceByUsers(currentUser, u);
            if (dist <= distance && dist >= 0) {
                nearbyUser.add(u);
            }
        }
        return nearbyUser;
    }


    @Override
    public List<User> getHeplerAround(String id) {
        class Candidate {
            public String id;
            public double intimacy;
            public Candidate(String id, double intimacy) {
                this.id = id;
                this.intimacy = intimacy;
            }
        }
        List<Contact> contacts = contactDao.getContacts(id);
        List<Candidate> helperCandidates = new ArrayList<>();
        User currentUser = userDao.getUser(id);
        if (contacts == null) return null;
        for (Contact cj1:
             contacts) {

            // add 1jump contact himself
            User j1User = userDao.getUser(cj1.getObjectId());
            if (j1User.getId().equals(currentUser.getGeoX())) continue;
            double i1 = IntimacyService.get1JumpIntimacy(cj1.getGroupType());
            i1 *= MapService.distanceToCoefficient(getDistanceByUsers(currentUser, j1User));
            helperCandidates.add(new Candidate(cj1.getObjectId(), i1));

            // add 2jump contacts from 1jump
            List<Contact> jump2contacts = contactDao.getContacts(cj1.getObjectId());
            for (Contact cj2 :
                    jump2contacts) {
                User j2User = userDao.getUser(cj2.getObjectId());
                if (j2User.getId().equals(currentUser.getId()) ||
                        j2User.getId().equals(currentUser.getEmgContact()))
                    continue;
                double i2 = IntimacyService.calculate2JumpIntimacy(
                        cj1.getGroupType(),
                        cj2.getGroupType()
                );
                i2 *= MapService.distanceToCoefficient(getDistanceByUsers(currentUser, j2User));
                helperCandidates.add(new Candidate(cj2.getObjectId(), i2));
            }

        }
        helperCandidates.sort(new Comparator<Candidate>() {
            @Override
            public int compare(Candidate o1, Candidate o2) {
                if (o1.intimacy < o2.intimacy) {
                    return 1;
                } else return -1;
            }
        });
        List<User> res = new ArrayList<>();
        if (helperCandidates.size() > 0) {
            res.add(userDao.getUser(helperCandidates.get(0).id));
        }
        if (helperCandidates.size() > 1) {
            res.add(userDao.getUser(helperCandidates.get(1).id));
        }

        return res;
    }

    @Override
    public int getDistanceByUsers(User ua, User ub) {
        return MapService.getDistanceByPoints(ua.getGeoX(), ua.getGeoY(), ub.getGeoX(), ub.getGeoY());
    }
}
