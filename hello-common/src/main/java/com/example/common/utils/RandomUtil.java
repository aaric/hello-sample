package com.example.common.utils;

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
        return ThreadLocalRandom.current().nextInt();
    }
}
