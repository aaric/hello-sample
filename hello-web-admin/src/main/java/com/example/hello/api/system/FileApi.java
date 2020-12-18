package com.example.hello.api.system;

import com.example.common.data.ApiData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 文件管理API接口
 *
 * @author Aaric, created on 2020-12-04T11:55.
 * @version 0.1.0-SNAPSHOT
 */
@Api(tags = "文件管理API")
public interface FileApi {

//    String create()

    @ApiOperation("查询文件信息")
    ApiData<Integer> get(@ApiParam(value = "ID", required = true, example = "1") Integer id);

    @ApiOperation("分页查询文件列表")
    ApiData<String> page(@ApiParam(value = "查询页码", required = true, example = "1") Integer index,
                         @ApiParam(value = "分页大小", required = true, example = "10") Integer size);
}
