package com.pegasus.test.qr.html2Pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by enHui.Chen on 2020/4/13.
 */
public class Html2Pdf {
    private static final String YMDD_CONTENT = "<div style=\"margin-left: 30.0pt;margin-bottom: 11.0pt;\">\n" +
            "<div style=\"float:left\">\n" +
            "<p class=\"c0\"><img src=\"http://test-eam1.yimidida.com/aatn/v1/0/asset-info/qrcode-image?codeType=QR&amp;assetNum=${encodeAssetNum}\" style=\"width:60pt;height:60pt;\" alt=\"An Image\" /><br/></p>\n" +
            "</div>\n" +
            "<div style=\"float:left\">\n" +
            "<p class=\"t1\"><span class=\"c2\">壹米滴答</span></p>\n" +
            "<p class=\"c1\"><span class=\"c2\">资产条码:${assetNum}</span></p>\n" +
            "<p class=\"c1\"><span class=\"c2\">资产名称:${assetName}</span></p>\n" +
            "<p class=\"c1\"><span class=\"c2\">品牌:${brand}</span></p>\n" +
            "<p class=\"c1\"><span class=\"c2\">规格:${model}</span></p>\n" +
            "</div>\n" +
            "</div>\n" +
            "<div style=\"clear:both\"/>\n";

    private static final String YMDD_HTML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"\n" +
            "    \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n" +
            "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
            "<!-- Generated by Oracle BI Publisher 12.2.1.3.0 -->\n" +
            "<head>\n" +
            "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>\n" +
            "<title>RTF Template</title>\n" +
            "<style type=\"text/css\" id=\"internalStyle\">\n" +
            ".c0 {margin-top: 0.0pt;margin-bottom: 0.0pt;margin-right: 5.899pt;}\n" +
            ".c1 {line-height: 7.514pt;margin-top: 0.0pt;margin-bottom: 4.0pt;font-size: 6pt;}\n" +
            ".t1 {line-height: 7.514pt;margin-top: 0.0pt;margin-left: 19.0pt;margin-bottom: 10.0pt;font-size: 10pt;}\n" +
            "  body { padding:0; margin:0; color: #000000;font-family:Microsoft YaHei; @page {size:20mm, 35mm;}} \n" +
            "</style>\n" +
            "</head>\n" +
            "<body>\n" +
            "<div style=\"margin-top: 47.0pt;\">\n" +
            "${content}\n" +
            "</div>\n" +
            "</body>\n" +
            "</html>\n";

    private static final String $CONTENT = "${content}";
    private static final String $ENCODE_ASSET_NUM = "${encodeAssetNum}";
    private static final String $ASSET_NUM = "${assetNum}";
    private static final String $ASSET_NAME = "${assetName}";
    private static final String $BRAND = "${brand}";
    private static final String $MODEL = "${model}";

    private static final int FIXED_LENGTH = 3;

    public static void main(String[] args) throws IOException, DocumentException, com.lowagie.text.DocumentException {
//        int length = 10;
//
        String html = YMDD_HTML;
        StringBuilder content = new StringBuilder();
        List<ByteArrayOutputStream> baosList = new ArrayList<>();
//
//        // 设置PDF个数
//        for (int count = 0; count < length; count++) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baosList.add(baos);
//
//            // 设置标签内容
//            for (int i = 0; i < FIXED_LENGTH; i++) {
//                content.append(YMDD_CONTENT
//                        .replace($ENCODE_ASSET_NUM, URLEncoder.encode("中文", "UTF-8"))
//                        .replace($ASSET_NUM, "中文")
//                        .replace($ASSET_NAME, "龙卷风龙卷风龙卷风龙")
//                        .replace($BRAND, "龙卷风龙卷风龙卷风x")
//                        .replace($MODEL, "龙卷风龙卷风龙卷风1"));
//            }
//            html = html.replace($CONTENT, content.toString());
//            System.out.println(html);
        // html-> pdf
        html2Pdf("<!DOCTYPE html >\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<style type=\"text/css\">\n" +
                ".c0 {margin-top: 0.0pt;margin-bottom: 0.0pt;margin-right: 5.899pt;}\n" +
                ".c1 {line-height: 7.514pt;margin-top: 0.0pt;margin-bottom: 4.0pt;font-size: 6pt;}\n" +
                ".t1 {line-height: 7.514pt;margin-top: 0.0pt;margin-left: 19.0pt;margin-bottom: 10.0pt;font-size: 10pt;}\n" +
                "  body { padding:0; margin:0; color: #000000;font-family:Microsoft YaHei; @page {size:20mm, 35mm;}} \n" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div style=\"margin-top: 47.0pt;\">\n" +
                "<div style=\"margin-left: 30.0pt;margin-bottom: 11.0pt;\">\n" +
                "<div style=\"float:left\">\n" +
                "<p class=\"c0\"><img src=\"http://test-eam1.yimidida.com/aatn/v1/0/asset-info/qrcode-image?codeType=QR&amp;assetNum=asset.getAssetNum%28%29\" style=\"width:60pt;height:60pt;\" alt=\"An Image\" /><br/></p>\n" +
                "</div>\n" +
                "<div style=\"float:left\">\n" +
                "<p class=\"t1\"><span class=\"c2\">壹米滴答</span></p>\n" +
                "<p class=\"c1\"><span class=\"c2\">资产条码:asset.getAssetNum()</span></p>\n" +
                "<p class=\"c1\"><span class=\"c2\">资产名称:asset.getAssetName()</span></p>\n" +
                "<p class=\"c1\"><span class=\"c2\">品牌:asset.getBrand()</span></p>\n" +
                "<p class=\"c1\"><span class=\"c2\">规格:asset.getModel()</span></p>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div style=\"clear:both\"/>\n" +
                "\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>\n", baos);

        html = YMDD_HTML;
        content = new StringBuilder();
//        }

        // pdf合并
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        mergePdfFiles(baosList, outputStream);


        BufferedInputStream bis = new BufferedInputStream(new ByteArrayInputStream(outputStream.toByteArray()));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("C:\\Users\\Administrator\\Desktop\\a.pdf")));
        byte[] in = new byte[1024];
        int rst;
        while ((rst = bis.read(in)) > -1) {
            bos.write(in, 0, rst);
        }
        bis.close();
        bos.close();
    }


    /**
     * @Author: enHui.Chen
     * @Description: html -> pdf
     * @Data 2020/4/13
     */
    public static void html2Pdf(String html, ByteArrayOutputStream fileOutputStream) throws IOException, DocumentException, com.lowagie.text.DocumentException {
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(html);
        ITextFontResolver fontResolver = renderer.getFontResolver();
        // 获取字体文件路径
        fontResolver.addFont(getFontPath2(), BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        renderer.getSharedContext().setReplacedElementFactory(new ImgReplacedElementFactory());
        renderer.layout();
        renderer.createPDF(fileOutputStream);
        fileOutputStream.flush();

    }

    /**
     * @Author: enHui.Chen
     * @Description: PDF合并
     * @Data 2020/4/13
     */
    public static void mergePdfFiles(List<ByteArrayOutputStream> baosList, ByteArrayOutputStream outputStream) {
        Document document = null;
        try {
            document = new Document();
            PdfCopy copy = new PdfCopy(document, outputStream);
            document.open();
            for (ByteArrayOutputStream baos : baosList) {
                PdfReader reader = new PdfReader(baos.toByteArray());
                int n = reader.getNumberOfPages();
                for (int j = 1; j <= n; j++) {
                    document.newPage();
                    PdfImportedPage page = copy.getImportedPage(reader, j);
                    copy.addPage(page);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (document != null) {
                document.close();
            }
        }
    }

    private static String getFontPath2() {
        return "E:\\test\\src\\main\\resources\\font\\SIMHEI.ttf";
    }
}
