package com.example.hello.json.spring;

import com.example.hello.util.DateUtils;
import org.springframework.core.convert.converter.Converter;

import java.util.Date;

/**
 * 秒时间转日期转换器<br>
 * 针对SpringMvc Form表单，与DateAsSecondsFormatter二选一，推荐DateAsSecondsFormatter
 *
 * @author Aaric, created on 2021-01-08T16:50.
 * @version 0.4.0-SNAPSHOT
 */
public class DateAsSecondsConverter implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        return DateUtils.secondsFrom(source);
    }
}
