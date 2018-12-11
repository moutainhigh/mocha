package com.efruit.micro.arkmanager.utils;

import com.alibaba.fastjson.serializer.ValueFilter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JSONValueFilter implements ValueFilter{

	public JSONValueFilter(){}
	private SimpleDateFormat sdf = new SimpleDateFormat();
	private String dateFormat = "yyyy-MM-dd HH:mm:ss";
	
	@Override
	public Object process(Object object, String name, Object value) {
		if(null == value)
			return value;
		if(value instanceof String)
			return value;
		if(value instanceof Number)
			return value.toString();
		if(value instanceof Date){
			sdf.applyPattern(dateFormat);
			return sdf.format(value);
		}
		return value;
	}
	
	public void setDateFormat(String format){
		this.dateFormat = format;
	}

}
