package fun.mochen.gpt.chat.services.system;

import com.baomidou.mybatisplus.extension.service.IService;
import fun.mochen.gpt.chat.model.dos.system.SystemUserDO;
import fun.mochen.gpt.chat.model.dtos.system.LoginRequestDTO;
import fun.mochen.gpt.chat.model.dtos.system.RegisterRequestDTO;

public interface SystemUserService extends IService<SystemUserDO> {

    void userLogin(LoginRequestDTO loginRequestDTO);

    void userRegister(RegisterRequestDTO registerRequestDTO);

    void getEmailCode(RegisterRequestDTO registerRequestDTO);

}
