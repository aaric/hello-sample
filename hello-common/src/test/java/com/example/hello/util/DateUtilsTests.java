package com.example.hello.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * DateUtilsTests
 *
 * @author Aaric, created on 2021-01-05T17:54.
 * @version 0.4.0-SNAPSHOT
 */
@Slf4j
public class DateUtilsTests {

    @Test
    public void testFormat() {
        String str = DateUtils.format(new Date(), "yyyy-MM-dd");
        log.info("str: {}", str);
        Assertions.assertNotNull(str);

        str = DateUtils.format(new Date());
        log.info("str: {}", str);
        Assertions.assertNotNull(str);
    }

    @Test
    public void testParse() {
        Date date = DateUtils.parse("2021-01-06 00:00:00");
        log.info("date: {}", date);
        Assertions.assertNotNull(date);

        date = DateUtils.parse("2021-01-06", "yyyy-MM-dd");
        log.info("date: {}", date);
        Assertions.assertNotNull(date);
    }

    @Test
    public void testSecondsTo() {
        Date date = DateUtils.parse("2021-01-06 00:00:00");
        long seconds = DateUtils.secondsTo(date);
        log.info("seconds: {}", seconds);
//        Assertions.assertEquals(1609862400, seconds);
    }

    @Test
    public void testSecondsFrom() {
        long seconds = 1609862400L;
        Date date = DateUtils.secondsFrom(seconds);
        log.info("date: {}", date);
        Assertions.assertNotNull(date);

        String text = "1609862400";
        date = DateUtils.secondsFrom(text);
        log.info("date: {}", date);
        Assertions.assertNotNull(date);
    }
}
