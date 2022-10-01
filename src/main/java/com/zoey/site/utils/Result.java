package com.zoey.site.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.zoey.site.exception.BaseException;
import com.zoey.site.exception.ErrorType;
import com.zoey.site.exception.SystemErrorType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.Instant;
import java.time.ZonedDateTime;

/**
 * @ClassName Result
 * @author: Zoey He
 * @data: 2022-09-29 19:03
 * @Description TODO
 */
@ApiModel(description = "rest 请求的返回封装类")
@Data
public class Result<T> {
    public static final String SUCCESS_CODE = "200";
    public static final String SUCCESS_MESSAGE = "处理成功";

    @ApiModelProperty(value = "处理结果 code", required = true)
    private String code;
    @ApiModelProperty(value = "处理结果描述信息")
    private String message;
    @ApiModelProperty(value = "处理结果时间戳")
    private Instant time;
    @ApiModelProperty(value = "处理结果数据信息")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public Result(){
        this.time = ZonedDateTime.now().toInstant();
    }

    public Result(ErrorType errorType){
        this.code = errorType.getCode();
        this.message = errorType.getMessage();
        this.time = ZonedDateTime.now().toInstant();
    }

    public Result(ErrorType errorType, T data){
        this(errorType);
        this.data = data;
    }

    private Result(String code, String message){
        this(code, message, null);
    }

    private Result(String code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
        this.time = ZonedDateTime.now().toInstant();
    }

    /**
     * 创建成功结果并返回数据
     * @param data
     * @param <T>
     * @return
     */
    public static<T> Result<T> success(T data){
        return new Result<>(SUCCESS_CODE, SUCCESS_MESSAGE, data);
    }

    /**
     * 创建成功结果，无数据
     * @return
     */
    public static Result success(){
        return success(null);
    }

    public static Result fail() {
        return new Result(SystemErrorType.SYSTEM_ERROR);
    }


    /**
     * BaseException 异常, 无返回结果
     * @param baseException
     * @return
     */
    public static Result fail(BaseException baseException){
        return fail(baseException, null);
    }

    /**
     * BaseException 异常并返回结果
     * @param baseException
     * @param data
     * @return
     */
    public static Result fail(BaseException baseException, Object data){
        return new Result<>(baseException.getErrorType(), data);
    }

    /**
     * ErrorType 异常并返回结果
     * @param errorType
     * @param data
     * @return
     */
    public static Result fail(ErrorType errorType, Object data){
        return new Result<>(errorType, data);
    }

    /**
     * ErrorType 异常, 无返回结果
     * @param errorType
     * @return
     */
    public static Result fail(ErrorType errorType){
        return fail(errorType, null);
    }

    public static Result fail(Object data){
        return new Result<>(SystemErrorType.SYSTEM_ERROR, data);
    }

    public static Result fail(int code, String message){
        return fail(String.valueOf(code), message);
    }

    public static Result fail(String code, String message){
        return new Result<>(code, message);
    }

    @JsonIgnore
    public boolean isSuccess(){
        return SUCCESS_CODE.equals(this.code);
    }

    @JsonIgnore
    public boolean isFail(){
        return !isSuccess();
    }
}
