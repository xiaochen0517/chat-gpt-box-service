package fun.mochen.gpt.chat.services.system;

import cn.hutool.crypto.digest.BCrypt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

    @Test
    public void testUserLogin() {
        System.out.println("testUserLogin");
    }

    @Test
    public void testUserPasswordEncrypt() {
        String password = "user1234";
        String hashpw = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println(hashpw);
        Assertions.assertTrue(BCrypt.checkpw(password, hashpw));
    }
}
