package com.zoey.site.exception;

import com.zoey.site.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName ExceptionHandlerAdvice
 * @author: Zoey He
 * @data: 2022-09-30 7:16
 * @Description 捕获异常并返回给前端
 */
@Slf4j
@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(value = {BaseException.class})
    public Result baseException(BaseException ex, HttpServletRequest request){
        log.error("error path: {}", request.getRequestURI());
        log.error("base exception: {}", ex.getMessage());
        log.error(ex.getMessage(), ex);
        return Result.fail(ex.getErrorType());
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result exception(Exception ex, HttpServletRequest request){
        log.error("error path: {}", request.getRequestURI());
        log.error("base exception: {}", ex.getMessage());
        log.error(ex.getMessage(), ex);
        return Result.fail();
    }

    @ExceptionHandler(value = {Throwable.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result throwable(){
        return Result.fail();
    }
}
