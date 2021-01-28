package com.example.hello.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

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

    @Negative(message = "被注释的元素必须是一个严格意义上的负数")
    @ApiModelProperty(position = 11, value = "例如：countdown")
    private int negative = 0;

    @NegativeOrZero(message = "被注释的元素必须是一个负数或者0")
    @ApiModelProperty(position = 12, value = "例如：countdown")
    private int negativeOrZero = 1;

    @Positive(message = "被注释的元素必须是一个严格意义上正数")
    @ApiModelProperty(position = 13, value = "例如：money")
    private int positive = 0;

    @PositiveOrZero(message = "被注释的元素必须是一个正数或者0")
    @ApiModelProperty(position = 14, value = "例如：money")
    private double positiveOrZero = -1;

    @Size(min = 5, max = 15, message = "被注释的元素的大小必须在指定的范围内（包含）")
    @ApiModelProperty(position = 15, value = "例如：username, array")
    private String size = "test";

    @Digits(integer = 6, fraction = 2, message = "被注释的元素必须是一个数字，其值必须在可接受的范围内")
    @ApiModelProperty(position = 16, value = "例如：money")
    private double digits = 0.001;

    @Past(message = "被注释的元素必须是一个过去的日期时间")
    @ApiModelProperty(position = 17, value = "例如：date")
    private Date past = new Date(1641009600000L);

    @PastOrPresent(message = "被注释的元素必须是一个过去的日期时间或者是当前日期时间")
    @ApiModelProperty(position = 18, value = "例如：date")
    private Date pastOrPresent = new Date(1641009600000L);

    @Future(message = "被注释的元素必须是一个将来的日期时间")
    @ApiModelProperty(position = 19, value = "例如：date")
    private Date future = new Date(1609473600000L);

    @FutureOrPresent(message = "被注释的元素必须是一个将来的日期时间或者当前日期时间")
    @ApiModelProperty(position = 20, value = "例如：date")
    private Date futureOrPresent = new Date(1609473600000L);

    @Pattern(regexp = "[A-F]\\d{6}", message = "被注释的元素必须符合指定的正则表达式")
    @ApiModelProperty(position = 21, value = "例如：string")
    private String pattern = "Y123456";

    @Email(message = "被注释的元素必须是电子邮箱地址")
    @ApiModelProperty(position = 22, value = "例如：email")
    private String email = "admin@-abc.com";
}
