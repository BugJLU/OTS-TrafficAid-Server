package org.bugjlu.ots_server.web.controller;

import org.springframework.stereotype.Controller;
import org.bugjlu.ots_server.web.vo.AddUserCommand;
import org.bugjlu.ots_server.web.vo.RemoveUserCommand;
import org.bugjlu.ots_server.web.vo.UpdateUserInfoCommand;
import org.bugjlu.ots_server.web.vo.UpdateUserGeoCommand;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public interface UserController {

    @RequestMapping("/add")
    Boolean addUser(@RequestBody AddUserCommand auc);

    @RequestMapping("/remove")
    Boolean removeUser(@RequestBody RemoveUserCommand ruc);

    @RequestMapping("/updateinfo")
    Boolean updateUserInfo(@RequestBody UpdateUserInfoCommand uuic);

    @RequestMapping("updategeo")
    Boolean updateGeo(@RequestBody UpdateUserGeoCommand uugc);

}
