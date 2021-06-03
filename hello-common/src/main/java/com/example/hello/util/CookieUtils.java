package com.example.hello.util;

import javax.servlet.http.Cookie;

/**
 * Cookie Util
 *
 * @author Aaric, created on 2021-01-05T15:21.
 * @version 0.4.0-SNAPSHOT
 */
public final class CookieUtils {

    private CookieUtils() {
    }

    public static String getCookie(String cookieName) {

        Cookie[] cookies = HttpServletUtils.getRequest().getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                    return cookie.getValue();
                }
            }
        }

        return null;
    }

    public static void setCookie(String cookieName, String value, int cookieMaxAge) {
        Cookie cookie = new Cookie(cookieName, value);
        cookie.setPath("/");
        cookie.setMaxAge(cookieMaxAge);
        HttpServletUtils.getResponse().addCookie(cookie);
    }

    public static void deleteCookie(String cookieName) {
        setCookie(cookieName, null, 0);
    }
}
