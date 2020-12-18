package com.example.common.data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 响应数据对象
 *
 * @param <T> 支付泛型
 * @author Aaric, created on 2020-12-18T14:07.
 * @version 0.2.0-SNAPSHOT
 */
@Data
@Accessors(chain = true)
@ApiModel(description = "响应数据对象")
public class ResponseData<T> {

    /**
     * 响应码：200-请求成功
     */
    @ApiModelProperty(position = 1, value = "响应码：200-请求成功")
    private Integer code = 200;

    /**
     * 返回数据对象
     */
    @ApiModelProperty(position = 2, value = "响应数据对象")
    private T data;
}
