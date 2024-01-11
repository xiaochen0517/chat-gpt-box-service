package fun.mochen.gpt.chat.model.dtos.system;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Data
public class LoginRequestDTO implements Serializable {

    @NotNull(message = "username can not be blank")
    @Length(min = 3, max = 20, message = "username length must be between 3 and 20")
    private String username;

    @NotNull(message = "password can not be blank")
    @Length(min = 6, max = 20, message = "password length must be between 8 and 20")
    private String password;

}
