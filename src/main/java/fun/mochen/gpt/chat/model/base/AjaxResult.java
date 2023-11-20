package fun.mochen.gpt.chat.model.base;

import fun.mochen.gpt.chat.system.exceptions.ChatMainException;
import lombok.Data;

import java.io.Serializable;

@Data
public class AjaxResult<T> implements Serializable {

    private boolean success;

    private int code;

    private String message;

    private T data;

    public AjaxResult(int code, String message) {
        this.success = getSuccessByCode(code);
        this.code = code;
        this.message = message;
    }

    public AjaxResult(int code, String message, T data) {
        this.success = getSuccessByCode(code);
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> AjaxResult<T> success() {
        return new AjaxResult<>(200, "success");
    }

    public static <T> AjaxResult<T> success(String message) {
        return new AjaxResult<>(200, message);
    }

    public static <T> AjaxResult<T> success(T data) {
        return new AjaxResult<>(200, "success", data);
    }

    public static <T> AjaxResult<T> success(String message, T data) {
        return new AjaxResult<>(200, message, data);
    }

    public static <T> AjaxResult<T> error() {
        return new AjaxResult<>(500, "error");
    }

    public static <T> AjaxResult<T> error(String message) {
        return new AjaxResult<>(500, message);
    }

    public static <T> AjaxResult<T> error(int code, String message) {
        return new AjaxResult<>(code, message);
    }

    public static <T> AjaxResult<T> error(int code, String message, T data) {
        return new AjaxResult<>(code, message, data);
    }

    public static <T> AjaxResult<T> error(String message, T data) {
        return new AjaxResult<>(500, message, data);
    }

    public static <T> AjaxResult<T> error(T data) {
        return new AjaxResult<>(500, "error", data);
    }

    public static <T> AjaxResult<T> error(int code) {
        return new AjaxResult<>(code, "error");
    }

    public static <T> AjaxResult<T> exception(ChatMainException exception) {
        return new AjaxResult<>(exception.getCode().value(), exception.getMessage());
    }

    public static <T> AjaxResult<T> exception(ChatMainException exception, T data) {
        return new AjaxResult<>(exception.getCode().value(), exception.getMessage(), data);
    }

    private static boolean getSuccessByCode(int code) {
        return code > 200 && code < 300;
    }

}
