package com.efruit.micro.arkmanager.utils;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import static org.apache.commons.io.FileUtils.openOutputStream;

public class FileHelper {

    private static final String TEMP_DIR_PREF = "coupon-temp";

    public static boolean checkValid(File file) {
        if (file == null) {
            return false;
        }

        if (!file.exists()) {
            return false;
        }

        return true;
    }

    /**
     * 创建临时文件.
     *
     * @param inputStream 输入文件流
     * @param name        文件名
     * @param ext         扩展名
     * @param tmpDirFile  临时文件夹目录
     */
    public static File createTmpFile(InputStream inputStream, String name, String ext, File tmpDirFile) throws IOException {
        File resultFile = File.createTempFile(name, '.' + ext, tmpDirFile);

        resultFile.deleteOnExit();
        copyToFile(inputStream, resultFile);
        return resultFile;
    }

    public static void copyToFile(InputStream source, File destination) throws IOException {
        FileOutputStream output = openOutputStream(destination);

        try {
            IOUtils.copy(source, output);
            output.close();
        } finally {
            IOUtils.closeQuietly(output);
        }

    }

    /**
     * 创建临时文件.
     *
     * @param inputStream 输入文件流
     * @param name        文件名
     * @param ext         扩展名
     */
    public static File createTmpFile(InputStream inputStream, String name, String ext) throws IOException {
        final File parentFile = getTempDirFile();
        return createTmpFile(inputStream, name, ext, parentFile);
    }

    public static File getTempDirFile() throws IOException {
        return Files.createTempDirectory(TEMP_DIR_PREF).toFile().getParentFile();
    }
}
