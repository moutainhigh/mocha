package com.efruit.micro.arkgift.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.efruit.micro.arkcommon.utils.PayDigestUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;


public class PayUtil {
	
	public static Map<String, Object> request2payResponseMap(HttpServletRequest request, String[] paramArray) {
        Map<String, Object> responseMap = new HashMap<>();
        for (int i = 0;i < paramArray.length; i++) {
            String key = paramArray[i];
            String v = request.getParameter(key);
            if (v != null) {
                responseMap.put(key, v);
            }
        }
        return responseMap;
    }
	
	@SuppressWarnings("deprecation")
	public static boolean verifyPayResponse(Map<String,Object> map,String s_mchId,String resKey) {
        String mchId = (String) map.get("mchId");
        String payOrderId = (String) map.get("payOrderId");
        String amount = (String) map.get("amount");
        String sign = (String) map.get("sign");

        if (StringUtils.isEmpty(mchId)) {
            return false;
        }
        if (StringUtils.isEmpty(payOrderId)) {
            return false;
        }
        if (StringUtils.isEmpty(amount) || !NumberUtils.isNumber(amount)) {
            return false;
        }
        if (StringUtils.isEmpty(sign)) {
            return false;
        }

        // 验证签名
        if (!verifySign(map,s_mchId,resKey)) {
            return false;
        }
        
        return true;
    }
	
	private static boolean verifySign(Map<String, Object> map,String s_mchId,String resKey) {
        String mchId = (String) map.get("mchId");
        if(!s_mchId.equals(mchId)) return false;
        String localSign = PayDigestUtil.getSign(map, resKey, "sign");
        String sign = (String) map.get("sign");
        return localSign.equalsIgnoreCase(sign);
    }

	public static void outResult(HttpServletResponse response, String content) {
		response.setContentType("text/html");
        PrintWriter pw;
        try {
            pw = response.getWriter();
            pw.print(content);
        } catch (IOException e) {
        }
	}
}
