package com.weeds.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.google.common.collect.Maps;


/**
 * @author xuanxy
 *
 */
public class GlobalKeys {
	private static Logger logger = Logger.getLogger(GlobalKeys.class);
	
	public static ResourceBundle constants = null;//获取properties中 的文件信息
	/*方法二*/
	private static Properties prop ;
	
	/**
	 * 存放登录者点击菜单id
	 */
	public static Map<String, String> menuIdMaps = Maps.newHashMap();
	/**
	 * 存放imei唯一号
	 */
	public static Map<String, String> IMEIMap = new HashMap<String, String>();
	
	static{
		try {
			constants = ResourceBundle.getBundle("constants",Locale.getDefault());
			getApplicationConfig();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static Properties getApplicationConfig(){
		if(prop == null){
			prop = new Properties();
		}
		try {
			prop.load(GlobalKeys.class.getResourceAsStream("/constants.properties"));
		} catch (Exception e) {
			logger.error("读取配置文件出错"+e.getMessage(),e);
		}
		return prop;
	}
	
	/**
	 * 直接获取constants.properties中信息
	 * @param key
	 * @return
	 */
	public static String getConstantsByKeyForBundel(String key){
		return constants.getString(key).trim();
	}
	
	/**
	 * 获取constants.properties中信息,如果返回空  赋予默认值
	 * @param key
	 * @return
	 */
	public static String getConstantsByKeyForBundel(String key,String defaultStr){
		String value = null;
		try {
			
			value =  constants.getString(key);
		} catch (Exception e) {
			value = null;
		}
		return StringUtil.isEmpty(value)?defaultStr:value.trim();
	}
	
	/**
	 * 直接获取constants.properties中信息
	 * @param key
	 * @return
	 */
	public static String getConstantsByKeyForProperties(String key){
		return prop.getProperty(key).trim();
	}
	
	/**
	 * 获取constants.properties中信息,如果返回空  赋予默认值
	 * @param key
	 * @return
	 */
	public static String getConstantsByKeyForProperties(String key,String defaultValue){
		return prop.getProperty(key, defaultValue.trim());
	}
	
	
	/**
	 * 系统异常线程集合
	 */
	public static Map<String, Object> exceptionThread = Collections.synchronizedMap(new HashMap<String, Object>());
	
	
	/**
	 * 存放是否报过警的数据
	 */
	public static String USERTYPE = "1";

	public static void main(String[] args) {
		System.out.println(getConstantsByKeyForBundel("receiveTcpDate","false"));
		System.out.println(getConstantsByKeyForProperties("receiveTcpDate", "13"));
	}
}
