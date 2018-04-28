import org.bugjlu.ots_server.po.Contact;
import org.bugjlu.ots_server.po.Resource;
import org.bugjlu.ots_server.po.User;
import org.bugjlu.ots_server.service.ContactService;
import org.bugjlu.ots_server.service.ResourceService;
import org.bugjlu.ots_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@ContextConfiguration("/applicationContext.xml")
public class ServiceTest extends AbstractTestNGSpringContextTests{
    @Autowired
    ContactService contactService;
    @Autowired
    ResourceService resourceService;
    @Autowired
    UserService userService;

    @Test
    public void contactTest() {
        Contact c = contactService.GetContact("7","4");
        System.out.println(c.getIntimacy());
        contactService.removeContact(c.getSubjectId(), c.getObjectId());
        c = contactService.GetContact("7","4");
        Assert.assertNull(c);
        c = new Contact();
        c.setSubjectId("3");
        c.setObjectId("8");
        c.setGroupType(0);
        contactService.addContact(c);
    }

    @Test
    public void resourceTest() {
        List<Resource> resources = resourceService.getResourcesFrom("3");
        Assert.assertNotNull(resources);
        for (Resource r :
                resources) {
            System.out.println(r.getId()+" "+r.getType()+" "+r.getName());
        }
        Resource r = resources.get(0);
        resourceService.removeResource(r.getId());
        r.setPossessorId("8");
        resourceService.addResource(r);
    }

    @Test
    public void userTest() {
        List<User> users = userService.getUserAround("7", 10000);
//        for (User u :
//                users) {
//            System.out.println(u.getId());
//        }
        users = userService.getHeplerAround("7");
        for (User u :
                users) {
            System.out.println(u.getId());
        }
    }
}
