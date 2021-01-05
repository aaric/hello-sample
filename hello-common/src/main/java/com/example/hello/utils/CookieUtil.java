package com.example.hello.utils;

import javax.servlet.http.Cookie;

/**
 * Cookie Util
 *
 * @author Aaric, created on 2021-01-05T15:21.
 * @version 0.4.0-SNAPSHOT
 */
public final class CookieUtil {

    private CookieUtil() {
    }

    public static String getCookie(String cookieName) {

        Cookie[] cookies = HttpServletUtil.getRequest().getCookies();
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
        HttpServletUtil.getResponse().addCookie(cookie);
    }

    public static void deleteCookie(String cookieName) {
        setCookie(cookieName, null, 0);
    }
}
