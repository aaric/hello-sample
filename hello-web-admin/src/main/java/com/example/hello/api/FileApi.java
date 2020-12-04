package com.example.hello.api;

import io.swagger.annotations.*;

/**
 * 文件管理API接口
 *
 * @author Aaric, created on 2020-12-04T11:55.
 * @version 0.1.0-SNAPSHOT
 */
@Api(tags = "文件管理API")
public interface FileApi {

    @ApiOperation("查询文件信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ID", paramType = "path", dataType = "Integer", required = true, example = "1"),
    })
    String get(Integer id);

    @ApiOperation("分页查询文件列表")
    String page(@ApiParam(value = "查询页码3", required = true, example = "1") Integer index,
                @ApiParam(value = "分页大小3", required = true, example = "10") Integer size);
}
