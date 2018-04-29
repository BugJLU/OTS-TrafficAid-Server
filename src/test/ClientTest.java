import org.bugjlu.ots_server.web.vo.UserIdCommand;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;

public class ClientTest extends AbstractTestNGSpringContextTests {
    static RestTemplate restTemplate;
    static String URL = "http://localhost:8080/";
    static {
        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    }
    public static Object getObject(String req, Object obj) {
        return restTemplate.postForObject(URL+req, obj, obj.getClass());
    }

    @Test
    public void cliTest() {
        UserIdCommand userIdCommand = new UserIdCommand();
        userIdCommand.setId("3");
        userIdCommand.setDistance(10000);
        getObject("getuseraround", userIdCommand);
    }
}
