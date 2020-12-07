package com.example.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.Map;

/**
 * JWT工具类<br>
 *
 * @author Aaric, created on 2020-12-07T13:38.
 * @version 0.2.0-SNAPSHOT
 * @see <a href="https://github.com/auth0/java-jwt">Java JWT</a>
 */
public class JwtUtil {

    /**
     * 默认密钥
     */
    private static final String DEFAULT_SECRET = "!QAZ@WSX#EDC";

    /**
     * 创建令牌
     *
     * @param payload   自定义数据
     * @param expiresAt 过期时间
     * @return
     */
    public static String createToken(Map<String, String> payload, Date expiresAt) {
        JWTCreator.Builder builder = JWT.create();
        if (null != payload && 0 != payload.size()) {
            payload.forEach((key, value) -> builder.withClaim(key, value));
        }
        builder.withExpiresAt(expiresAt);
        return builder.sign(Algorithm.HMAC256(DEFAULT_SECRET));
    }

    /**
     * 校验令牌
     *
     * @param token 令牌字符串
     * @return
     */
    public static DecodedJWT verifyToken(String token) {
        return JWT.require(Algorithm.HMAC256(DEFAULT_SECRET))
                .build()
                .verify(token);
    }
}
