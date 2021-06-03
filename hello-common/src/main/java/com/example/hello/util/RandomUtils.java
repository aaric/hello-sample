package com.example.hello.util;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Random Util
 *
 * @author Aaric, created on 2020-12-03T17:47.
 * @version 0.1.0-SNAPSHOT
 */
public final class RandomUtils {

    /**
     * 人类不会混淆的密码字符串数组，排除易混淆字符串：0, 1, l, o, z, I, O, Z
     */
    public static final char[] HUMAN_NOT_CONFUSE_CHARS = new char[]{
            '!', '@', '#', '%', '*',
            '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'm', 'n',
            'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N',
            'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
    };

    private RandomUtils() {
    }

    /**
     * 随机生成一个数字
     *
     * @param origin 最小值（包含）
     * @param bound  边界（不包含）
     * @return
     */
    public static int nextInt(int origin, int bound) {
        return ThreadLocalRandom.current().nextInt(origin, bound);
    }

    /**
     * 随机生成一个字符串（适用纯数字验证码）
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

    /**
     * 随机生成一个字符串
     *
     * @param length  字符串长度
     * @param special 是否包括特殊字符
     * @return
     */
    public static String nextText(int length, boolean special) {
        char[] chars = new char[length];
        int origin = 0;
        int bound = HUMAN_NOT_CONFUSE_CHARS.length;

        if (!special) {
            origin = 5;
        }

        for (int i = 0; i < length; i++) {
            chars[i] = HUMAN_NOT_CONFUSE_CHARS[nextInt(origin, bound)];
        }
        return String.copyValueOf(chars);
    }

    /**
     * 随机生成一个字符串（适用密码字符串）
     *
     * @param length 字符串长度
     * @return
     */
    public static String nextText(int length) {
        return nextText(length, true);
    }
}
