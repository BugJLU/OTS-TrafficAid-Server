package org.bugjlu.ots_server.service;

import org.bugjlu.ots_server.po.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public Boolean addUser(User user);
    public User updateUserInfo(User user);
    public User changeLocation(String id, String gx, String gy);
    public User getUser(String id);
    public List<User> getUserAround(String id, int distance);
    public List<User> getHeplerAround(String id);
    public int getDistanceByUsers(User ua, User ub);
}
