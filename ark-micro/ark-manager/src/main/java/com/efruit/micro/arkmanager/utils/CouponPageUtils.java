package com.efruit.micro.arkmanager.utils;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

@Component
public class CouponPageUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(CouponPageUtils.class);

    @Autowired
    private ResourceLoader resourceLoader;

    private static final String FONT_PATH = "classpath:/raw/arial.ttf";
    private static final String BG_PATH = "classpath:/raw/image_bg.jpg";
    private static final String FONT_ARIAL = "arial";

    private volatile Font cacheFont;
    private volatile BufferedImage cacheBgImage;

    public BufferedImage genImage(String code, String fetchUrl) {
        if (StringUtils.isEmpty(code) || StringUtils.isEmpty(fetchUrl)) {
            LOGGER.info("genImage() : params invaild, please check. ");
            return null;
        }

        final ByteArrayOutputStream qrCodeImage = ZXingUtils.getQrCodeImage(fetchUrl);
        if (qrCodeImage == null) {
            LOGGER.info("genImage() : qrCodeImage is null. code : {} , fetchUrl : {} ", code, fetchUrl);
            return null;
        }

        final BufferedImage bgBufferedImage = getBufferedImage();
        if (bgBufferedImage == null) {
            LOGGER.info("genImage() : bgBufferedImage is null : code : {} , fetchUrl : {} ", code, fetchUrl);
            return null;
        }

        byte[] imageData = qrCodeImage.toByteArray();
        if (imageData == null || imageData.length <= 0) {
            LOGGER.info("genImage() : qrCodeImage is invaild : code : {} , fetchUrl : {} ", code, fetchUrl);
            return null;
        }
        final ImageIcon qrImageIcon = new ImageIcon(imageData);
        final BufferedImage bufferedImage = mergeImage(bgBufferedImage, qrImageIcon, code);
        return bufferedImage;
    }

    private BufferedImage getBufferedImage() {
        if (cacheBgImage != null) {
            return cacheBgImage;
        }
        BufferedImage bgBufferedImage = null;
        InputStream bgImageInputStream = null;
        try {
            bgImageInputStream = resourceLoader.getResource(BG_PATH).getInputStream();
            bgBufferedImage = ImageIO.read(bgImageInputStream);
            cacheBgImage = bgBufferedImage;
        } catch (Exception e) {
            LOGGER.info("genImage() : ImageIO.read(bgImage) error : " , e);
        } finally {
            IOUtils.closeQuietly(bgImageInputStream);
        }
        return bgBufferedImage;
    }

    private BufferedImage mergeImage(Image bgImage, ImageIcon small, String code) {
        if (bgImage == null || small == null || StringUtils.isEmpty(code)) {
            return null;
        }

        final Image bigImg = bgImage;
        final Image smallImg = small.getImage();

        final int width = bigImg.getWidth(null);
        final int height = bigImg.getHeight(null);
        if (width <= 0 || height <= 0) {
            return null;
        }

        final BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = result.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // 背景图
        graphics.drawImage(bigImg, 0, 0, null);

        // 二维码
        int x = (width - smallImg.getWidth(null)) / 2;
        int y = 980;
        graphics.drawImage(smallImg, x, y, smallImg.getWidth(null), smallImg.getHeight(null), null);

        final Font font = getFont();
        if (font != null) {
            graphics.setFont(font);
        }
        // 写入文字
        drawString(code, 247, 818, 1.25, graphics);
        graphics.dispose();
        return result;
    }

    private void drawString(String str, int x, int y, double rate, Graphics g) {
        String tempStr;
        int orgStringWight = g.getFontMetrics().stringWidth(str);
        int orgStringLength = str.length();
        int tempx = x;
        int tempy = y;
        while (str.length() > 0) {
            tempStr = str.substring(0, 1);
            str = str.substring(1, str.length());
            g.drawString(tempStr, tempx, tempy);
            tempx = (int) (tempx + (double) orgStringWight / (double) orgStringLength * rate);
        }
    }

    private Font getFont() {
        if (cacheFont != null) {
            return cacheFont;
        }

        // 设置字体、字型、字号
        final float fontSize = 65.0f;
        final int style = Font.PLAIN;

        // 判断当前系统是否存在arial字体
        GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] availableFontFamilyNames = environment.getAvailableFontFamilyNames();
        for (String fontName : availableFontFamilyNames) {
            if (!StringUtils.isEmpty(fontName) && fontName.equalsIgnoreCase(FONT_ARIAL)) {
                cacheFont = new Font(FONT_ARIAL, style, (int) fontSize);
                return cacheFont;
            }
        }

        InputStream fontResInputStream = null;
        try {
            fontResInputStream = resourceLoader.getResource(FONT_PATH).getInputStream();
            cacheFont = Font.createFont(Font.TRUETYPE_FONT, fontResInputStream)
                    .deriveFont(style, fontSize);
            cacheFont.deriveFont(style);
            return cacheFont;
        } catch (Exception e) {
            LOGGER.info("Font.createFont error. ", e);
        } finally {
            IOUtils.closeQuietly(fontResInputStream);
        }
        return null;
    }

}
