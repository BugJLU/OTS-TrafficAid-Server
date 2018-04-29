package org.bugjlu.ots_server.service;

import org.bugjlu.ots_server.po.Contact;
import org.springframework.stereotype.Service;

@Service
public interface ContactService {
    public Boolean addContact(Contact contact);
    public Boolean removeContact(String subjId, String objId);
    public Contact GetContact(String subjId, String objId);
}
