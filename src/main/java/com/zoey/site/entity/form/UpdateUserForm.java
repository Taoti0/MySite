package com.zoey.site.entity.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * @ClassName UpdateUserForm
 * @author: Zoey He
 * @data: 2022-10-01 19:23
 * @Description 修改用户信息
 */

@Data
@ApiModel(description = "修改用户信息")
public class UpdateUserForm {
    @ApiParam(name = "用户 ID", required = true)
    private Long id;
    @ApiParam(name = "用户名")
    private String username;
    @ApiParam(name = "性别 (0: 无性别 1: 男 2: 女)")
    private Byte sex;
    @ApiParam(name = "年龄")
    private Integer age;
    @ApiParam(name = "昵称")
    private String nickname;
    // 修改密码时的表单，上面的四个参数不需要
    @ApiParam(name = "旧密码")
    private String passwordOld;
    @ApiParam(name = "新密码")
    private String passwordNow;
}
