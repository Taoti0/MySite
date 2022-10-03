package com.zoey.site.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zoey.site.entity.form.UpdateUserForm;
import com.zoey.site.entity.po.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<User> {
    int updateInfo(@Param("param") UpdateUserForm form);
    int updatePSW(@Param("param") UpdateUserForm form);
}
