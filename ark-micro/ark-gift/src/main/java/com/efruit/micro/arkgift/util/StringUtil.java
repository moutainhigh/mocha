package com.efruit.micro.arkgift.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

/**
 * 字符串工具类
 * @author wangyang
 */
public class StringUtil {
	
	/**
	 * 获取UUID
	 * @return
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/**
	 * 获取订单号
	 * @return
	 */
	public static String getOrderNo() {
		StringBuilder sb = new StringBuilder("");
		sb.append(getTimeStr(null));
		sb.append(getRandomStr(6));
		return sb.toString();
	}
	
	/**
	 * 获取时间字符串
	 * @param pattern 格式，默认yyyyMMddHHmmssSSS
	 * @return
	 */
	public static String getTimeStr(String pattern) {
		if(StringUtils.isEmpty(pattern)) {
			pattern = "yyyyMMddHHmmssSSS";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(new Date());
	}
	
	/**
	 * 获取随机数
	 * @param num 位数
	 * @return
	 */
	public static String getRandomStr(int num) {
		StringBuilder sb = new StringBuilder("");
		Random random = new Random(); 
		for(int i = 0;i < num;i++) {
			sb.append(random.nextInt(10));
		}
		return sb.toString();
	}

}
