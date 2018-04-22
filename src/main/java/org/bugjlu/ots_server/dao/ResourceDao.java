package org.bugjlu.ots_server.dao;

import org.bugjlu.ots_server.po.Resource;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ResourceDao {
    Boolean addResource(Resource res);
    Boolean removeResource(String resId);
    Set<Resource> getResources(String id);
}
