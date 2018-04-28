package org.bugjlu.ots_server.dao;

import org.bugjlu.ots_server.po.Contact;
import org.bugjlu.ots_server.po.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ResourceDaoImpl implements ResourceDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Boolean addResource(Resource res) {
        String sql = "INSERT INTO resource(type, possessorId, name) VALUES " +
                "(?, ?, ?)";
        Object[] args = {
                res.getType(),
                res.getPossessorId(),
                res.getName()
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
    public Boolean removeResource(Integer resId) {
        String sql = "DELETE FROM resource WHERE id = ?";
        try {
            if (jdbcTemplate.update(sql, new Object[]{resId}) > 0) {
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
    public List<Resource> getResources(String id) {
        String sql = "SELECT * FROM resource WHERE possessorId = ?";
        try {
            List<Resource> l = jdbcTemplate.query(sql, new Object[]{id},
                    new BeanPropertyRowMapper<Resource>(Resource.class));
            return l;
        } catch (Exception e) {
            //TODO
            e.printStackTrace();
            return null;
        }
    }
}
