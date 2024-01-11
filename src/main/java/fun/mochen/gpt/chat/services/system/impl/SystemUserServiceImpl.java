package fun.mochen.gpt.chat.services.system.impl;

import cn.hutool.crypto.digest.BCrypt;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.mochen.gpt.chat.mapper.system.SystemUserMapper;
import fun.mochen.gpt.chat.model.dos.system.SystemUserDO;
import fun.mochen.gpt.chat.model.dtos.system.LoginRequestDTO;
import fun.mochen.gpt.chat.model.dtos.system.RegisterRequestDTO;
import fun.mochen.gpt.chat.services.system.SystemUserService;
import fun.mochen.gpt.chat.system.exceptions.ChatServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUserDO> implements SystemUserService {

    @Override
    public void userLogin(LoginRequestDTO loginRequestDTO) {
        SystemUserDO userInfo = getUserByUsername(loginRequestDTO.getUsername());
        if (userInfo == null) {
            throw new ChatServiceException(HttpStatus.UNAUTHORIZED, "用户名或密码错误");
        }
        if (BCrypt.checkpw(loginRequestDTO.getPassword(), userInfo.getPassword())) {
            return;
        }
        throw new ChatServiceException(HttpStatus.UNAUTHORIZED, "用户名或密码错误");
    }

    private SystemUserDO getUserByUsername(String username) {
        LambdaQueryWrapper<SystemUserDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SystemUserDO::getUsername, username);
        return this.getOne(wrapper);
    }

    @Override
    public void userRegister(RegisterRequestDTO registerRequestDTO) {

    }

    @Override
    public void getEmailCode(RegisterRequestDTO registerRequestDTO) {

    }
}
