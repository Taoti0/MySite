package com.zoey.site.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.zoey.site.entity.form.RegisterForm;
import com.zoey.site.entity.form.UpdateUserForm;
import com.zoey.site.entity.po.User;
import com.zoey.site.exception.BaseException;
import com.zoey.site.exception.SystemErrorType;
import com.zoey.site.mapper.UserMapper;
import com.zoey.site.service.UserService;
import com.zoey.site.utils.Snowflake;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @ClassName UserServiceImpl
 * @author: Zoey He
 * @data: 2022-09-28 14:04
 * @Description TODO
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public Long login(String username, String password) {
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUsername, username));
        if(null == user)
            throw new BaseException(SystemErrorType.USER_NOT_EXIST);
        if(!password.equals(user.getPassword()))
            throw new BaseException(SystemErrorType.LOGIN_ERROR_PASSWORD);
        return user.getId();
    }

    @Override
    public boolean register(User user) {
        if(null != userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUsername, user.getUsername())))
            throw new BaseException(SystemErrorType.REGISTER_ERROR_EXIST);
        if (1 == userMapper.insert(user))
            return true;
        else
            throw new BaseException(SystemErrorType.REGISTER_ERROR);
    }

    @Override
    public boolean update(UpdateUserForm form) {
        Long id = form.getId();
        if(null == userMapper.selectById(id))
            throw new BaseException(SystemErrorType.USER_NOT_EXIST);
        // 修改用户其他信息
        if(form.getPasswordOld().isEmpty()){
            if(1 != userMapper.updateInfo(form))
                throw new BaseException(SystemErrorType.UPDATE_ERROR);
        }
        // 仅修改用户密码
        else{
            if (userMapper.updatePSW(form) != 1)
                throw new BaseException(SystemErrorType.UPDATE_ERROR_PASSWORD);
        }
        return true;
    }
}
