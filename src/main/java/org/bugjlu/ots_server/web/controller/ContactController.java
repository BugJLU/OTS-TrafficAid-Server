package org.bugjlu.ots_server.web.controller;


import org.bugjlu.ots_server.po.Contact;
import org.bugjlu.ots_server.service.ContactService;
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
    public Boolean addContact(@RequestBody Contact contact){
        return contactService.addContact(contact);
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Boolean removeContact(String subjId, String objId) {
        return contactService.removeContact(subjId,objId);
    }

    @RequestMapping(value = "getinfo", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Contact GetContact(String subjId, String objId) {
        return contactService.GetContact(subjId,objId);
    }
}
