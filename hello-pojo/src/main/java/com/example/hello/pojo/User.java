package com.example.hello.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 用户档案
 *
 * @author Aaric, created on 2020-12-22T15:06.
 * @version 0.4.0-SNAPSHOT
 */
@Data
@Accessors(chain = true)
@ApiModel(description = "用户档案")
public class User {

    @ApiModelProperty(position = 1, value = "ID", example = "1")
    private Long id;

    @ApiModelProperty(position = 1, value = "用户名", example = "admin")
    private String username;

    @ApiModelProperty(position = 1, value = "密码")
    private String password;

    @ApiModelProperty(position = 1, value = "密码盐")
    private String passwordSalt;

    @ApiModelProperty(position = 1, value = "姓名", example = "超级管理员")
    private String name;

    @ApiModelProperty(position = 1, value = "性别：0-未知，1-男，2-女", example = "0")
    private Integer sex;

    //@JsonSerialize(using = WriteDateAsSecondsSerializer.class)
    //@JsonDeserialize(using = WriteDateAsSecondsDeserializer.class)
    @ApiModelProperty(position = 1, value = "出生日期", example = "1609862400")
    private Date birthday;
}
