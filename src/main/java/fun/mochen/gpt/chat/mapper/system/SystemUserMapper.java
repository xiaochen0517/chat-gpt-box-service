package fun.mochen.gpt.chat.mapper.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import fun.mochen.gpt.chat.model.dos.system.SystemUserDO;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemUserMapper extends BaseMapper<SystemUserDO> {
}
