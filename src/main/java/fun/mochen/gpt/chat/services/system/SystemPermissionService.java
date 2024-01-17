package fun.mochen.gpt.chat.services.system;

import com.baomidou.mybatisplus.extension.service.IService;
import fun.mochen.gpt.chat.model.dos.system.SystemPermissionDO;

import java.util.List;

public interface SystemPermissionService extends IService<SystemPermissionDO> {

    List<String> getPermissionByUserId(Long userId);

}
