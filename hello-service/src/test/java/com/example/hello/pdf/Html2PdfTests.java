package com.example.hello.pdf;

import com.example.hello.TestApp;
import com.example.hello.utils.RandomUtil;
import com.itextpdf.text.pdf.BaseFont;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Html2PdfTests
 *
 * @author Aaric, created on 2021-03-15T15:48.
 * @version 0.1.0-SNAPSHOT
 */
@Slf4j
@SpringBootTest(classes = TestApp.class)
@ExtendWith(SpringExtension.class)
public class Html2PdfTests {

    @Test
    public void testConvert() throws Exception {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_30);
        cfg.setClassLoaderForTemplateLoading(ClassLoader.getSystemClassLoader(), "/flts");
        Template sendAuthCodeTemplate = cfg.getTemplate("send_auth_code.flt");

        Map<String, String> data = new HashMap<>();
        data.put("code", RandomUtil.nextText(6));
        data.put("minutes", "30");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(sendAuthCodeTemplate, data);

        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(html);
        ITextFontResolver resolver = renderer.getFontResolver();
        resolver.addFont("D:\\TDDownload\\SimSun.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        renderer.layout();

        String desktopPath = System.getProperty("user.home") + File.separator
                + "Desktop" + File.separator;
        FileOutputStream testPdf = new FileOutputStream(desktopPath + "test.pdf");
        renderer.createPDF(testPdf);
        testPdf.close();
    }
}
