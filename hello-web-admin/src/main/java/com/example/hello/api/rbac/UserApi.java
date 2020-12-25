package com.example.hello.api.rbac;

import com.example.hello.data.ApiData;
import com.example.hello.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 用户管理API接口
 *
 * @author Aaric, created on 2020-12-04T17:00.
 * @version 0.2.0-SNAPSHOT
 */
@Api(tags = "用户信息API")
public interface UserApi {

    @ApiOperation("创建用户档案")
    ApiData<User> create(@ApiParam User user);

    @ApiOperation("查询用户档案")
    ApiData<User> get(@ApiParam(value = "ID", required = true, example = "1") Long id);
}
