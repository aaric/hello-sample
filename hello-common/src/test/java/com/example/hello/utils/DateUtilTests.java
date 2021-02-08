package com.example.hello.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * DateUtilTests
 *
 * @author Aaric, created on 2021-01-05T17:54.
 * @version 0.4.0-SNAPSHOT
 */
@Slf4j
public class DateUtilTests {

    @Test
    public void testFormat() {
        String str = DateUtil.format(new Date(), "yyyy-MM-dd");
        log.info("str: {}", str);
        Assertions.assertNotNull(str);

        str = DateUtil.format(new Date());
        log.info("str: {}", str);
        Assertions.assertNotNull(str);
    }

    @Test
    public void testParse() {
        Date date = DateUtil.parse("2021-01-06 00:00:00");
        log.info("date: {}", date);
        Assertions.assertNotNull(date);

        date = DateUtil.parse("2021-01-06", "yyyy-MM-dd");
        log.info("date: {}", date);
        Assertions.assertNotNull(date);
    }

    @Test
    public void testSecondsTo() {
        Date date = DateUtil.parse("2021-01-06 00:00:00");
        long seconds = DateUtil.secondsTo(date);
        log.info("seconds: {}", seconds);
//        Assertions.assertEquals(1609862400, seconds);
    }

    @Test
    public void testSecondsFrom() {
        long seconds = 1609862400L;
        Date date = DateUtil.secondsFrom(seconds);
        log.info("date: {}", date);
        Assertions.assertNotNull(date);

        String text = "1609862400";
        date = DateUtil.secondsFrom(text);
        log.info("date: {}", date);
        Assertions.assertNotNull(date);
    }
}
