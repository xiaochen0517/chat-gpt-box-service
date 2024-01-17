package fun.mochen.gpt.chat.services.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.mochen.gpt.chat.mapper.system.SystemPermissionMapper;
import fun.mochen.gpt.chat.model.dos.system.SystemPermissionDO;
import fun.mochen.gpt.chat.services.system.SystemPermissionService;
import fun.mochen.gpt.chat.services.system.SystemRolePermissionService;
import fun.mochen.gpt.chat.services.system.SystemUserPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SystemPermissionServiceImpl extends ServiceImpl<SystemPermissionMapper, SystemPermissionDO> implements SystemPermissionService {

    @Autowired
    private SystemRolePermissionService systemRolePermissionService;

    @Autowired
    private SystemUserPermissionService systemUserPermissionService;

    @Override
    public List<String> getPermissionByUserId(Long userId) {
        List<Long> rolePermissionIds = systemRolePermissionService.getPermissionIdsByUserId(userId);
        List<Long> userPermissionIds = systemUserPermissionService.getPermissionIdsByUserId(userId);
        // merge and De-duplication permission ids
        Set<Long> permissionIdSet = new HashSet<>(rolePermissionIds);
        permissionIdSet.addAll(userPermissionIds);
        List<Long> permissionIds = List.copyOf(permissionIdSet);
        // select role permissions
        LambdaQueryWrapper<SystemPermissionDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(SystemPermissionDO::getPermission).in(SystemPermissionDO::getId, permissionIds);
        return baseMapper.selectObjs(wrapper);
    }
}
