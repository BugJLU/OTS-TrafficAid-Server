package org.bugjlu.ots_server.dao;

import org.bugjlu.ots_server.po.Resource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ResourceDao {
    Boolean addResource(Resource res);
    Boolean removeResource(String resId);
    List<Resource> getResources(String id);
}
