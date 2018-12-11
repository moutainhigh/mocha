package com.efruit.micro.arkmanager.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public class ZXingUtils {
    private static final String DEFAULT_FORMAT = "png";
    private static final int DEFAULT_WIDTH = 230;
    private static final int DEFAULT_HEIGHT = 230;

    // 二维码的参数
    private static final Map DEFAULT_HITS = new HashMap();

    static {
        DEFAULT_HITS.put(EncodeHintType.CHARACTER_SET, "utf-8");
        //设置纠错等级
        DEFAULT_HITS.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        DEFAULT_HITS.put(EncodeHintType.MARGIN, 0);
    }

    public static ByteArrayOutputStream getQrCodeImage(String content) {
        return getQrCodeImage(DEFAULT_WIDTH, DEFAULT_HEIGHT, content);
    }

    public static ByteArrayOutputStream getQrCodeImage(int width, int height, String content) {
        final String format = DEFAULT_FORMAT;
        if (width < 0) {
            width = DEFAULT_WIDTH;
        }

        if (height < 0) {
            height = DEFAULT_HEIGHT;
        }

        //生成二维码
        try {
            final MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            final BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, width, height, DEFAULT_HITS);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, format, stream);
            return stream;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
