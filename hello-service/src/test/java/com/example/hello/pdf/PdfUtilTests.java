package com.example.hello.pdf;

import com.example.hello.utils.PdfUtil;
import com.example.hello.utils.RandomUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.jupiter.api.Test;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * PdfUtilTests
 *
 * @author Aaric, created on 2021-03-15T17:39.
 * @version 0.9.0-SNAPSHOT
 */
public class PdfUtilTests {

    @Test
    public void testHtml2pdf() throws Exception {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_30);
        cfg.setClassLoaderForTemplateLoading(ClassLoader.getSystemClassLoader(), "/flts");
        Template sendAuthCodeTemplate = cfg.getTemplate("send_auth_code.flt");

        Map<String, String> data = new HashMap<>();
        data.put("code", RandomUtil.nextText(0, 6));
        data.put("minutes", "30");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(sendAuthCodeTemplate, data);

        String desktopPath = System.getProperty("user.home") + File.separator
                + "Desktop" + File.separator;
        PdfUtil.html2pdf(html, new File(desktopPath + "test.pdf"));
    }
}
