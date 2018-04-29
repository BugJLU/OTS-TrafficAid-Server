package org.bugjlu.ots_server.web.controller;

import org.bugjlu.ots_server.po.User;
import org.bugjlu.ots_server.service.*;
import org.bugjlu.ots_server.web.vo.UserGeoCommand;
import org.bugjlu.ots_server.web.vo.UserIdCommand;
import org.bugjlu.ots_server.web.vo.UserInfoCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;


//    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Boolean addUser(@RequestBody  UserInfoCommand uin) {
        User u = new User();
        get(u,uin);
        Boolean flag = userService.addUser(u);
        System.out.println(flag);
        return flag;
    }

//    @Override
//    public Boolean removeUser(UserIdCommand uid) {
//        return null;
//    }
//
//    @Override
//    public User updateUserInfo(UserInfoCommand uin) {
//        return null;
//    }
//
//    @Override
//    public User updateGeo(UserGeoCommand uge) {
//        return null;
//    }
//
//    @Override
//    public User getUserInfo(UserIdCommand uid) {
//        return null;
//    }
//
//    @Override
//    public List<User> getUserAround(UserIdCommand uid) {
//        return null;
//    }
//
//    @Override
//    public List<User> getHeplerAround(UserIdCommand uid) {
//        return null;
//    }

    private void get(User u,UserInfoCommand uin){
        u.setId(uin.getId());
        u.setType(uin.getType());
        u.setEmgContact(uin.getEmgContact());
        u.setName(uin.getName());
        u.setGender(uin.getGender());
        u.setIdCode(uin.getIdCode());
        u.setPlateNum(uin.getPlateNum());
        u.setCarType(uin.getCarType());
        u.setContactInfo(uin.getContactInfo());
        u.setMediHist(uin.getMediHist());
    }
}
