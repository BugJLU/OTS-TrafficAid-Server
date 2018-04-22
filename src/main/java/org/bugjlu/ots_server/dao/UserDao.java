package org.bugjlu.ots_server.dao;

import org.bugjlu.ots_server.po.User;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserDao {
    User getUser(String id);
    Boolean addUser(User user);
    Boolean removeUser(String id);
    User updateUser(User user);
    User updateGeo(String geoX, String geoY);
    Set<User> getAllUser();
}
