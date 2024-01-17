package fun.mochen.gpt.chat.services.system;

import com.baomidou.mybatisplus.extension.service.IService;
import fun.mochen.gpt.chat.model.dos.system.SystemRoleUserDO;

import java.util.List;

public interface SystemRoleUserService extends IService<SystemRoleUserDO> {

    List<Long> getRoleIdsByUserId(Long userId);

}
