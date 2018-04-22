package org.bugjlu.ots_server.dao;

import org.bugjlu.ots_server.po.Contact;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ContactDao {
    Boolean addContact(String id, Contact contact);
    Boolean removeContact(String subjId, String objId);
    Set<Contact> getContacts(String id);
}
