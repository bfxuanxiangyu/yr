package com.weeds.service.profile;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.security.utils.Digests;
import org.springside.modules.utils.DateProvider;
import org.springside.modules.utils.Encodes;

import com.weeds.dao.UserDao;
import com.weeds.entity.profile.AccessToken;
import com.weeds.entity.profile.User;
import com.weeds.service.ServiceException;
import com.weeds.service.profile.ShiroDbRealm.ShiroUser;

/**
 * 用户管理类.
 * 
 * @author calvin
 */
// Spring Service Bean的标识.
@Component
@Transactional(readOnly = true)
public class AccountService {

	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	private static final int SALT_SIZE = 8;

	private static Logger logger = LoggerFactory.getLogger(AccountService.class);

//	private UserDao userDao;
	@Autowired
	private UserDao userDao;
	private DateProvider dateProvider = DateProvider.DEFAULT;

//	public List<User> getAllUser() {
//		return (List<User>) userDao.findAll();
//	}

	public User getUser(Long id) {
		return userDao.get(id);
	}

	public User findUserByLoginName(String loginName) {
		return userDao.findByLoginName(loginName);
	}
	
//	public User findUserByNickname(String loginName) {
//		return userDao.findByLoginName(loginName);
//	}

	@Transactional(readOnly = false)
	public Long saveUser(User user) {
		entryptPassword(user);
		user.setCreatedTime(dateProvider.getDate());
		userDao.save(user);
		return user.getId();
	}

	@Transactional(readOnly = false)
	public Long updateUser(User user) {
//		if (StringUtils.isNotBlank(user.getPlainPassword())) {
//			entryptPassword(user);
//		}
		userDao.update(user);
		return user.getId();
	}

	@Transactional(readOnly = false)
	public void deleteUser(Long id) {
		if (isSupervisor(id)) {
			logger.warn("操作员{}尝试删除超级管理员用户", getCurrentUserName());
			throw new ServiceException("不能删除超级管理员用户");
		}
//		userDao.delete(id);

	}

	/**
	 * 判断是否超级管理员.
	 */
	private boolean isSupervisor(Long id) {
		return id == 1;
	}

	/**
	 * 取出Shiro中的当前用户LoginName.
	 */
	private String getCurrentUserName() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.loginName;
	}

	/**
	 * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
	 */
	private void entryptPassword(User user) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		user.setSalt(Encodes.encodeHex(salt));

		byte[] hashPassword = Digests.sha1(user.getPlainPassword().getBytes(), salt, HASH_INTERATIONS);
		user.setPassword(Encodes.encodeHex(hashPassword));
	}
	
	/**
	 * 判断是否有效 true有效 false无效
	 * 
	 * @param accessToken
	 * @return
	 */
	public boolean isValid(String access_token) {
		AccessToken accessToken = userDao.findAccessTokenByAccessToken(access_token);
		if (accessToken != null) {
			Long end = accessToken.getCreated_time() + accessToken.getExpires_in();
			Long now = System.currentTimeMillis();
			if (now > end) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
	
	/**
	 * 保存accesstoken
	 * 
	 * @param accessToken
	 * @return
	 */
	@Transactional(readOnly = false)
	public void saveAccessToken(AccessToken accessToken) {
		AccessToken at = userDao.findAccessTokenByUserid(accessToken.getUser_id());
		if (at == null) {
			userDao.insertAccessToken(accessToken);
		} else {
			userDao.updateAccessToken(accessToken);
		}
	}

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setDateProvider(DateProvider dateProvider) {
		this.dateProvider = dateProvider;
	}
}
