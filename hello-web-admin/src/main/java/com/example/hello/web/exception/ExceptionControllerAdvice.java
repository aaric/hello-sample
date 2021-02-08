package com.example.hello.web.exception;

import com.example.hello.core.Constants;
import com.example.hello.data.ApiData;
import com.example.hello.data.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常控制器建议
 *
 * @author Aaric, created on 2020-12-18T18:01.
 * @version 0.3.0-SNAPSHOT
 */
@Slf4j
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(ApiException.class)
    public ApiData<String> handleApiException(ApiException e) {
        return new ApiData<String>()
                .setCode(e.getCode())
                .setErrorMessage(e.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiData<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        Map<String, String> tips = new HashMap<>(e.getBindingResult().getAllErrors().size());
        bindingResult.getFieldErrors().forEach(error -> {
            tips.put(error.getField(), error.getDefaultMessage());
        });
        return new ApiData<Map<String, String>>()
                .setCode(600)
                .setErrorMessage("valid error")
                .setData(tips);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(Exception.class)
    public ApiData<String> handleDefaultException(Exception e) {
        return new ApiData<String>()
                .setCode(Constants.ApiCode.DEFAULT_ERROR)
                .setErrorMessage(e.getMessage());
    }
}
