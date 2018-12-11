package com.efruit.micro.arkmanager.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

public class HttpServletResponseUtils {

    public static void printMsgToResponse(HttpServletResponse response, String msg) throws IOException {
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(msg.getBytes(Charset.forName("UTF-8")));
        outputStream.flush();
        outputStream.close();
    }
}
