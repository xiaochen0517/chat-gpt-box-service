package fun.mochen.gpt.chat.system.exceptions;

import org.springframework.http.HttpStatusCode;

public class ChatServiceException extends ChatMainException {
    public ChatServiceException(HttpStatusCode code, String message) {
        super(code, message);
    }
}
