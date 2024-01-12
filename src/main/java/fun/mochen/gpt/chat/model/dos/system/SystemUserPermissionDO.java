package fun.mochen.gpt.chat.model.dos.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import fun.mochen.gpt.chat.model.base.ModelDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("system_user_permission")
public class SystemUserPermissionDO extends ModelDO {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long userId;

    private Long permissionId;

}
