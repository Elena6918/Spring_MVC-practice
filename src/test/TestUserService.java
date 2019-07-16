package test;

import com.skill.domain.User;
import com.skill.domain.UserWork;
import com.skill.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/applicationContext.xml"})
@WebAppConfiguration
public class TestUserService {
    @Autowired
    private UserService userService;

    @Test
    public void hasMatchUser() {
        boolean b1 = userService.hasMatchUser("admin", "123456");
        boolean b2 = userService.hasMatchUser("admin", "1111");
        assertTrue(b1);
        assertTrue(!b2);
    }

    @Test
    public void testFindUserByUserName() {
        User user = userService.findUserByUserName("admin");
        assertEquals(user.getUserId(), 1);
        assertEquals(user.getUserName(), "admin");
    }

    @Test
    public void testAddLoginLog() {
        User user = userService.findUserByUserName("admin");
        user.setUserId(1);
        user.setUserName("admin");
        user.setLastIp("192.168.12.7");
        user.setLastVisit(new Date());
        userService.loginSuccess(user);
    }

    @Test
    public void testFindWorkByWorkName(){
        UserWork userWork = userService.findWorkByWorkName("my feeling");
        assertEquals(userWork.getWorkId(), 1);
        assertEquals(userWork.getWorkContent(),"Hello there~");
    }
}