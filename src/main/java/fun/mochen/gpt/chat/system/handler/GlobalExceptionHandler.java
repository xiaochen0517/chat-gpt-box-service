package fun.mochen.gpt.chat.system.handler;

import cn.dev33.satoken.exception.NotLoginException;
import fun.mochen.gpt.chat.model.base.AjaxResult;
import fun.mochen.gpt.chat.system.exceptions.ChatMainException;
import jakarta.annotation.Nullable;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            @Nullable HttpHeaders headers,
            @Nullable HttpStatusCode status,
            @Nullable WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));
        return new ResponseEntity<>(
                AjaxResult.error(HttpStatus.BAD_REQUEST.value(), "参数错误", errors),
                headers, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RedisConnectionFailureException.class)
    public ResponseEntity<AjaxResult<Object>> handleRedisConnectionFailureException(RedisConnectionFailureException ignored) {
        return new ResponseEntity<>(
                AjaxResult.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Redis连接失败"),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotLoginException.class)
    public ResponseEntity<AjaxResult<Object>> handleNotLoginException(NotLoginException ignored) {
        return new ResponseEntity<>(
                AjaxResult.error(HttpStatus.UNAUTHORIZED.value(), "未登录"),
                HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(ChatMainException.class)
    public ResponseEntity<AjaxResult<Object>> handleChatMainException(ChatMainException exception) {
        return new ResponseEntity<>(AjaxResult.exception(exception), exception.getCode());
    }

}
