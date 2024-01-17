package fun.mochen.gpt.chat.services.system;

import com.baomidou.mybatisplus.extension.service.IService;
import fun.mochen.gpt.chat.model.dos.system.SystemRolePermissionDO;

import java.util.List;

public interface SystemRolePermissionService extends IService<SystemRolePermissionDO> {
    List<Long> getPermissionIdsByUserId(Long userId);
}
