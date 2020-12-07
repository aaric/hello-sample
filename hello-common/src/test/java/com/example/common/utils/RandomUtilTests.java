package com.example.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
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
        int num = RandomUtil.nextInt();
        log.info("num: {}", num);
        Assertions.assertNotEquals(-1, num);
    }

    @Test
    public void testNextIntBound() {
        int num = RandomUtil.nextInt(10);
        log.info("num: {}", num);
        Assertions.assertNotEquals(-1, num);
    }
}
