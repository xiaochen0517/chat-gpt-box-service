package fun.mochen.gpt.chat.services.system;

import com.baomidou.mybatisplus.extension.service.IService;
import fun.mochen.gpt.chat.model.dos.system.SystemUserPermissionDO;

import java.util.List;

public interface SystemUserPermissionService extends IService<SystemUserPermissionDO> {
    List<Long> getPermissionIdsByUserId(Long userId);
}
