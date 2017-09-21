package com.weeds.quartz;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.weeds.utils.DateUtils;

public class TestJob {
	private static Logger logger = LoggerFactory.getLogger(TestJob.class);

	/**
	 * 定时
	 */
	public void execute() {
		logger.info("Time task is start to select reservation");
		try {
			logger.info("循环执行当前执行时间："+DateUtils.dateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 单次定时
	 */
	public void oneplace() {
		logger.info("dingshi start");
		try {
			logger.info("定时执行时间："+DateUtils.dateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
