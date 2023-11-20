package fun.mochen.gpt.chat.model.base;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ModelDO implements Serializable {

    private Long createUserId;

    private Long createUsername;

    private Date createTime;

    private Long updateUserId;

    private Long updateUsername;

    private Date updateTime;

    private Boolean isDeleted;

    private Long deleteUserId;

    private Long deleteUsername;

    private Date deleteTime;

    private String remark;

}
