package fun.mochen.gpt.chat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("fun.mochen.gpt.chat.mapper")
public class ChatGptBoxServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatGptBoxServiceApplication.class, args);
        System.out.println("------------------start success------------------");
    }

}
