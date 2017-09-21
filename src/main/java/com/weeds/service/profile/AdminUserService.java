package com.weeds.service.profile;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.security.utils.Digests;
import org.springside.modules.utils.DateProvider;
import org.springside.modules.utils.Encodes;

import com.weeds.dao.AdminUserDao;
import com.weeds.dao.jpaDao.AdminUserJpaDao;
import com.weeds.entity.District;
import com.weeds.entity.profile.AdminUser;
import com.weeds.entity.profile.AdminUserRoles;
import com.weeds.entity.profile.Roles;
import com.weeds.service.ServiceException;
import com.weeds.service.profile.ShiroDbRealm.ShiroUser;
import com.weeds.utils.SpringFactoryUtils;
import com.weeds.utils.StringUtil;
import com.google.common.collect.Maps;

/**
 * 用户管理类.
 * 
 * @author calvin
 */
// Spring Service Bean的标识.
@Component
@Transactional(readOnly = true)
public class AdminUserService {

	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	private static final int SALT_SIZE = 8;

	private static Logger logger = LoggerFactory.getLogger(AdminUserService.class);

	@Autowired
	private AdminUserDao adminUserDao;
	
	@Autowired(required=false)
	private AdminUserJpaDao adminUserJpaDao;
	
	private DateProvider dateProvider = DateProvider.DEFAULT;

	/**   
	 * 此方法描述的是:根据不同的条件得到用户列表
	 * @return  List<AdminUser>
	 */   
	    
	public List<AdminUser> getAllAdminUser(Map<String, Object> parameters) {
		return (List<AdminUser>) adminUserDao.search(parameters);
	}
	
	public Page<AdminUser> getAdminUser(Map<String, Object> parameters,int pageNumber, int pageSize) {
		PageRequest pageRequest = new PageRequest(pageNumber-1,pageSize);
		parameters.put("begin", pageRequest.getOffset());
		parameters.put("end", pageRequest.getPageSize());
		List<AdminUser> list = adminUserDao.search(parameters);
		
		return new PageImpl<AdminUser>(list,pageRequest,adminUserDao.searchCount(parameters));
	}

	/**   
	 * 此方法描述的是:根据id得到用户
	 * @param id
	 * @return  AdminUser
	 */   
	    
	public AdminUser getAdminUser(Long id) {
		return adminUserDao.findById(id);
	}
	
	@Transactional(readOnly = false)
	public void updatePassword(AdminUser adminUser) {//修改密码
		AdminUser adminUsera = getAdminUserJpaDao().findOne(adminUser.getId());
		adminUsera.setPlainPassword(adminUser.getPlainPassword());
		adminUsera.setUpdateTime(new Date());
		entryptPassword(adminUsera);
		getAdminUserJpaDao().save(adminUsera);
	}

	/**   
	 * 此方法描述的是:根据用户名得到用户
	 * @param loginName
	 * @return  AdminUser
	 */   
	    
	public AdminUser findAdminUserByLoginName(String loginName) {
		return adminUserDao.findByLoginName(loginName);
	}
	

	/**   
	 * 此方法描述的是:保存一个新用户
	 * @param adminUser
	 * @return  Long
	 */   
	    
	@Transactional(readOnly = false)
	public Long saveAdminUser(AdminUser adminUser) {
		entryptPassword(adminUser);
		adminUser.setCreatedTime(dateProvider.getDate());
		adminUser.setUpdateTime(new Date());
		AdminUser adminUsera = getAdminUserJpaDao().save(adminUser);
		return adminUsera.getId();
		//return Long.valueOf(adminUserDao.save(adminUser));
		
	}

	/**   
	 * 此方法描述的是:修改一个用户信息 
	 * @param adminUser
	 * @return  Long
	 */   
	    
	@Transactional(readOnly = false)
	public Long updateAdminUser(AdminUser adminUser) {
		if (adminUser.getPlainPassword()!=null && !adminUser.getPlainPassword().equals("")) {
			entryptPassword(adminUser);
		}
		adminUser.setUpdateTime(new Date());
		adminUserDao.update(adminUser);
		return adminUser.getId();
	}

	/**   
	 * 此方法描述的是:删除一个用户
	 * @param id  void
	 */   
	    
	@Transactional(readOnly = false)
	public void deleteAdminUser(Long id) {
		if (isSupervisor(id)) {
			logger.warn("操作员{}尝试删除超级管理员用户", getCurrentAdminUserName());
			throw new ServiceException("不能删除超级管理员用户");
		}
		adminUserDao.delete(id);

	}
	
	
	/*************用户权限和角色****************/
	
	/**
	 * 根据条件得到角色集合
	 * @param parameters
	 * @return
	 */
	public List<Roles> searchRolesList(Map<String, Object> parameters){
		return adminUserDao.searchRolesList(parameters);
	}
	
	/**
	 * 根据条件得到角色一个角色
	 * @param parameters
	 * @return
	 */
	public Roles searchRolesObject(Map<String, Object> parameters){
		return adminUserDao.searchRolesObject(parameters);
	}
	
	/**
	 * 保存或修改一个角色
	 * @param roles
	 */
	@Transactional(readOnly = false)
	public String saveOrUpdateRoles(Roles roles) {
		String returnStr = "";
		if(roles.getId()!=null){//修改
			adminUserDao.updateRoles(roles);
			returnStr = "更新成功";
		}else{//保存
			adminUserDao.addRoles(roles);
			returnStr = "新增成功";
		}
		return returnStr;
	}
	
	/**   
	 * 此方法描述的是:删除一个角色
	 * @param id  void
	 */   
	@Transactional(readOnly = false)
	public void deleteRoles(Long id) {
		adminUserDao.deleteRoles(id);
	}
	
	/**
	 * 根据条件用户权限关联表
	 * @param parameters
	 */
	@Transactional(readOnly = false)
	public void deleteAdminUserRoles(Map<String, Object> parameters){
		adminUserDao.deleteAdminUserRoles(parameters);
	}
	
	/**
	 * 新增用户权限关联表
	 * @param aur
	 */
	@Transactional(readOnly = false)
	public void saveOrUpdateAdminUserRoles(AdminUserRoles aur){
		if(aur.getId()==null){//新增
			adminUserDao.addAdminUserRoles(aur);
		}else{//修改
			adminUserDao.updateAdminUserRoles(aur);
		}
	}
	
	/**
	 * 根据条件得到用户权限关联对象集合
	 * @param parameters
	 * @return
	 */
	public AdminUserRoles searchAdminUserRolesObject(Map<String, Object> parameters){
		return adminUserDao.searchAdminUserRolesObject(parameters);
	}
	/*************用户权限和角色****************/
	
	
	
	
	
	
	
	

	/**
	 * 判断是否超级管理员.
	 */
	private boolean isSupervisor(Long id) {
		return id == 1;
	}

	/**
	 * 取出Shiro中的当前用户LoginName.
	 */
	private String getCurrentAdminUserName() {
		ShiroUser adminUser = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return adminUser.loginName;
	}

	/**
	 * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
	 */
	private void entryptPassword(AdminUser adminUser) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		adminUser.setSalt(Encodes.encodeHex(salt));

		byte[] hashPassword = Digests.sha1(adminUser.getPlainPassword().getBytes(), salt, HASH_INTERATIONS);
		adminUser.setPassword(Encodes.encodeHex(hashPassword));
	}
	
	@Autowired
	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}

	public void setDateProvider(DateProvider dateProvider) {
		this.dateProvider = dateProvider;
	}

	public AdminUserJpaDao getAdminUserJpaDao() {
		if(adminUserJpaDao==null){
			adminUserJpaDao = (AdminUserJpaDao) SpringFactoryUtils.getBean("adminUserJpaDao");
		}
		return adminUserJpaDao;
	}

	public void setAdminUserJpaDao(AdminUserJpaDao adminUserJpaDao) {
		this.adminUserJpaDao = adminUserJpaDao;
	}
	
	public List<District> getDistrictList(Map<String, Object> parameters){
		return adminUserDao.getDistrictList(parameters);
	}

}
