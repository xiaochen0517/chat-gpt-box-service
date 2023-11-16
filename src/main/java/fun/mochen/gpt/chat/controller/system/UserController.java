package fun.mochen.gpt.chat.controller.system;

import cn.dev33.satoken.stp.StpUtil;
import fun.mochen.gpt.chat.model.dtos.system.LoginRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("test")
    public String test() {
        return "hello world";
    }

    @PostMapping("login")
    public String login(@RequestBody LoginRequestDTO loginRequestDTO) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if ("user".equals(loginRequestDTO.getUsername()) && "user".equals(loginRequestDTO.getPassword())) {
            StpUtil.login(10001);
            return "登录成功";
        }
        return "登录失败";
    }

    @PostMapping("logout")
    public String logout() {
        StpUtil.logout();
        return "登出成功";
    }
}
