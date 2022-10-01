package com.zoey.site.exception;

import lombok.Getter;

/**
 * @ClassName BaseException
 * @author: Zoey He
 * @data: 2022-09-29 19:14
 * @Description 自定义异常
 */
@Getter
public class BaseException extends RuntimeException {
    private final ErrorType errorType;

    // 默认是系统异常
    public BaseException(){
        this.errorType = SystemErrorType.SYSTEM_ERROR;
    }

    public BaseException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public BaseException(ErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }

    public BaseException(ErrorType errorType, String message, Throwable cause){
        super(message, cause);
        this.errorType = errorType;
    }
}
