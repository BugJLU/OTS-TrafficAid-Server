package org.bugjlu.ots_server.web.controller;

import org.bugjlu.ots_server.po.Resource;
import org.bugjlu.ots_server.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    ResourceService resourceService;

    @RequestMapping(value = "add", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Boolean addResource(@RequestBody Resource res) {
        return resourceService.addResource(res);
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Boolean removeResource(@RequestBody Integer rid) {
        return resourceService.removeResource(rid);
    }

    @RequestMapping(value = "getfrom", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Resource> getResourcesFrom(@RequestBody String id) {
        return resourceService.getResourcesFrom(id);
    }
}
