package fun.mochen.gpt.chat.model.dtos.system;

import lombok.Data;

@Data
public class LoginRequestDTO {
    private String username;
    private String password;
}
