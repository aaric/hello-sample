package com.example.hello.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Http Servlet Util
 *
 * @author Aaric, created on 2021-01-05T15:20.
 * @version 0.4.0-SNAPSHOT
 */
public final class HttpServletUtil {

    private HttpServletUtil() {
    }

    /**
     * HttpSession
     *
     * @return
     */
    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    /**
     * HttpServletRequest
     *
     * @return
     */
    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes())
                .getRequest();
    }

    /**
     * HttpServletResponse
     *
     * @return
     */
    public static HttpServletResponse getResponse() {
        return ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes())
                .getResponse();
    }
}