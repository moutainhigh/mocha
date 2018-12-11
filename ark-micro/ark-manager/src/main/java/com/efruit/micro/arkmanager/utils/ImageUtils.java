package com.efruit.micro.arkmanager.utils;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class ImageUtils {
    public static void toFile(BufferedImage bufimg, File targetFile) throws IOException {
        FileImageOutputStream output = new FileImageOutputStream(targetFile);

        Iterator<ImageWriter> iter = ImageIO.getImageWritersByFormatName("jpeg");
        ImageWriter writer = iter.next();
        ImageWriteParam iwp = writer.getDefaultWriteParam();
        iwp.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        iwp.setCompressionQuality(0.95f);
        writer.setOutput(output);
        writer.write(null, new IIOImage(bufimg, null, null), iwp);
        writer.dispose();
        output.close();
    }
}
