package com.zoey.site.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
    public Long register(RegisterForm form) {
        if(null != userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUsername, form.getUsername())))
            throw new BaseException(SystemErrorType.REGISTER_ERROR_EXIST);
        Long id = new Snowflake().nextId();
        User user = new User(id, form.getUsername(), form.getPassword(), form.getSex(),
                form.getAge(), form.getNickname(), LocalDateTime.now(), LocalDateTime.now());
        if (1 == userMapper.insert(user))
            return id;
        else
            throw new BaseException(SystemErrorType.REGISTER_ERROR);
    }

    @Override
    public Long update(UpdateUserForm form) {
        Long id = form.getId();
        User user = userMapper.selectById(id);
        if(null == user)
            throw new BaseException(SystemErrorType.USER_NOT_EXIST);
        // 仅修改密码的情况：密码不为空且与数据库中的密码相同
        if (!form.getPasswordOld().isEmpty()) {
            if (user.getPassword().equals(form.getPasswordOld())) {
                user.setPassword(form.getPasswordNow());
                if (1 != userMapper.updateById(user))
                    throw new BaseException(SystemErrorType.UPDATE_ERROR);
                return id;
            } else
                throw new BaseException(SystemErrorType.UPDATE_ERROR_PASSWORD);
        }

        // 修改用户其他信息的情况
        user.setUsername(form.getUsername());
        user.setAge(form.getAge());
        user.setSex(form.getSex());
        user.setNickname(form.getNickname());
        if(1 != userMapper.updateById(user))
            throw new BaseException(SystemErrorType.UPDATE_ERROR);
        return id;
    }
}
