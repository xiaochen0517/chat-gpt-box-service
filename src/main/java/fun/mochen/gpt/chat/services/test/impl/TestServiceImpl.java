package fun.mochen.gpt.chat.services.test.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.mochen.gpt.chat.mapper.test.TestTableMapper;
import fun.mochen.gpt.chat.model.dos.test.TestTableDO;
import fun.mochen.gpt.chat.services.test.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl extends ServiceImpl<TestTableMapper, TestTableDO> implements TestService {
}
