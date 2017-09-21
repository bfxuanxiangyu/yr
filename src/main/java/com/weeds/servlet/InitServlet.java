package com.weeds.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.weeds.utils.SpringFactoryUtils;


public class InitServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	private Logger logger = Logger.getLogger(InitServlet.class);
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
		
		long start = System.currentTimeMillis();
		try {
			//logger.info("==开始启动所有需要初始化的线程==");
			// 获取ioc容器
			SpringFactoryUtils.setAppContext(WebApplicationContextUtils.getWebApplicationContext(this.getServletContext()));
			//启动短信发送功能
			//ThreadGuard.putStart("sendMessageQueueThread", context.getBean(SendMessageQueueThread.class));
			
			long end = System.currentTimeMillis();
			logger.info("==weeds启动完成所有需要初始化的线程,耗时=="+(end - start)+"毫秒");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
