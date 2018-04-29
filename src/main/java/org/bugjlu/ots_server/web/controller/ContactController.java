package org.bugjlu.ots_server.web.controller;


import org.bugjlu.ots_server.po.Contact;
import org.bugjlu.ots_server.web.vo.ContactCommand;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/contact")
public interface ContactController {

    @RequestMapping(value = "add", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Boolean addContact(@RequestBody ContactCommand cc);

    @RequestMapping(value = "remove", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Boolean removeContact(@RequestBody ContactCommand cc);

    @RequestMapping(value = "getinfo", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Contact GetContact(@RequestBody ContactCommand cc);

}
