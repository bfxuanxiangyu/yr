package com.weeds.common;
/**
 * 常量类
 * @author xuanxy
 *
 */
public class Constants {
	
	public static final int PAGESIZE = 10;
	
	/**
	 * 响应成功
	 */
	public static final int RESPONSE_SUCCESS = 1;
	public static final int SEND = 1;//系统公告 已发送
	
	public static final int STOP = 2;//系统公告 中止
	
	public static final int UNSEND = 0;//系统公告 未发送
	
	/**
	 * 测试证书
	 */
	public static final String CERTIFICATE_DEV = "u9dotaDev.p12";
	/**
	 * 正式证书
	 */
	public static final String CERTIFICATE_PRO = "u9dotaPro.p12";
	/**
	 * 平台
	 * @author xuanxy
	 *
	 */
	public enum Platform{
		iphone,ipad,android
	}
	
	
	/*
	 *系统换行符 
	 */
	public static final String LINE_SEPARATOR = System.getProperty("line.separator");
	
	/*
	 * 各种分隔符  事件内部元素间的分隔符 \u0001
	 */
	public static final int DELIMITER_EVENT_FIELD = 1;
	public static final String SPLIT001 = "\u0001";
	public static final String SPLIT002 = "\u0002";
	public static final String SPLIT003 = "\u0003";
	public static final String SPLITT = "\\t";
	
	/**
	 * 分页时候标识
	 */
	public static String sourceforjob = "0";
}
