package com.example.common.utils;

import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * JwtUtilTests
 *
 * @author Aaric, created on 2020-12-07T21:13.
 * @version 0.2.0-SNAPSHOT
 */
@Slf4j
public class JwtUtilTests {

    @Test
    public void testCreateToken() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("id", 1L);
        payload.put("oid", 1);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 7);
        String token = JwtUtil.createToken(payload, cal.getTime());
        log.info("token: {}", token);
        Assertions.assertNotNull(token);
    }

    @Test
    @Disabled
    public void testCheckToken() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwib2lkIjoxLCJleHAiOjE2MDc5NTM2MjB9.cB2Zreukxq3_J4bkjpQU_Koz3lu087ToEsdcD6yfPfQ";
        DecodedJWT jwt = JwtUtil.verifyToken(token);
        log.info("id: {}, oid: {}", jwt.getClaim("id").asLong(),
                jwt.getClaim("oid").asInt());
        Assertions.assertNotNull(jwt);
    }
}
