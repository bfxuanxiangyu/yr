package com.weeds.quartz;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.weeds.utils.DateUtils;
import com.google.common.collect.Maps;

public class AppointmentNoticeJob {
	private static Logger logger = LoggerFactory.getLogger(AppointmentNoticeJob.class);

	
	
	/**
	 * 循环定时
	 */
	public void execute() {
		try {
			Calendar cal = Calendar.getInstance();
			int hour = cal.get(Calendar.HOUR);
			int minute = cal.get(Calendar.MINUTE);
			logger.info("循环执行当前执行时间："+DateUtils.dateToString(new Date(), "yyyy-MM-dd HH:mm:ss")+",当前小时="+hour+",分钟="+minute);
			String nowDateStr = DateUtils.dateToString(new Date(), "yyyy-MM-dd");
			Map<String, Object> parameters = Maps.newHashMap();
			parameters.put("appointDate", nowDateStr);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
