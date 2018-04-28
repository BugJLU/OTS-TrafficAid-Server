import org.bugjlu.ots_server.dao.UserDao;
import org.bugjlu.ots_server.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@ContextConfiguration("/applicationContext.xml")
public class UserDaoTest extends AbstractTestNGSpringContextTests {
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
}
