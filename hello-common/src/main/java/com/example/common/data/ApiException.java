package com.example.common.data;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 请求API异常
 *
 * @author Aaric, created on 2020-12-18T16:33.
 * @version 0.3.0-SNAPSHOT
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class ApiException extends RuntimeException {

    /**
     * 状态码(200-请求成功，其它异常)
     */
    private Integer code;

    /**
     * 数据结果
     */
    private Object data;

    public ApiException(Integer code) {
        this.code = code;
    }

    public ApiException(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }

    public ApiException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ApiException(Integer code, String message, Object data) {
        super(message);
        this.code = code;
        this.data = data;
    }
}
