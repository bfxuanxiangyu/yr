package com.weeds.dao;

import java.util.List;
import java.util.Map;

/**
 * 通过@MapperScannerConfigurer扫描目录中的所有接口, 动态在Spring Context中生成实现.
 * 方法名称必须与Mapper.xml中保持一致.
 * 
 * 描述：基础的dao层实现类
 *   
 * 版本信息:
 * @author: 一橡  轩翔宇   
 * Date：2013-2-4 下午12:14:08  
 * Email: xuanxy@eeelephant.com
 * Copyright 一橡信息 Corporation 2013    
 * @param <T>
 *   
 */
@MyBatisRepository
public interface BaseDao<T> {
	/**
	 * 根据id查询用户
	 * @param id
	 * @return
	 */
	T findById(Long id);
	
	/**
	 * 多条件查询记录
	 * @param parameters
	 * @return
	 */
	List<T> search(Map<String, Object> parameters);
	/**
	 * 保存记录
	 * @param T
	 */
	void save(T t);
	/**
	 * 更新记录
	 * @param T
	 */
	void update(T t);

	/**   
	 * 此方法描述的是:根据id删除用户
	 * @param id  void
	 */   
	    
	void delete(Long id);
	/**
	 * 查询记录数
	 * @return
	 */
	int count();
	/**
	 * 根据条件查询记录数
	 * @param parameters
	 * @return
	 */
	int count(Map<String, Object> parameters);
}
