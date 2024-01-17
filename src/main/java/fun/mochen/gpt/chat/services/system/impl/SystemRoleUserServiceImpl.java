package fun.mochen.gpt.chat.services.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.mochen.gpt.chat.mapper.system.SystemRoleUserMapper;
import fun.mochen.gpt.chat.model.dos.system.SystemRoleUserDO;
import fun.mochen.gpt.chat.services.system.SystemRoleUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemRoleUserServiceImpl extends ServiceImpl<SystemRoleUserMapper, SystemRoleUserDO> implements SystemRoleUserService {
    @Override
    public List<Long> getRoleIdsByUserId(Long userId) {
        LambdaQueryWrapper<SystemRoleUserDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(SystemRoleUserDO::getRoleId).eq(SystemRoleUserDO::getUserId, userId);
        return baseMapper.selectObjs(wrapper);
    }
}
