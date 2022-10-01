package com.zoey.site.exception;

import lombok.Getter;

/**
 * @ClassName SystemErrorType
 * @author: Zoey He
 * @data: 2022-09-29 19:17
 * @Description 自定义系统异常
 */
@Getter
public enum  SystemErrorType implements ErrorType {
    SYSTEM_ERROR("-1", "系统异常"),
    SYSTEM_ERROR_UNKNOWN("500001", "未知错误"),
    // 后续补充
    LOGIN_ERROR("100000", "密码错误"),
    LOGIN_ERROR_NONE("100001", "用户不存在"),

    REGISTER_ERROR("100010", "当前用户已存在"),
    REGISTER_ERROR_EXIST("100011", "当前用户已存在"),
    ;

    private String code;
    private String message;

    SystemErrorType(String code, String message){
        this.code = code;
        this.message = message;
    }
}
