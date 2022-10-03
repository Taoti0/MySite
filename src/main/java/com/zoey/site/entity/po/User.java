package com.zoey.site.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @ClassName User
 * @author: Zoey He
 * @data: 2022-09-28 14:08
 * @Description 用户信息
 */
@Data
@TableName("user")
@ApiModel(value = "用户信息", description = "用户表")
public class User extends BasePo implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableField("username")
    private String username;
    @TableField("password")
    private String password;
    @TableField("sex")
    private Byte sex;
    @TableField("age")
    private Integer age;
    @TableField("nickname")
    private String nickname;
    @TableLogic("deleted")
    private Byte deleted;
}
