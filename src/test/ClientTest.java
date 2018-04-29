import org.bugjlu.ots_server.po.User;
import org.bugjlu.ots_server.web.vo.UserIdCommand;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@ContextConfiguration("/applicationContext.xml")
public class ClientTest extends AbstractTestNGSpringContextTests {
    static RestTemplate restTemplate;
    static String URL = "http://localhost:8080/";
    static {
        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    }
    public static Object getObject(String req, Object obj) {
        List<User> ul = new ArrayList<>();
        ParameterizedTypeReference<List<User>> typeRef = new ParameterizedTypeReference<List<User>>() {
        };
        ResponseEntity<List<User>> responseEntity = restTemplate.exchange(URL+req,
                HttpMethod.POST,
                new HttpEntity<>(obj),
                typeRef);
        List<User> result = responseEntity.getBody();
        return result;
    }

    @Test
    public void cliTest() {
        UserIdCommand userIdCommand = new UserIdCommand();
        userIdCommand.setId("3");
        userIdCommand.setDistance(10000);
        List<User> i = (List<User>) getObject("user/getuseraround", userIdCommand);
        for (User u :
                i) {
            System.out.println(u.getId());
        }
    }
}
