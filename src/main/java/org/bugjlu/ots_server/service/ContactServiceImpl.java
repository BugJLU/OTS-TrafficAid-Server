package org.bugjlu.ots_server.service;

import org.bugjlu.ots_server.assistService.IntimacyService;
import org.bugjlu.ots_server.dao.ContactDao;
import org.bugjlu.ots_server.po.Contact;
import org.springframework.beans.factory.annotation.Autowired;

public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactDao contactDao;

    @Override
    public Boolean addContact(Contact contact) {
        if (contact.getGroupType() != null) {
            contact.setIntimacy(IntimacyService.get1JumpIntimacy(contact.getGroupType()));
        }
        return contactDao.addContact(contact.getSubjectId(), contact);
    }

    @Override
    public Boolean removeContact(String subjId, String ObjId) {
        return contactDao.removeContact(subjId, ObjId);
    }

    @Override
    public Contact GetContact(String subjId, String ObjId) {
        return contactDao.getContact(subjId, ObjId);
    }
}
