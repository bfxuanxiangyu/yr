package com.weeds.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class SendMessageUtil {
	
	public static void main(String[] args) {
		Map<String, String> parameters = new HashMap<>();
		parameters.put("name", "你好");
		parameters.put("desc", "报名信息");
		parameters.put("state", "审核成功");
		parameters.put("date", "2016-10-12 18:23:21");
		//sendMessageByMap("15601605036",parameters, "http://101.226.174.176:8081/", "1596812", "system");
		sendMessage("15601605036","中国年", "http://121.41.73.231:8899/", "828787", "system");
	}
	
	/**
	 * @param mobile       发送手机号码，多个用半角","隔开
	 * @param content
	 * @param sendUrl
	 * @param tplid         设置短信模板ID
	 * @param channeltype   1.设置短信通道类型 系统类型短信：system 市场推广类型短信：marketing
	 * @return
	 */
	public static boolean sendMessageByMap(String mobile, Map<String, String> parameters,String sendUrl,String tplid,String channeltype) {
		boolean flag = false;
		String returnVal = "";
		if (StringUtils.isBlank(mobile) ||  StringUtils.isBlank(sendUrl) || StringUtils.isBlank(tplid) || StringUtils.isBlank(channeltype)) {
			return flag;
		}
		// 4.设置模板对应解析值
		//String tplvalue = "#code#=" + content.trim();// #app#=短信平台&#mcode#=1234&#company#=测试公司
		StringBuffer tplvalue = new StringBuffer();
		tplvalue.append("#name#="+parameters.get("name"));
		tplvalue.append("&#desc#="+parameters.get("desc"));
		tplvalue.append("&#state#="+parameters.get("state"));
		tplvalue.append("&#date#="+parameters.get("date"));
		Map<String, String> paramters = new HashMap<String, String>();
		paramters.put("channeltype", channeltype);
		paramters.put("mobile", mobile);
		paramters.put("tplid", tplid);
		paramters.put("tplvalue", tplvalue.toString());
		try {
			returnVal = ApachHttpClient.post(sendUrl, paramters);
			System.out.println("发送手机："+mobile+",发送内容："+tplvalue.toString()+"短信返回结果:"+returnVal);
			if(StringUtils.isNotBlank(returnVal)){
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	/**
	 * @param mobile       发送手机号码，多个用半角","隔开
	 * @param content
	 * @param sendUrl
	 * @param tplid         设置短信模板ID
	 * @param channeltype   1.设置短信通道类型 系统类型短信：system 市场推广类型短信：marketing
	 * @return
	 */
	public static boolean sendMessage(String mobile, String content,String sendUrl,String tplid,String channeltype) {
		boolean flag = false;
		String returnVal = "";
		if (StringUtils.isBlank(mobile) || StringUtils.isBlank(content) || StringUtils.isBlank(sendUrl) || StringUtils.isBlank(tplid) || StringUtils.isBlank(channeltype)) {
			return flag;
		}
		// 4.设置模板对应解析值
		String tplvalue = "#code#=" + content.trim();// #app#=短信平台&#mcode#=1234&#company#=测试公司
		Map<String, String> paramters = new HashMap<String, String>();
		paramters.put("channeltype", channeltype);
		paramters.put("mobile", mobile);
		paramters.put("tplid", tplid);
		paramters.put("tplvalue", tplvalue);
		try {
			returnVal = ApachHttpClient.post(sendUrl, paramters);
			System.out.println("发送手机："+mobile+",发送内容："+content+"短信返回结果:"+returnVal);
			if(StringUtils.isNotBlank(returnVal)){
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
