package com.example.common.data;

import com.example.common.core.Constants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 请求API数据
 *
 * @param <T> 支付泛型
 * @author Aaric, created on 2020-12-18T14:07.
 * @version 0.2.0-SNAPSHOT
 */
@Data
@Accessors(chain = true)
@ApiModel(description = "请求API数据")
public class ApiData<T> {

    /**
     * 状态码：200-请求成功
     */
    @ApiModelProperty(position = 1, value = "状态码：200-请求成功")
    private Integer code = Constants.DEFAULT_SUCCESS;

    /**
     * 数据结果
     */
    @ApiModelProperty(position = 2, value = "数据结果")
    private T data;
}
