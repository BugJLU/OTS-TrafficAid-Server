import net.sf.json.JSONObject;
import org.bugjlu.ots_server.assistService.MapService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@ContextConfiguration("/applicationContext.xml")
public class AssistTest extends AbstractTestNGSpringContextTests {
    @Test
    public void assistMapDisTest() {
        int d = MapService.getDistanceByPoints("116.364671","39.967157","116.372433","39.967433");
        System.out.println(d);
    }
    @Test
    public void assistJsonTest() {
        JSONObject jo = MapService.httpRequest("http://localhost:8080/login.json?a=123");
        System.out.println(jo);
    }
}
