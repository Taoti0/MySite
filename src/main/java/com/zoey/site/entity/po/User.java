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
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Long id;
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
    @TableField("createdTime")
    private LocalDateTime createdTime;
    @TableField("updatedTime")
    private LocalDateTime updatedTime;

    public User(Long id, String username, String password, Byte sex, Integer age,
                String nickname, LocalDateTime createdTime, LocalDateTime updatedTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.nickname = nickname;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }
}
