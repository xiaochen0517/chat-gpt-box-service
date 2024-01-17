package fun.mochen.gpt.chat.services.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.mochen.gpt.chat.mapper.system.SystemRolePermissionMapper;
import fun.mochen.gpt.chat.model.dos.system.SystemRolePermissionDO;
import fun.mochen.gpt.chat.services.system.SystemRolePermissionService;
import fun.mochen.gpt.chat.services.system.SystemRoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemRolePermissionServiceImpl extends ServiceImpl<SystemRolePermissionMapper, SystemRolePermissionDO> implements SystemRolePermissionService {

    @Autowired
    private SystemRoleUserService systemRoleUserService;

    @Override
    public List<Long> getPermissionIdsByUserId(Long userId) {
        List<Long> roleIds = systemRoleUserService.getRoleIdsByUserId(userId);
        LambdaQueryWrapper<SystemRolePermissionDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(SystemRolePermissionDO::getPermissionId).in(SystemRolePermissionDO::getRoleId, roleIds);
        return baseMapper.selectObjs(wrapper);
    }

}
