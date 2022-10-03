package com.zoey.site.entity.form;

import com.zoey.site.entity.po.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @ClassName RegistForm
 * @author: Zoey He
 * @data: 2022-09-29 20:06
 * @Description 用户注册
 */
@Data
@ApiModel(description = "注册表单")
public class RegisterForm extends BaseForm<User> {
    @ApiParam(name = "用户名", required = true)
    @NotBlank
    private String username;

    @ApiParam(name = "密码", required = true)
    @NotBlank
    private String password;

    @ApiParam(name = "性别 (0: 无性别 1: 男 2: 女)")
    private Byte sex;
    @ApiParam(name = "年龄")
    private Integer age;
    @ApiParam(name = "昵称")
    private String nickname;
}
