package com.example.hello.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

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

    @Null(message = "被注释的元素必须为null")
    @ApiModelProperty(position = 1, value = "例如：extendId")
    private Long beNull = 1L;

    @NotNull(message = "被注释的元素不能为null")
    @ApiModelProperty(position = 2, value = "例如：username")
    private String notNull = null;

    @NotEmpty(message = "被注释的字符串的必须非空，可以是空白字符串")
    @ApiModelProperty(position = 3, value = "例如：username")
    private String notEmpty = "";

    @NotBlank(message = "被注释的字符串的必须非空，不能是空白字符串")
    @ApiModelProperty(position = 2, value = "非空白字符串")
    private String notBlank = "\t";
}
