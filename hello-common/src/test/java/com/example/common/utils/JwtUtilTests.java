package com.example.common.utils;

import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
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
        Map<String, String> payload = new HashMap<>();
        payload.put("id", "1");
        payload.put("oid", "1");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 7);
        String token = JwtUtil.createToken(payload, cal.getTime());
        log.info("token: {}", token);
        Assertions.assertNotNull(token);
    }

    @Test
    public void TestCheckToken() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6IjEiLCJvaWQiOiIxIiwiZXhwIjoxNjA3OTUyOTQ4fQ.Ou5pc9qtCGANSkCC4z83HtCtuZxZlXMUeBIw6ZLSS10";
        DecodedJWT jwt = JwtUtil.verifyToken(token);
        log.info("id: {}, oid: {}", jwt.getClaim("id").asString(),
                jwt.getClaim("oid").asString());
        Assertions.assertNotNull(jwt);
    }
}
