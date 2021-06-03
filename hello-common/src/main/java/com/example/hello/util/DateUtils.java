package com.example.hello.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * Date Util
 *
 * @author Aaric, created on 2021-01-05T17:47.
 * @version 0.4.0-SNAPSHOT
 */
@Slf4j
public final class DateUtils {

    /**
     * 日期格式化模式字符串
     */
    public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private DateUtils() {
    }

    /**
     * 日期格式化为字符串
     *
     * @param date    日期
     * @param pattern 模式字符串
     * @return
     */
    public static String format(Date date, String pattern) {
        return DateFormatUtils.format(date, pattern);
    }

    /**
     * 日期格式化模式字符串
     *
     * @param date 日期
     * @return
     */
    public static String format(Date date) {
        return format(date, DEFAULT_PATTERN);
    }

    /**
     * 格式化模式字符串为日期
     *
     * @param str     日期字符串
     * @param pattern 模式字符串
     * @return
     */
    public static Date parse(String str, String pattern) {
        try {
            return org.apache.commons.lang3.time.DateUtils.parseDate(str, pattern);
        } catch (ParseException e) {
            log.error("parse exception", e);
        }
        return null;
    }

    /**
     * 格式化模式字符串为日期
     *
     * @param str 日期字符串
     * @return
     */
    public static Date parse(String str) {
        return parse(str, DEFAULT_PATTERN);
    }

    /**
     * 日期转换为秒时间戳
     *
     * @param date 日期
     * @return
     */
    public static long secondsTo(Date date) {
        return date.getTime() / 1000L;
    }

    /**
     * 秒时间戳转换为日期
     *
     * @param seconds 秒时间戳
     * @return
     */
    public static Date secondsFrom(long seconds) {
        return new Date(seconds * 1000L);
    }

    /**
     * 秒时间戳转换为日期
     *
     * @param text 秒时间戳字符串
     * @return
     */
    public static Date secondsFrom(String text) {
        return secondsFrom(Long.valueOf(text.trim()));
    }
}
