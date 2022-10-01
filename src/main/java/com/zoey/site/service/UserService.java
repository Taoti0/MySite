package com.zoey.site.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zoey.site.entity.form.RegisterForm;
import com.zoey.site.entity.form.UpdateUserForm;
import com.zoey.site.entity.po.User;

public interface UserService extends IService<User> {
    Long login(String username, String password);

    Long register(RegisterForm form);

    Long update(UpdateUserForm form);
}
