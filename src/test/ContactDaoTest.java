import org.bugjlu.ots_server.dao.ContactDao;
import org.bugjlu.ots_server.po.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@ContextConfiguration("/applicationContext.xml")
public class ContactDaoTest extends AbstractTestNGSpringContextTests {
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
}
