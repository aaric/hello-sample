package com.example.hello.api.test;

import com.example.hello.data.ApiData;
import com.example.hello.pojo.ValidBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

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

    @ApiOperation("上传文件")
    ApiData<String> upLoadFile(@ApiParam(value = "测试文件", required = true) @RequestPart MultipartFile uploadFile);

    @ApiOperation("数据校验")
    ApiData<Long> valid(@ApiParam(value = "用户档案") ValidBean validBean) throws Exception;

    @ApiOperation("数据校验（自定义）")
    ApiData<Long> validCustom(@ApiParam(value = "用户档案") ValidBean validBean) throws Exception;

    @ApiOperation("MQTT")
    ApiData<String> mqtt(@ApiParam(value = "主题") String topic,
                         @ApiParam(value = "消息内容") String content) throws Exception;

    @ApiOperation("LDAP")
    ApiData<Boolean> ldap(@ApiParam(value = "用户名") String account,
                          @ApiParam(value = "密码") String secret) throws Exception;
}
