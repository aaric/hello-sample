package com.example.hello.pdf;

import com.example.hello.utils.FreeMarkerUtil;
import com.example.hello.utils.PdfUtil;
import com.example.hello.utils.RandomUtil;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * PdfUtilTests
 *
 * @author Aaric, created on 2021-03-15T17:39.
 * @version 0.9.0-SNAPSHOT
 */
@Disabled
public class PdfUtilTests {

    @Test
    public void testHtml2pdf() throws Exception {
        Map<String, String> data = new HashMap<>();
        data.put("code", RandomUtil.nextText(0, 6));
        data.put("minutes", "30");

        String html = FreeMarkerUtil.process2String("send_auth_code.flt", data);
        String desktopPath = System.getProperty("user.home") + File.separator
                + "Desktop" + File.separator;
        PdfUtil.html2pdf(html, new File(desktopPath + "test.pdf"));
    }
}
