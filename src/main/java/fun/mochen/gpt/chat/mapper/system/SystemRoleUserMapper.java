package fun.mochen.gpt.chat.mapper.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import fun.mochen.gpt.chat.model.dos.system.SystemRoleUserDO;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemRoleUserMapper extends BaseMapper<SystemRoleUserDO> {
}
