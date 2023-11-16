package fun.mochen.gpt.chat.system.exceptions;

public class ChatMainException extends RuntimeException {

    private final int code;

    public ChatMainException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
