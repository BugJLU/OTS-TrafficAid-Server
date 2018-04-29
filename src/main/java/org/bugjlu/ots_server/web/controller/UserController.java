package org.bugjlu.ots_server.web.controller;

import org.bugjlu.ots_server.web.vo.UserIdCommand;
import org.bugjlu.ots_server.web.vo.UserInfoCommand;
import org.bugjlu.ots_server.web.vo.UserGeoCommand;
import org.bugjlu.ots_server.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/user")
public interface UserController {

    @RequestMapping(value = "add", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Boolean addUser(@RequestBody UserInfoCommand uin);

    @RequestMapping(value = "remove", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Boolean removeUser(@RequestBody UserIdCommand uid);

    @RequestMapping(value = "updateinfo", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public User updateUserInfo(@RequestBody UserInfoCommand uin);

    @RequestMapping(value = "updategeo", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public User updateGeo(@RequestBody UserGeoCommand uge);

    @RequestMapping(value = "getinfo", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public User getUserInfo(@RequestBody UserIdCommand uid);

    @RequestMapping(value = "getuseraround", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public List<User> getUserAround(@RequestBody UserIdCommand uid);

    @RequestMapping(value = "gethelperaround", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public List<User> getHeplerAround(@RequestBody UserIdCommand uid);

}
