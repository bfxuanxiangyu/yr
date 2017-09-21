package com.weeds.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author xuanxy
 *
 */
public class DateUtils {
	
	/**
	 * 日期需要转换的格式
	 */
	public static final String  FORMAT_DATE_ONE = "yyyy-MM-dd";
	public static final String  FORMAT_DATE_TWO = "yyyy-MM-dd HH:mm:ss";
	public static final String  FORMAT_DATE_THREE = "yyyy-MM-dd HH:mm:ss.SSS";
	public static final String  FORMAT_DATE_FOUR = "yyyyMMdd";
	public static final String  FORMAT_DATE_FIVE = "yyyyMMddHHmmss";
	public static final String  FORMAT_DATE_SIX = "yyyy_MM_dd";
	
	/**
	 * 字符串转换为日期对象
	 * @param dateString
	 * @return
	 * @throws ParseException
	 */
	public static Date stringToDate(String dateString,String format){
		try{
			SimpleDateFormat sdf2 = new SimpleDateFormat(format);
			return sdf2.parse(dateString);
		}catch(Exception e){
			return new Date();
		}
	}
	/**
	 * 日期对象格式化为字符串
	 * @param usDate
	 * @return
	 */
	public static String dateToString(Date usDate,String format) {
		DateFormat sdf2 = new SimpleDateFormat(format);
		return sdf2.format(usDate);
	}
	
	/**
	 * 获得当前时间字符串
	 * @return
	 */
	public static String getCurrentDateString(String format){
		DateFormat sdf2 = new SimpleDateFormat(format);
		return sdf2.format(new Date());
	}
	/**
	 * 取得偏移时间 nowDate:时间Date型; date偏移时间; day偏移天数; status为分钟量 0是返回时间为00:00:00 ;1是返回为59:59:59; 2返回原始
	 */
	public static Date getOffsetTime(Date nowDate, int day, int status) {
		Calendar curCalendar = Calendar.getInstance();
		curCalendar.setTime(nowDate);
		long t = curCalendar.getTimeInMillis() + day * 24 * 60 * 60 * 1000L;
		curCalendar.setTimeInMillis(t);
		if (status == 0) {
			curCalendar.set(Calendar.HOUR_OF_DAY, 0);
			curCalendar.set(Calendar.MINUTE, 0);
			curCalendar.set(Calendar.SECOND, 0);
		} else if (status == 1) {
			curCalendar.set(Calendar.HOUR_OF_DAY, 23);
			curCalendar.set(Calendar.MINUTE, 59);
			curCalendar.set(Calendar.SECOND, 59);
		}
		return curCalendar.getTime();
	}
	
	
	/**
	 * 生成随机时间
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static Date randomDate(String beginDate, String endDate) {

		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date start = format.parse(beginDate);// 构造开始日期
			Date end = format.parse(endDate);// 构造结束日期
			if (start.getTime() >= end.getTime()) {
				return null;
			}
			long date = random(start.getTime(), end.getTime());
			return new Date(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static long random(long begin, long end) {

		long rtn = begin + (long) (Math.random() * (end - begin));
		// 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值
		if (rtn == begin || rtn == end) {
			return random(begin, end);
		}
		return rtn;

	}

	public static void main(String[] args) {
		System.out.println(dateToString(getOffsetTime(new Date(), 0, 2), FORMAT_DATE_TWO));
		System.out.println(dateToString(randomDate("2017-04-26 00:00:00", "2017-04-26 23:59:59"),"yyyy-MM-dd HH:mm:ss"));
	}
}
