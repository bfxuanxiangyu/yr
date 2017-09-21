package com.weeds.utils.cache;

import java.net.URL;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.CacheManager;

/**
 * 
 * 
 * @author xuanxy
 * 
 */
public class CacheSysManager {


	protected static CacheManager manager;
	private static CacheSysManager instance=new CacheSysManager();
	
	private CacheSysManager() {
		initCacheManager();
	}

	public static CacheSysManager getInstance() {
		return instance;
	}

	
	protected void initCacheManager() {
		//manager = (CacheManager) DefaultBeanFactory.getBean("cacheManager");
		URL url = getClass().getResource("/ehcache.xml");
		try {
			manager=CacheManager.create(url);
		} catch (CacheException e) {
			e.printStackTrace();
		}
	}

	protected Cache initCache(String cacheName) {
		return new Cache(cacheName, 100000, true, true, 0, 0);
	}

	public Cache getCacheByName(String cacheName) {
		if (manager == null) {
			initCacheManager();
		}
		return manager.getCache(cacheName);
	}

	
}
