package com.example.hello.util;

import com.itextpdf.text.pdf.BaseFont;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileOutputStream;

/**
 * PDF工具类
 *
 * @author Aaric, created on 2021-03-15T17:29.
 * @version 0.9.0-SNAPSHOT
 */
public final class PdfUtils {

    /**
     * 指定PDF扩展字体
     */
    public static final String[] PDF_ATTACH_FONTS = new String[]{
            "D:\\TDDownload\\SimSun.ttf"
    };

    /**
     * 转换HTML为PDF文件
     *
     * @param html   HTML文本
     * @param output 输出PDF文件
     * @throws Exception
     */
    public static void html2pdf(String html, File output) throws Exception {
        // set html
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(html);

        // add fonts
        ITextFontResolver resolver = renderer.getFontResolver();
        for (int i = 0; i < PDF_ATTACH_FONTS.length; i++) {
            resolver.addFont(PDF_ATTACH_FONTS[i], BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        }
        renderer.layout();

        // output
        FileOutputStream testPdf = new FileOutputStream(output.getAbsolutePath());
        renderer.createPDF(testPdf);
        testPdf.close();
    }
}
