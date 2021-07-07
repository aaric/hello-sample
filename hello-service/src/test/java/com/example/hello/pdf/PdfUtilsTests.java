package com.example.hello.pdf;

import com.example.hello.util.FreeMarkerUtils;
import com.example.hello.util.PdfUtils;
import com.example.hello.util.RandomUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * PdfUtilsTests
 *
 * @author Aaric, created on 2021-03-15T17:39.
 * @version 0.9.0-SNAPSHOT
 */
@Disabled
public class PdfUtilsTests {

    @Test
    public void testHtml2pdf() throws Exception {
        Map<String, String> data = new HashMap<>();
        data.put("code", RandomUtils.nextText(0, 6));
        data.put("minutes", "30");

        String html = FreeMarkerUtils.process2String("send_auth_code.flt", data);
        String desktopPath = System.getProperty("user.home") + File.separator
                + "Desktop" + File.separator;
        PdfUtils.html2pdf(html, new File(desktopPath + "test.pdf"));
    }
}
