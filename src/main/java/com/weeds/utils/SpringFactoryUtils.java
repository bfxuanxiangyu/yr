package com.weeds.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author xuanxy
 */
public class SpringFactoryUtils {
 
	private static ApplicationContext appContext = null;

	public static Object getBean(String beanName) {
		return (appContext != null) ? appContext.getBean(beanName) : null;
	}

	/**
	 * @return the appContext
	 */
	public static ApplicationContext getAppContext() {
		return appContext;
	}

	/**
	 * @param aAppContext
	 *            the appContext to set
	 */
	public static void setAppContext(ApplicationContext aAppContext) {
		appContext = aAppContext;
	}


	public static void rebuildSpringJdbcFactory() {
		try {

			appContext = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml"});

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
