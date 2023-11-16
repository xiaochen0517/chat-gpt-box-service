package fun.mochen.gpt.chat.system.handler;

import cn.dev33.satoken.exception.NotLoginException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotLoginException.class)
    public String handleNotLoginException(NotLoginException e) {
        System.out.println("未登录");
        return "未登录";
    }
}
