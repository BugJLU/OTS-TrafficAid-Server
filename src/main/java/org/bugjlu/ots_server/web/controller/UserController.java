package org.bugjlu.ots_server.web.controller;

import org.bugjlu.ots_server.po.User;
import org.bugjlu.ots_server.service.UserService;
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
    public Boolean addUser(@RequestBody  User u) {
        return userService.addUser(u);
    }

//    @RequestMapping(value = "remove", method = RequestMethod.POST, produces = "application/json")
//    @ResponseBody
//    public Boolean removeUser(@RequestBody UserIdCommand uid) {
//        return false;
//    }

    @RequestMapping(value = "updateinfo", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public User updateUserInfo(@RequestBody User u) {
        return userService.updateUserInfo(u);
    }

    @RequestMapping(value = "updategeo", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public User updateGeo(@RequestBody String id,String gx,String gy) {
        return userService.changeLocation(id,gx,gy);
    }

    @RequestMapping(value = "getinfo", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public User getUserInfo(@RequestBody String id) {
        return userService.getUser(id);
    }

    @RequestMapping(value = "getuseraround", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<User> getUserAround(@RequestBody String id,int distance) {
        return userService.getUserAround(id,distance);
    }

    @RequestMapping(value = "gethelperaround", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<User> getHeplerAround(@RequestBody String id) {
        return userService.getHeplerAround(id);
    }

}
