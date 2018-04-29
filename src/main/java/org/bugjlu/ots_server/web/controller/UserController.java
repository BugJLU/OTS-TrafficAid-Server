package org.bugjlu.ots_server.web.controller;

import org.bugjlu.ots_server.po.User;
import org.bugjlu.ots_server.service.UserService;
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


    @RequestMapping(value = "add", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Boolean addUser(@RequestBody  UserInfoCommand uin) {
        User u = new User();
        get(u,uin);
        return userService.addUser(u);
    }

//    @RequestMapping(value = "remove", method = RequestMethod.POST, produces = "application/json")
//    @ResponseBody
//    public Boolean removeUser(@RequestBody UserIdCommand uid) {
//        return false;
//    }

    @RequestMapping(value = "updateinfo", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public User updateUserInfo(@RequestBody UserInfoCommand uin) {
        User u = new User();
        get(u,uin);
        return userService.updateUserInfo(u);
    }

    @RequestMapping(value = "updategeo", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public User updateGeo(@RequestBody UserGeoCommand uge) {
        return userService.changeLocation(uge.getId(),uge.getGeoX(),uge.getGeoY());
    }

    @RequestMapping(value = "getinfo", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public User getUserInfo(@RequestBody UserIdCommand uid) {
        return userService.getUser(uid.getId());
    }

    @RequestMapping(value = "getuseraround", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public List<User> getUserAround(@RequestBody UserIdCommand uid) {
        return userService.getUserAround(uid.getId(),uid.getDistance());
    }

    @RequestMapping(value = "gethelperaround", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public List<User> getHeplerAround(@RequestBody UserIdCommand uid) {
        return userService.getHeplerAround(uid.getId());
    }

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
