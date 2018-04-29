import org.bugjlu.ots_server.service.UserService;
import org.bugjlu.ots_server.web.controller.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@ContextConfiguration("/applicationContext.xml")
public class ControllerTest extends AbstractTestNGSpringContextTests {

    @Autowired
    UserService userService;

    @Autowired
    UserController userController;

    @Test
    public void controllerTest() {
        userService.getUser("1");
    }
}
