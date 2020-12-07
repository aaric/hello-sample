package com.example.common.utils;

import org.apache.commons.rng.simple.RandomSource;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 随机器
 *
 * @author Aaric, created on 2020-12-03T17:47.
 * @version 0.1.0-SNAPSHOT
 */
public class RandomUtil {

    /**
     * 产生一个int随机数
     *
     * @return
     */
    public static final int nextInt() {
        return RandomSource.create(RandomSource.MT).nextInt();
    }

    /**
     * 产生一个int随机数
     *
     * @param bound 边界
     * @return
     */
    public static final int nextInt(int bound) {
        return ThreadLocalRandom.current().nextInt(bound);
    }
}
