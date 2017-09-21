package com.weeds.dao;

import java.util.List;
import java.util.Map;

import com.weeds.entity.District;
import com.weeds.entity.profile.AdminUser;
import com.weeds.entity.profile.AdminUserRoles;
import com.weeds.entity.profile.Roles;

/**
 * 通过@MapperScannerConfigurer扫描目录中的所有接口, 动态在Spring Context中生成实现.
 * 方法名称必须与Mapper.xml中保持一致.
 * 
 * @author calvin
 */
@MyBatisRepository
public interface AdminUserDao {
	/**
	 * 根据id查询用户
	 * @param id
	 * @return
	 */
	AdminUser findById(Long id);
	/**
	 * 根据用户名查询用户
	 * @param loginName
	 * @return
	 */
	AdminUser findByLoginName(String loginName);
	/**
	 * 多条件查询用户
	 * @param parameters
	 * @return
	 */
	List<AdminUser> search(Map<String, Object> parameters);
	
	/**
	 * 多条件统计用户
	 * @param parameters
	 * @return
	 */
	int searchCount(Map<String, Object> parameters);
	/**
	 * 保存用户
	 * @param user
	 */
	Integer save(AdminUser adminUser);
	/**
	 * 更新用户
	 * @param user
	 */
	void update(AdminUser adminUser);

	/**   
	 * 此方法描述的是:根据id删除用户
	 * @param id  void
	 */   
	    
	void delete(Long id);
	
	
	/**
	 * 根据条件得到用户权限关联对象集合
	 * @param parameters
	 * @return
	 */
	AdminUserRoles searchAdminUserRolesObject(Map<String, Object> parameters);
	/**
	 * 根据条件得到一个用户权限关联对象
	 * @param parameters
	 * @return
	 */
	List<AdminUserRoles> searchAdminUserRolesList(Map<String, Object> parameters);
	
	/**
	 * 新增用户权限关联表
	 * @param aur
	 */
	void addAdminUserRoles(AdminUserRoles aur);
	
	/**
	 * 修改用户权限关联表
	 * @param aur
	 */
	void updateAdminUserRoles(AdminUserRoles aur);
	
	/**
	 * 根据条件用户权限关联表
	 * @param parameters
	 */
	void deleteAdminUserRoles(Map<String, Object> parameters);
	
	/**
	 * 新增一个角色
	 * @param roles
	 */
	void addRoles(Roles roles);
	
	/**
	 * 修改一个角色
	 * @param roles
	 */
	void updateRoles(Roles roles);
	
	/**
	 * 根据条件删除角色
	 * @param parameters
	 */
	void deleteRoles(Long id);
	
	/**
	 * 根据条件得到角色一个角色
	 * @param parameters
	 * @return
	 */
	Roles searchRolesObject(Map<String, Object> parameters);
	/**
	 * 根据条件得到角色集合
	 * @param parameters
	 * @return
	 */
	List<Roles> searchRolesList(Map<String, Object> parameters);
	
	/**
	 * 得到区域列表
	 * @param parameters
	 * @return
	 */
	List<District> getDistrictList(Map<String, Object> parameters);
}
