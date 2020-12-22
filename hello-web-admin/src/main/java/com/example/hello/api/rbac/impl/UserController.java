package com.example.hello.api.rbac.impl;

import com.example.hello.api.rbac.UserApi;
import com.example.hello.data.ApiData;
import com.example.hello.pojo.UserInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 用户管理API控制器
 *
 * @author Aaric, created on 2020-12-04T17:01.
 * @version 0.2.0-SNAPSHOT
 */
@RestController
@RequestMapping("/api/v1/admin/rbac/user")
public class UserController implements UserApi {

    @Override
    @GetMapping("/{id}")
    public ApiData<UserInfo> get(@PathVariable Long id) {
        UserInfo userInfo = new UserInfo()
                .setId(id)
                .setUsername("admin")
                .setPassword(null)
                .setPasswordSalt(null)
                .setName("超级管理员")
                .setSex(0)
                .setBirthday(new Date());
        return new ApiData<UserInfo>().setData(userInfo);
    }
}
