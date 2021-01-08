package com.example.hello.json.spring;

import com.example.hello.utils.DateUtil;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/**
 * 日期转秒时间戳格式化器<br>
 * 针对SpringMvc Form表单，与DateAsSecondsConverter二选一，推荐DateAsSecondsFormatter
 *
 * @author Aaric, created on 2021-01-08T16:51.
 * @version 0.4.0-SNAPSHOT
 */
public class DateAsSecondsFormatter implements Formatter<Date> {

    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        return DateUtil.secondsFrom(text);
    }

    @Override
    public String print(Date object, Locale locale) {
        return String.valueOf(DateUtil.secondsTo(object));
    }
}
