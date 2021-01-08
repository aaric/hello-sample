package com.example.hello.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

/**
 * RandomUtilTests
 *
 * @author Aaric, created on 2020-12-03T17:49.
 * @version 0.1.0-SNAPSHOT
 */
@Slf4j
public class RandomUtilTests {

    @Test
    public void testNextInt() {
        int num = RandomUtil.nextInt(1, 1000000);
        log.info("num: {}", num);
        Assertions.assertNotEquals(1000000, num);
    }

    @RepeatedTest(100)
    public void testNextText() {
        int length = 6;
        String code = RandomUtil.nextText(1, length);
        log.info("code: {}", code);
        Assertions.assertEquals(length, code.length());
    }

    @RepeatedTest(10)
    public void testNextTextPwd() {
        int length = 8;
        String password1 = RandomUtil.nextText(length);
        String password2 = RandomUtil.nextText(length, false);
        log.info("password1: {}, password2: {}", password1, password2);
        Assertions.assertEquals(length, password1.length());
        Assertions.assertEquals(length, password2.length());
    }
}
