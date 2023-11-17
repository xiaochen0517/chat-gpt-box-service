package fun.mochen.gpt.chat.system.handler;

import cn.dev33.satoken.exception.NotLoginException;
import com.alibaba.fastjson2.JSON;
import fun.mochen.gpt.chat.model.base.AjaxResult;
import fun.mochen.gpt.chat.system.exceptions.ChatMainException;
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
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));
        return new ResponseEntity<>(AjaxResult.error(HttpStatus.BAD_REQUEST.value(), "参数错误", errors), headers, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotLoginException.class)
    public ResponseEntity<AjaxResult> handleNotLoginException(NotLoginException e) {
        return new ResponseEntity<>(AjaxResult.error(HttpStatus.UNAUTHORIZED.value(), "未登录"), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(ChatMainException.class)
    public ResponseEntity<AjaxResult> handleChatMainException(ChatMainException e) {
        return new ResponseEntity<>(AjaxResult.exception(e), e.getCode());
    }

}
