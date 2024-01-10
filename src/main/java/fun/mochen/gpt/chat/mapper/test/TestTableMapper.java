package fun.mochen.gpt.chat.mapper.test;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import fun.mochen.gpt.chat.model.dos.test.TestTableDO;
import org.springframework.stereotype.Repository;

@Repository
public interface TestTableMapper extends BaseMapper<TestTableDO> {
}
