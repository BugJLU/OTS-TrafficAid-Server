package org.bugjlu.ots_server.web.controller;

import org.bugjlu.ots_server.po.User;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class test {
    @RequestMapping(value = "login", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public User login(HttpServletRequest request) {
        System.out.println(request.getParameter("a"));
        User result = new User();
        result.setId("111111");
        return result;
    }
}
