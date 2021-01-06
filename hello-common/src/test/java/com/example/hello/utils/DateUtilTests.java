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

        date = DateUtil.parse(1609862400);
        log.info("date: {}", date);
        Assertions.assertNotNull(date);
    }
}
