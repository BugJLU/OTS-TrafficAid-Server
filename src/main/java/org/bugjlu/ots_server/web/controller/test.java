package org.bugjlu.ots_server.web.controller;

import org.bugjlu.ots_server.po.User;
import org.bugjlu.ots_server.web.vo.UserIdCommand;
import org.bugjlu.ots_server.web.vo.testvo;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/test")
public class test {
    @RequestMapping(value = "login", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public List<testvo> login(@RequestBody UserIdCommand uid) {
        System.out.println(uid.getId());
        testvo result1 = new testvo();
        testvo result2 = new testvo();
        result1.setId("111111");
        result2.setId("222222");
        List<testvo> lv = new ArrayList<>();
        lv.add(result1);
        lv.add(result2);
        return lv;
    }
}
