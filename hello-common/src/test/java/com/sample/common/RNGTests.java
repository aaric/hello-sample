package com.sample.common;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.rng.UniformRandomProvider;
import org.apache.commons.rng.simple.RandomSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * RNGTests
 *
 * @author Aaric, created on 2020-12-03T17:34.
 * @version 0.1.0-SNAPSHOT
 */
@Slf4j
public class RNGTests {

    @Test
    public void testNext() {
        UniformRandomProvider rng = RandomSource.create(RandomSource.MT);
        int num = rng.nextInt(10);
        log.info("num: {}", num);
        Assertions.assertNotEquals(-1, num);
    }
}
