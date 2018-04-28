package org.bugjlu.ots_server.service;

import org.bugjlu.ots_server.po.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ResourceService {
    public List<Resource> getResourcesFrom(String id);
    public Boolean removeResource(String rid);
    public Boolean addResource(Resource res);
}
