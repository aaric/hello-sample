package com.example.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
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
    public static String createToken(Map<String, Object> payload, Date expiresAt) {
        JWTCreator.Builder builder = JWT.create();
        if (null != payload && 0 != payload.size()) {
            payload.forEach((key, value) -> {
                if (value instanceof Boolean) {
                    builder.withClaim(key, (Boolean) value);
                } else if (value instanceof Integer) {
                    builder.withClaim(key, (Integer) value);
                } else if (value instanceof Long) {
                    builder.withClaim(key, (Long) value);
                } else if (value instanceof Double) {
                    builder.withClaim(key, (Double) value);
                } else if (value instanceof String) {
                    builder.withClaim(key, (String) value);
                } else if (value instanceof Date) {
                    builder.withClaim(key, (Date) value);
                }
            });
        }
        builder.withExpiresAt(expiresAt);
        return builder.sign(Algorithm.HMAC256(DEFAULT_SECRET));
    }

    /**
     * 校验令牌
     *
     * @param token 令牌字符串
     * @return
     * @throws AlgorithmMismatchException     算法不匹配异常
     * @throws SignatureVerificationException 签名校验异常
     * @throws TokenExpiredException          令牌过期异常
     * @throws InvalidClaimException          失效的payload异常
     */
    public static DecodedJWT verifyToken(String token) throws AlgorithmMismatchException,
            SignatureVerificationException, TokenExpiredException, InvalidClaimException {
        return JWT.require(Algorithm.HMAC256(DEFAULT_SECRET))
                .build()
                .verify(token);
    }
}
