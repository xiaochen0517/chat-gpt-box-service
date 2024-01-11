package fun.mochen.gpt.chat.model.dtos.system;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class RegisterRequestDTO implements Serializable {

    @NotBlank
    @Size(min = 3, max = 20, message = "username length must be between 3 and 20")
    private String username;

    @NotBlank
    @Size(min = 6, max = 20, message = "password length must be between 6 and 20")
    private String password;

    @NotBlank
    @Email(message = "email format is not correct")
    private String email;

}
