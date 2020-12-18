package com.example.common.data;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 请求API异常
 *
 * @author Aaric, created on 2020-12-18T16:33.
 * @version 0.3.0-SNAPSHOT
 */
@Data
@Accessors(chain = true)
public class ApiException extends Exception {

    /**
     * 状态码(200-请求成功，其它异常)
     */
    private Integer code;

    /**
     * 异常信息
     */
    private String message;

    /**
     * 数据结果
     */
    private Object data;
}
