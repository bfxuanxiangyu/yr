package com.weeds.utils.cache;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.apache.log4j.Logger;

import com.google.common.collect.Lists;
import com.weeds.entity.profile.AdminUser;
import com.weeds.service.profile.AdminUserService;
import com.weeds.utils.SpringFactoryUtils;

/**
 * 缓存用户信息
 * @author Administrator
 *
 */
public class UserCache {
	public  Cache localeCache;//url登录报警记录缓存
	private static UserCache instance;
	
	private static Logger logger = Logger.getLogger(UserCache.class.getName());
	
	private  AdminUserService adminUserService;
	
	
	
	public static UserCache getInstance() {
		if (instance == null) {
			instance = new UserCache();
		}
		return instance;
	}
	
	
	
	private UserCache(){
		CacheSysManager manager=CacheSysManager.getInstance();
		localeCache = manager.getCacheByName("UserCache");
		
		initList();
	}
	/**
	 * 初始化缓存所有报警设置表
	 */
	public void initList(){
		List<AdminUser> aulist = Lists.newArrayList();
		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			aulist = getAdminUserService().getAllAdminUser(parameters);
			if(aulist !=null){
				Element et = null;
				for (AdminUser au : aulist) {//根据名称得到具体用户信息   
					et=new Element(au.getLoginName(),(Serializable) au);
					localeCache.put(et);
				}
				//缓存所有用户信息
				et = new Element("allUser",(Serializable) aulist);
				localeCache.put(et);
			}
		} catch (Exception e) {
			logger.info("报警url设置表信息载入缓失败",e);
		}
	}
	
	/**
	 * 通过key得到具体对象
	 * @param key
	 * @return
	 */
	public AdminUser getUserByLoginNameCache(String type){
		if(localeCache==null){
			return null;
		}
		Element et=null;
		try {
			et=localeCache.get(type);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return et == null ? null : (AdminUser) et.getValue();
	}
	
	/**
	 * 通过key得到具体对象
	 * @param key
	 * @return
	 */
	public List<AdminUser> getAllUserCache(){
		if(localeCache==null){
			return null;
		}
		Element et=null;
		try {
			et=localeCache.get("allUser");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return et == null ? null : (List<AdminUser>) et.getValue();
	}
	

	/**
	 * 刷新缓存
	 * @param type   刷新缓存的类型
	 */
	public void refreshUserByLoginNameCache(String type){
		logger.info("将type为："+type+"重新载入缓存");
		try{
			AdminUser config = getAdminUserService().findAdminUserByLoginName(type);
			Element et=null;
			try {
				et=localeCache.get(type);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(et!=null){//不为空  直接清空
				localeCache.remove(et);
				et=new Element(config.getLoginName(),(Serializable) config);
				localeCache.put(et);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}



	public AdminUserService getAdminUserService() {
		if(adminUserService==null){
			adminUserService = (AdminUserService) SpringFactoryUtils.getBean("adminUserService");
		}
		return adminUserService;
	}



	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}
}
