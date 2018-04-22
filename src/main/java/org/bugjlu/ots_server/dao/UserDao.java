package org.bugjlu.ots_server.dao;

import org.bugjlu.ots_server.po.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    User getUser(String id);
    Boolean addUser(User user);
    Boolean removeUser(String id);
    User updateUser(User user);
    User updateGeo(String id, String geoX, String geoY);
    List<User> getAllUser();
}
