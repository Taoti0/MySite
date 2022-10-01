package com.zoey.site.controller;

import com.zoey.site.entity.form.LoginForm;
import com.zoey.site.entity.form.RegisterForm;
import com.zoey.site.service.UserService;
import com.zoey.site.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName LoginController
 * @author: Zoey He
 * @data: 2022-09-28 13:46
 * @Description TODO
 */

@RestController("/user")
@Api(tags = "用户管理")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ApiOperation(value = "用户登陆", notes = "添加登陆")
    public Result<Long> login(@RequestBody LoginForm form){
        Long id = userService.login(form.getUsername(), form.getPassword());
        return Result.success(id);
    }

    @PostMapping("/register")
    @ApiOperation(value = "注册用户", notes = "注册用户")
    public Result<Long> register(@RequestBody RegisterForm form){
        Long id = userService.register(form);
        return Result.success(id);
    }
}
