package fun.mochen.gpt.chat.system.exceptions;

import org.springframework.http.HttpStatusCode;

public class ChatMainException extends RuntimeException {

    private final HttpStatusCode code;

    public ChatMainException(HttpStatusCode code, String message) {
        super(message);
        this.code = code;
    }

    public HttpStatusCode getCode() {
        return code;
    }
}
