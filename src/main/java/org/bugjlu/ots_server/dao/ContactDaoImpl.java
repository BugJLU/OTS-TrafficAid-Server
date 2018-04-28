package org.bugjlu.ots_server.dao;

import org.bugjlu.ots_server.po.Contact;
import org.bugjlu.ots_server.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ContactDaoImpl implements ContactDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Boolean addContact(String id, Contact contact) {
        String sql = "INSERT INTO contact VALUES " +
                "(?, ?, ?, ?)";
        Object[] args = {
                id,
                contact.getObjectId(),
                contact.getGroupType(),
                contact.getIntimacy()
        };
        try {
            if (jdbcTemplate.update(sql, args) > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            //TODO
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean removeContact(String subjId, String objId) {
        String sql = "DELETE FROM contact WHERE subjectId = ? AND objectId = ?";
        try {
            if (jdbcTemplate.update(sql, new Object[]{subjId, objId}) > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            //TODO
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Contact> getContacts(String id) {
        String sql = "SELECT * FROM contact WHERE subjectId = ?";
        try {
            List<Contact> l = jdbcTemplate.query(sql, new Object[]{id},
                    new BeanPropertyRowMapper<Contact>(Contact.class));
            return l;
        } catch (Exception e) {
            //TODO
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Contact getContact(String subjId, String objId) {
        String sql = "SELECT * FROM contact WHERE subjectId = ? AND objectId = ?";
        try {
            List<Contact> l = jdbcTemplate.query(sql, new Object[]{subjId, objId},
                    new BeanPropertyRowMapper<Contact>(Contact.class));
            if (l.size() < 1) return null;
            return l.get(0);
        } catch (Exception e) {
            //TODO
            e.printStackTrace();
            return null;
        }
    }
}
