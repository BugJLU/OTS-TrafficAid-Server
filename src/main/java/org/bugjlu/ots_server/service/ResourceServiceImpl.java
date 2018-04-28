package org.bugjlu.ots_server.service;

import org.bugjlu.ots_server.dao.ResourceDao;
import org.bugjlu.ots_server.po.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ResourceServiceImpl implements ResourceService {

    @Autowired
    ResourceDao resourceDao;

    @Override
    public List<Resource> getResourcesFrom(String id) {
        return resourceDao.getResources(id);
    }

    @Override
    public Boolean removeResource(Integer rid) {
        return resourceDao.removeResource(rid);
    }

    @Override
    public Boolean addResource(Resource res) {
        return resourceDao.addResource(res);
    }
}
