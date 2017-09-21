package com.weeds.utils;


import java.net.URLEncoder;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 大医短信发送工具类
 * @author chenzhenhu
 * @company tocersoft
 * @cerate-date 2015-2-4上午9:45:14
 * @email chenzhenhu@tocersoft.com
 */
public class JCKSMSUtil {
	private static Logger logger = LoggerFactory.getLogger(JCKSMSUtil.class);

	/** 请求地址*/
	private final static String requestUrl = "http://www.smsadmin.cn/smsmarketing/wwwroot/api/get_send/";
	/** 帐号*/
//	private final static String account = "野草科技信息咨询";
	/** 密码*/
	private final static String password = "ghxl912";
	/** 用户ID*/
	private final static String userId = "ysxx";
	
	/**
	 * 发送短信
	 * @param mobile	手机号，多个用逗号隔开
	 * @param content	发送内容
	 * @return 成功 true 失败 false
	 */
	public static boolean send(String mobile,String content){
		try {
			logger.info("开始调用短信接口");
			logger.info("发送内容："+content);
			
			String url = requestUrl + "?uid=" + userId + "&pwd=" + password + "&mobile=" + mobile + "&msg=" + URLEncoder.encode(content, "GB2312");

			String result = ApachHttpClient.get(url);;
			logger.info("发送短信接口数据返回内容："+result);
			
			if(StringUtils.isBlank(result)){
				return false;
			}
	
			if(result.indexOf("0发送成功!") != -1){
				logger.info("短信接口调用成功!");
				//成功
				return true;
			}
			//发生错误
			logger.error("调用短信接口失败，返回错误信息为：" + result);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("调用短信接口发生异常："+e.getMessage(),e);
		} 
		return false;
	}
	
	
	public static void main(String[] args) {
		//测试接口
		//JCKSMSUtil.send("15601605036", "新单提醒！订单号：D00005150727000，就诊人：王数，电话：15001830431，预约时间：2015年7月28日20:00到21:00之间，支付金额：100元,请主动与患者联系！【野草科技-哮喘】");
	}
}
