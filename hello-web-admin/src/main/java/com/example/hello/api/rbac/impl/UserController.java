package com.example.hello.api.rbac.impl;

import com.example.hello.api.rbac.UserApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户管理API控制器
 *
 * @author Aaric, created on 2020-12-04T17:01.
 * @version 0.2.0-SNAPSHOT
 */
@RestController
@RequestMapping("/api/v1/admin/rbac/user")
public class UserController implements UserApi {
}
