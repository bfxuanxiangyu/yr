package com.weeds.dao;

import java.util.List;
import java.util.Map;

import com.weeds.entity.profile.AccessToken;
import com.weeds.entity.profile.User;

/**
 * 通过@MapperScannerConfigurer扫描目录中的所有接口, 动态在Spring Context中生成实现.
 * 方法名称必须与Mapper.xml中保持一致.
 * 
 * @author calvin
 */
@MyBatisRepository
public interface UserDao {
	/**
	 * 根据id查询用户
	 * @param id
	 * @return
	 */
	User get(Long id);
	/**
	 * 根据用户名查询用户
	 * @param loginName
	 * @return
	 */
	User findByLoginName(String loginName);
	/**
	 * 多条件查询用户
	 * @param parameters
	 * @return
	 */
	List<User> search(Map<String, Object> parameters);
	/**
	 * 保存用户
	 * @param user
	 */
	void save(User user);
	/**
	 * 更新用户
	 * @param user
	 */
	void update(User user);

//	void delete(Long id);
	/**
	 * 根据token字符串查询token对象
	 * @param access_token
	 * @return
	 */
	AccessToken findAccessTokenByAccessToken(String access_token);
	/**
	 * 获得用户的token
	 * @param userId
	 * @return
	 */
	AccessToken findAccessTokenByUserid(Long userId);
	/**
	 * 保存token
	 * @param accessToken
	 */
	void insertAccessToken(AccessToken accessToken);
	/**
	 * 更新token
	 * @param accessToken
	 */
	void updateAccessToken(AccessToken accessToken);
	
}
