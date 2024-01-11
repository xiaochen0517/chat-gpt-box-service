package fun.mochen.gpt.chat.controller.system;

import cn.dev33.satoken.stp.StpUtil;
import fun.mochen.gpt.chat.model.base.AjaxResult;
import fun.mochen.gpt.chat.model.dtos.system.LoginRequestDTO;
import fun.mochen.gpt.chat.services.system.SystemUserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private SystemUserService systemUserService;

    @PostMapping("login")
    public AjaxResult<Object> login(@RequestBody @Valid LoginRequestDTO loginRequestDTO) {
        systemUserService.userLogin(loginRequestDTO);
        return AjaxResult.success("登录成功");
    }

    @PostMapping("logout")
    public AjaxResult<Object> logout() {
        StpUtil.logout();
        return AjaxResult.success("登出成功");
    }
}
