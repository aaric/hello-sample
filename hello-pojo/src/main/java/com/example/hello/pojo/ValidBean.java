package com.example.hello.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * 测试验证Bean
 *
 * @author Aaric, created on 2021-01-25T11:33.
 * @version 0.5.0-SNAPSHOT
 */
@Data
@Accessors(chain = true)
@ApiModel(description = "测试验证Bean")
public class ValidBean {

    @ApiModelProperty(position = 1, value = "ID")
    private Long id;

    @NotBlank(message = "非空白字符串校验")
    @ApiModelProperty(position = 2, value = "非空白字符串")
    private String notBlankString;
}
