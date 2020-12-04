package com.example.hello.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 文件管理API接口
 *
 * @author Aaric, created on 2020-12-04T11:55.
 * @version 0.1.0-SNAPSHOT
 */
@Api(tags = "文件管理API")
public interface FileApi {

    @ApiOperation("分页查询文件列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "index", paramType = "path", dataType = "Integer", required = true, example = "1"),
            @ApiImplicitParam(name = "size", paramType = "path", dataType = "Integer", required = true, example = "10"),
    })
    String page(Integer index, Integer size);
}
