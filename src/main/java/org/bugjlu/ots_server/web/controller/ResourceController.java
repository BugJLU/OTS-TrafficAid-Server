package org.bugjlu.ots_server.web.controller;

import org.bugjlu.ots_server.po.Resource;
import org.bugjlu.ots_server.web.vo.ResourceIdCommand;
import org.bugjlu.ots_server.web.vo.ResourceInfoCommand;
import org.bugjlu.ots_server.web.vo.UserIdCommand;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/resource")
public interface ResourceController {

    @RequestMapping(value = "add", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Boolean addResource(@RequestBody ResourceInfoCommand rin);

    @RequestMapping(value = "remove", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Boolean removeResource(@RequestBody ResourceIdCommand rid);

    @RequestMapping(value = "add", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public List<Resource> getResourcesFrom(@RequestBody  UserIdCommand uid);

}