 package com.weeds.thread;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;

import com.weeds.common.Constants;
import com.weeds.utils.GlobalKeys;



/**
 * 本应用中所有的线程的监控类
 * @author xuanxy
 *
 */
public class ThreadGuard {
	
	private static Map<String, Object> treadMap= Collections.synchronizedMap(new HashMap<String, Object>());
	private static Logger logger = Logger.getLogger(ThreadGuard.class);

	public static synchronized void putStart(String key,Thread value){
		try{
			value.start();
			treadMap.put(key, value);
			if(logger.isInfoEnabled()){
				logger.info("putStart:"+ key+"  "+value);
			}
		}catch (Exception e) {
			logger.error("putStart-"+key+":",e);
		}
		
	}
	public static int getThreadSize(){
		return treadMap.size();
	}
	/**
	 * 检查线程状态
	 * @return
	 */
	public static String checkThread(){
		StringBuffer sb=new StringBuffer();
		for (Iterator<String> iterator = treadMap.keySet().iterator(); iterator.hasNext();) {
			String type =iterator.next().toString();
			Thread thread=(Thread)treadMap.get(type);
			if(thread==null||!thread.isAlive()){
				//不满足线程run的条件
				/*if(!("true".equals(GlobalKeys.getProcessPropertyByKey("transferLogoutEventThread"))
						&& ("true".equals(ApplicationConfig.getConfig().getProperty("event.transfer2file.open", "false").toLowerCase())
								 || !"".equals(ApplicationConfig.getConfig().getProperty("event.transfer.ip", ""))))){
					continue;
				}*/
				//异常线程
				sb.append(type+" &nbsp;&nbsp;&nbsp;");
				GlobalKeys.exceptionThread.put(type, thread);
				
			}
		}
		if(sb.toString().equals("")){
			sb.append("<font color='#33CC00'>system right 正常</font>");
		}else{
			return "<font color='#000099'>出现异常的线程有</font>：<font color='red'>"+sb.toString()+"</font>";
		}
		
		return sb.toString();
	}
	/**
	 * 检查线程状态是否正常
	 * @return
	 */
	public static String checkThread2Str(){
		StringBuffer sb=new StringBuffer();
		for (Iterator<String> iterator = treadMap.keySet().iterator(); iterator.hasNext();) {
			String type =iterator.next().toString();
			Thread thread=(Thread)treadMap.get(type);
			if(thread==null||!thread.isAlive()){
				//不满足线程run的条件
				/*if(!("true".equals(GlobalKeys.getProcessPropertyByKey("transferLogoutEventThread"))
						&& ("true".equals(ApplicationConfig.getConfig().getProperty("event.transfer2file.open", "false").toLowerCase())
								 || !"".equals(ApplicationConfig.getConfig().getProperty("event.transfer.ip", ""))))){
					continue;
				}*/
				//异常线程
				sb.append(type+" ;");
				sb.append(Constants.LINE_SEPARATOR);
				GlobalKeys.exceptionThread.put(type, thread);
				
			}
		}
		if(sb.toString().equals("")){
			sb.append(" system right 正常. ");
		}else{
			return " 出现异常的线程有: "+sb.toString()+" ";
		}
		
		return sb.toString();
	}
	/**
	 * 检查指定线程是否正常
	 * @param key	线程名称
	 * @return	boolean(true:表示正常;false:表示异常)
	 */
	public static  synchronized boolean checkThread(String key){
		boolean state=true;
		Thread thread=(Thread)treadMap.get(key);
		if(thread==null||!thread.isAlive()){
			//不满足线程run的条件
			/*if(!("true".equals(GlobalKeys.getProcessPropertyByKey("transferLogoutEventThread"))
					&& ("true".equals(ApplicationConfig.getConfig().getProperty("event.transfer2file.open", "false").toLowerCase())
							 || !"".equals(ApplicationConfig.getConfig().getProperty("event.transfer.ip", ""))))){
				return state;
			}*/
			//异常线程
			state=false;
			GlobalKeys.exceptionThread.put(key, thread);
		}
		return state;
	}
	/**
	 * 取得线程
	 * @return
	 */
	public static String getThreadList(){
		StringBuffer sb=new StringBuffer();
		for (Iterator<String> iterator = treadMap.keySet().iterator(); iterator.hasNext();) {
			String type =iterator.next().toString();
			Thread thread=(Thread)treadMap.get(type);
			if(thread==null||!thread.isAlive()){
				//不满足线程run的条件
				/*if(!("true".equals(GlobalKeys.getProcessPropertyByKey("transferLogoutEventThread"))
						&& ("true".equals(ApplicationConfig.getConfig().getProperty("event.transfer2file.open", "false").toLowerCase())
								 || !"".equals(ApplicationConfig.getConfig().getProperty("event.transfer.ip", ""))))){
					continue;
				}*/
				//异常线程
				sb.append("<font color='#000099'>"+type+"</font><font color='red'>"+" :Exception "+"</font></br>");
			}else {
				sb.append("<font color='#000099'>"+type+"</font><font color='#00CC00'>"+" :Right "+"</br></font>");
			}
		}
		
		return sb.toString();
	}
	/**
	 * 取得线程
	 * @return
	 */
	public static String getThreadList2Str(){
		StringBuffer sb=new StringBuffer();
		for (Iterator<String> iterator = treadMap.keySet().iterator(); iterator.hasNext();) {
			String type =iterator.next().toString();
			Thread thread=(Thread)treadMap.get(type);
			if(thread==null||!thread.isAlive()){
				//不满足线程run的条件
				/*if(!("true".equals(GlobalKeys.getProcessPropertyByKey("transferLogoutEventThread"))
						&& ("true".equals(ApplicationConfig.getConfig().getProperty("event.transfer2file.open", "false").toLowerCase())
								 || !"".equals(ApplicationConfig.getConfig().getProperty("event.transfer.ip", ""))))){
					continue;
				}*/
				//异常线程
				sb.append("异常: "+type+""+" :Exception "+"");
				sb.append(Constants.LINE_SEPARATOR);
			}else {
				sb.append(" "+type+" "+" :Right "+" ").append(Constants.LINE_SEPARATOR);
			}
		}
		
		return sb.toString();
	}
	 
	/**
	 * 返回异常线程信息，并重新启动异常的线程
	 * @return
	 */
	public static String restartExceptionThread() throws Exception{
		StringBuffer  buffer = new StringBuffer();
		HashMap<String, Object> map = new HashMap<String, Object>();
		for( Iterator<String> iter = GlobalKeys.exceptionThread.keySet().iterator();iter.hasNext();){
			String key = iter.next().toString();
			Thread thread = (Thread) GlobalKeys.exceptionThread.get(key);
			buffer.append(key+" 异常;");
			if(  thread == null || !thread.isAlive() ){
				//不满足线程run的条件
				/*if(!("true".equals(GlobalKeys.getProcessPropertyByKey("transferLogoutEventThread"))
						&& ("true".equals(ApplicationConfig.getConfig().getProperty("event.transfer2file.open", "false").toLowerCase())
								 || !"".equals(ApplicationConfig.getConfig().getProperty("event.transfer.ip", ""))))){
					continue;
				}*/
				if(thread != null){
					//安全终止一个线程
					thread.interrupted();
					//重新开启线程
					putStart(key, thread);
				}
				map.put(key, thread);
				if(logger.isInfoEnabled()){
					logger.info("异常线程："+key+" 已重新开启");
				}
			}
		}
		
		//移除异常线程
		for( Iterator<String> iter = map.keySet().iterator();iter.hasNext();){
			String key = iter.next().toString();
			GlobalKeys.exceptionThread.remove(key);
		}
		return buffer.toString();
		
	}
	 
}
