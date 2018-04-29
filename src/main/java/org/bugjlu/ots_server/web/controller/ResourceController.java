package org.bugjlu.ots_server.web.controller;

import org.bugjlu.ots_server.po.Resource;
import org.bugjlu.ots_server.service.ResourceService;
import org.bugjlu.ots_server.web.vo.ResourceIdCommand;
import org.bugjlu.ots_server.web.vo.ResourceInfoCommand;
import org.bugjlu.ots_server.web.vo.UserIdCommand;
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
    public Boolean addResource(@RequestBody ResourceInfoCommand rin) {
        Resource r =new Resource();
        get(r,rin);
        return resourceService.addResource(r);
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Boolean removeResource(@RequestBody ResourceIdCommand rid) {
        return resourceService.removeResource(rid.getId());
    }

    @RequestMapping(value = "getfrom", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public List<Resource> getResourcesFrom(@RequestBody UserIdCommand uid) {
        return resourceService.getResourcesFrom(uid.getId());
    }
    private void get(Resource r,ResourceInfoCommand rin){
        r.setPossessorId(rin.getPossessorId());
        r.setName(rin.getName());
        r.setType(rin.getType());
        r.setId(rin.getId());
    }
}
