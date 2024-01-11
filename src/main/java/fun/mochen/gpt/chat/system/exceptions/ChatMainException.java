package fun.mochen.gpt.chat.system.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatusCode;

@Getter
public class ChatMainException extends RuntimeException {

    private final HttpStatusCode code;

    public ChatMainException(HttpStatusCode code, String message) {
        super(message);
        this.code = code;
    }

}
