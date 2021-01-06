package com.example.hello.utils;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Random Util
 *
 * @author Aaric, created on 2020-12-03T17:47.
 * @version 0.1.0-SNAPSHOT
 */
public final class RandomUtil {

    private RandomUtil() {
    }

    /**
     * 产生一个int随机数
     *
     * @param origin 最小值（包含）
     * @param bound  边界（不包含）
     * @return
     */
    public static int nextInt(int origin, int bound) {
        return ThreadLocalRandom.current().nextInt(origin, bound);
    }

    /**
     * 产生一串int随机字符串（适用手机验证码）
     *
     * @param origin 最小值（包含）
     * @param length 字符串长度
     * @return
     */
    public static String nextText(int origin, int length) {
        String format = "%0" + length + "d";
        int bound = Double.valueOf(Math.pow(10, length)).intValue();
        return String.format(format, nextInt(origin, bound));
    }
}
