package fun.mochen.gpt.chat.model.vos.system;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserLoginVO implements Serializable {

    private String username;

    private String nickname;

    private String email;

    private String phone;

    private List<String> permissions;

    private boolean admin;

}
