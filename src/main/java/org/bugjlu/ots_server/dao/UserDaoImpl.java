package org.bugjlu.ots_server.dao;

import org.bugjlu.ots_server.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public User getUser(String id) {
        String sql = "SELECT * FROM user WHERE id = ?";
        try {
            List<User> l = jdbcTemplate.query(sql,
                    new Object[] {id},
                    new BeanPropertyRowMapper<User>(User.class));
            if (l.size() > 0) {
                return l.get(0);
            } else {
                return null;
            }
        } catch (Exception e) {
            //TODO
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean addUser(User user) {
        String sql = "INSERT INTO user VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] args = new Object[] {
                user.getId(),
                user.getType(),
                user.getEmgContact(),
                user.getName(),
                user.getGender(),
                user.getIdCode(),
                user.getPlateNum(),
                user.getCarType(),
                user.getContactInfo(),
                user.getMediHist(),
                user.getGeoX(),
                user.getGeoY()
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
    public Boolean removeUser(String id) {
        String sql = "DELETE FROM user WHERE id = ?";
        try {
            if (jdbcTemplate.update(sql, new Object[]{id}) > 0) {
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
    public User updateUser(User user) {
        String sql = "UPDATE user SET " +
                "id = ?, type = ?, emgContact = ?, name = ?, gender = ?, idCode = ?, " +
                "plateNum = ?, carType = ?, contactInfo = ?, mediHist = ?, geoX = ?, geoY = ? " +
                "WHERE id = ?";
        Object[] args = new Object[] {
                user.getId(),
                user.getType(),
                user.getEmgContact(),
                user.getName(),
                user.getGender(),
                user.getIdCode(),
                user.getPlateNum(),
                user.getCarType(),
                user.getContactInfo(),
                user.getMediHist(),
                user.getGeoX(),
                user.getGeoY(),
                user.getId()
        };
        try {
            if (jdbcTemplate.update(sql, args) > 0) {
                return getUser(user.getId());
            } else {
                return null;
            }
        } catch (Exception e) {
            //TODO
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User updateGeo(String id, String geoX, String geoY) {
        String sql = "UPDATE user SET geoX = ?, geoY = ? WHERE id = ?";
        try {
            if (jdbcTemplate.update(sql, new Object[]{geoX, geoY, id}) > 0) {
                return getUser(id);
            } else {
                return null;
            }
        } catch (Exception e) {
            //TODO
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> getAllUser() {
        String sql = "SELECT * FROM user";
        try {
            List<User> l = jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<User>(User.class));
            return l;
        } catch (Exception e) {
            //TODO
            e.printStackTrace();
            return null;
        }
    }
}
