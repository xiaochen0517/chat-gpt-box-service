package fun.mochen.gpt.chat.services.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.mochen.gpt.chat.mapper.system.SystemUserPermissionMapper;
import fun.mochen.gpt.chat.model.dos.system.SystemUserPermissionDO;
import fun.mochen.gpt.chat.services.system.SystemUserPermissionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemUserPermissionServiceImpl extends ServiceImpl<SystemUserPermissionMapper, SystemUserPermissionDO> implements SystemUserPermissionService {
    @Override
    public List<Long> getPermissionIdsByUserId(Long userId) {
        LambdaQueryWrapper<SystemUserPermissionDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(SystemUserPermissionDO::getPermissionId).eq(SystemUserPermissionDO::getUserId, userId);
        return baseMapper.selectObjs(wrapper);
    }
}
