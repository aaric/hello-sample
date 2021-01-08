package com.example.hello.api.test;

import com.example.hello.data.ApiData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.Date;

/**
 * 测试模块API接口
 *
 * @author Aaric, created on 2020-12-18T15:09.
 * @version 0.1.0-SNAPSHOT
 */
@Api(tags = "测试模块API")
public interface TestApi {

    @ApiOperation("打招呼")
    ApiData<String> hello(@ApiParam(value = "消息", example = "Hello, World!") String msg) throws Exception;

    @ApiOperation("文本转json")
    String text2json() throws Exception;

    @ApiOperation("简单日期表单")
    ApiData<Date> form(@ApiParam(value = "日期", example = "1609862400") Date creationTime) throws Exception;
}
