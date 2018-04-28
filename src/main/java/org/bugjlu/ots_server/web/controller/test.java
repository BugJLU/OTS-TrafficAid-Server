package org.bugjlu.ots_server.web.controller;

import org.bugjlu.ots_server.po.User;
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
public class test {
    @RequestMapping("/login")
    //@RequestMapping(value = "login", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<testvo> login(HttpServletRequest request) {
        System.out.println(request.getParameter("a"));
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
