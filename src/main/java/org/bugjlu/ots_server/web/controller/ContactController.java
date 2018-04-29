package org.bugjlu.ots_server.web.controller;


import org.bugjlu.ots_server.po.Contact;
import org.bugjlu.ots_server.service.ContactService;
import org.bugjlu.ots_server.service.UserService;
import org.bugjlu.ots_server.web.vo.ContactCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    ContactService contactService;

    @RequestMapping(value = "add", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Boolean addContact(@RequestBody ContactCommand cc){
        Contact c = new Contact();
        get(c,cc);
        return contactService.addContact(c);
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Boolean removeContact(@RequestBody ContactCommand cc) {
        return contactService.removeContact(cc.getSubjectId(),cc.getObjectId());
    }

    @RequestMapping(value = "getinfo", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Contact GetContact(@RequestBody ContactCommand cc) {
        return contactService.GetContact(cc.getSubjectId(),cc.getObjectId());
    }

    private void get(Contact c,ContactCommand cc){
        c.setObjectId(cc.getObjectId());
        c.setSubjectId(cc.getSubjectId());
        c.setGroupType(cc.getGroupType());
        c.setIntimacy(cc.getIntimacy());
    }
}
