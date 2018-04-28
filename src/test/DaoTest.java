import org.bugjlu.ots_server.dao.ContactDao;
import org.bugjlu.ots_server.dao.ResourceDao;
import org.bugjlu.ots_server.dao.UserDao;
import org.bugjlu.ots_server.po.Contact;
import org.bugjlu.ots_server.po.Resource;
import org.bugjlu.ots_server.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@ContextConfiguration("/applicationContext.xml")
public class DaoTest extends AbstractTestNGSpringContextTests {
    @Autowired
    UserDao userDao;

    @Test
    public void userTest() {
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(String.valueOf(i));
            user.setType(1);
//            user.setEmgContact("0");
            user.setName("NNN"+i);
            user.setGender(i%2);
            user.setIdCode(String.valueOf(i));
            user.setPlateNum("PNPN"+i);
            user.setCarType("CTCT"+i);
            user.setContactInfo("CICI"+i);
            user.setMediHist("MHMH"+i);
            user.setGeoX("X"+i);
            user.setGeoX("Y"+i);
            boolean suc = userDao.addUser(user);
            Assert.assertTrue(suc);
        }
        boolean suc = userDao.removeUser(String.valueOf(5));
        Assert.assertTrue(suc);
        List<User> users = userDao.getAllUser();
        for (User u :
                users) {
            System.out.println(u.getName());
        }
        User u = userDao.getUser("3");
        System.out.println(u.getName());
        u = userDao.updateGeo("8", "123", "456");
        Assert.assertEquals(u.getGeoX(), "123");
        u.setId("2");
        User u2 = userDao.updateUser(u);
        Assert.assertEquals(u2.getName(), u.getName());
        u.setId("12");
        u = userDao.updateUser(u);
        Assert.assertNull(u);
    }

    @Autowired
    ContactDao contactDao;

    @Test
    public void contactTest() {
        for (int i = 0; i < 5; i++) {
            Contact c = new Contact();
            c.setSubjectId("7");
            c.setObjectId(String.valueOf(i));
            c.setIntimacy((double)i/10);
            boolean b = contactDao.addContact(c.getSubjectId(), c);
            Assert.assertTrue(b);
        }
        List<Contact> contacts = contactDao.getContacts("9");
        Assert.assertNotNull(contacts);
        for (Contact c:
                contacts) {
            System.out.println(c.getIntimacy());
        }
//        Assert.assertTrue(contactDao.removeContact("9", "1"));
        Assert.assertFalse(contactDao.removeContact("9", "1"));
        Assert.assertFalse(contactDao.removeContact("8", "3"));

    }

    @Autowired
    ResourceDao resourceDao;

    @Test
    public void resourceTest() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                Resource r = new Resource();
                r.setName("blabla"+i+j);
                r.setPossessorId(String.valueOf(i));
                r.setType((i+j)%2);
                boolean b = resourceDao.addResource(r);
                Assert.assertTrue(b);
            }
        }
        List<Resource> resources = resourceDao.getResources("3");
        Assert.assertNotNull(resources);
        for (Resource r :
                resources) {
            System.out.println(r.getName()+" "+r.getType());
            if (r.getId()%2 == 0) {
                boolean b = resourceDao.removeResource(r.getId());
                Assert.assertTrue(b);
            }
        }
        boolean b = resourceDao.removeResource(9981);
        Assert.assertFalse(b);
    }

}
