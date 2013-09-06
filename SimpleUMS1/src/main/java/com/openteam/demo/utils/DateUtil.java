package com.openteam.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
	private static final String DEFAULT_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	private static final SimpleDateFormat df = new SimpleDateFormat(
			"yyyy-MM-dd");

	public static String getDateStrPattern(Date _date, String _pattern) {
		df.applyPattern(_pattern);
		return df.format(_date);
	}

	public static String getDateStrDay(Date _date) {
		return getDateStrPattern(_date, DEFAULT_DATE_PATTERN);
	}

	public static String getDateStrTime(Date _date) {
		return getDateStrPattern(_date, DEFAULT_DATETIME_PATTERN);
	}
}