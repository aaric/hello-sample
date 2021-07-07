package com.example.hello.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * MimeTypeUtilsTests
 *
 * @author Aaric, created on 2021-06-03T13:49.
 * @version 0.11.0-SNAPSHOT
 */
@Slf4j
public class MimeTypeUtilsTests {

    @Test
    public void testGetContentType() {
        String contentType = MimeTypeUtils.getContentType("hello.pdf");
        log.debug("Content-Type: {}", contentType);
        Assertions.assertEquals("application/pdf", contentType);
    }
}
