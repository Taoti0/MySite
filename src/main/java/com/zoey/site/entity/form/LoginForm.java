package com.zoey.site.entity.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * @ClassName LoginForm
 * @author: Zoey He
 * @data: 2022-09-28 14:24
 * @Description 用户登陆
 */
@Data
@ApiModel(description = "登陆表单")
public class LoginForm {
    @ApiParam(name = "用户名", required = true)
    private String username;
    @ApiParam(name = "密码", required = true)
    private String password;
}
