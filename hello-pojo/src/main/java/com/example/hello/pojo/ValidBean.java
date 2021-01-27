package com.example.hello.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.*;
import java.math.BigDecimal;

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
    @ApiModelProperty(position = 4, value = "例如：username")
    private String notBlank = "\t";

    @AssertTrue(message = "被注释的元素必须为true")
    @ApiModelProperty(position = 5, value = "暂无")
    private boolean assertTrue = false;

    @AssertFalse(message = "被注释的元素必须为false")
    @ApiModelProperty(position = 6, value = "暂无")
    private boolean assertFalse = true;

    @Min(value = 18, message = "被注释的元素必须是一个数字，其值必须大于等于指定的最小值")
    @ApiModelProperty(position = 7, value = "例如：age")
    private long min = 10;

    @Max(value = 120, message = "被注释的元素必须是一个数字，其值必须小于等于指定的最大值")
    @ApiModelProperty(position = 8, value = "例如：age")
    private long max = 140;

    @DecimalMin(value = "0", inclusive = false, message = "被注释的元素必须是一个数字，其值必须大于等于指定的最小值")
    @ApiModelProperty(position = 9, value = "例如：salary")
    private BigDecimal decimalMin = BigDecimal.ZERO;

    @DecimalMax(value = "0", inclusive = false, message = "被注释的元素必须是一个数字，其值必须小于等于指定的最大值")
    @ApiModelProperty(position = 10, value = "例如：salary")
    private BigDecimal decimalMax = BigDecimal.ZERO;

    @Positive(message = "被注释的元素必须是一个严格意义上正数")
    @ApiModelProperty(position = 11, value = "例如：money")
    private int positive = 0;

    @PositiveOrZero(message = "被注释的元素必须是一个正数或者0")
    @ApiModelProperty(position = 12, value = "例如：money")
    private double positiveOrZero = -1;

    @Size(min = 5, max = 15, message = "被注释的元素的大小必须在指定的范围内（包含）")
    @ApiModelProperty(position = 13, value = "例如：username, array")
    private String size = "test";
}
