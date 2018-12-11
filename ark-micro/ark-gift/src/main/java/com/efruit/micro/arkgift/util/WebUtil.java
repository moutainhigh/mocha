package com.efruit.micro.arkgift.util;

import javax.servlet.http.HttpServletRequest;

public class WebUtil {
	
	/**
	 * 获取请求来源的IP地址
	 * @param request
	 * @return
	 */
    public static String getClientIp(HttpServletRequest request) {
        String remoteAddr = "";
        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }
        return remoteAddr;
    }

}
