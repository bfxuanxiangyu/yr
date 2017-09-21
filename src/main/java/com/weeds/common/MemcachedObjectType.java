package com.weeds.common;

/**
 * 统一定义Memcached中存储的各种对象的Key前缀和超时时间.
 * 
 * @see com.weeds.service.profile.examples.showcase.service.AccountService#getInitializedUser(String)
 * 
 * @author xuanxy
 */
public enum MemcachedObjectType {
	USER("user:", 60 * 60 * 1),
	CATEGORY("category:",30*24*60 * 60 * 1),		//分类数据
	HERO("hero:",30*24*60 * 60 * 1),				//英雄数据
	DESCANT("descant:",30*24*60 * 60 * 1),			//解说者数据
	HOMEDATA("homedata:",24*60 * 60 * 1);			//首页数据
	
	private String prefix;
	private int expiredTime;

	MemcachedObjectType(String prefix, int expiredTime) {
		this.prefix = prefix;
		this.expiredTime = expiredTime;
	}

	public String getPrefix() {
		return prefix;
	}

	public int getExpiredTime() {
		return expiredTime;
	}

}
