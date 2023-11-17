package fun.mochen.gpt.chat.controller.system;

import cn.dev33.satoken.stp.StpUtil;
import fun.mochen.gpt.chat.model.base.AjaxResult;
import fun.mochen.gpt.chat.model.dtos.system.LoginRequestDTO;
import fun.mochen.gpt.chat.system.exceptions.ChatServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
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
    public AjaxResult login(@RequestBody @Validated LoginRequestDTO loginRequestDTO) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if ("user".equals(loginRequestDTO.getUsername()) && "user".equals(loginRequestDTO.getPassword())) {
            StpUtil.login(10001);
            return AjaxResult.success("登录成功");
        }
        throw new ChatServiceException(HttpStatus.UNAUTHORIZED, "用户名或密码错误");
    }

    @PostMapping("logout")
    public AjaxResult logout() {
        StpUtil.logout();
        return AjaxResult.success("登出成功");
    }
}
