package com.weeds.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.weeds.dao.RegisterUserJpaDao;
import com.weeds.dao.RegisterUserMapper;
import com.weeds.entity.pojo.RegisterUser;
import com.weeds.utils.StringUtil;

/**
 * Created by admin on 2016/4/20.
 */
@Service
public class RegisterUserService {

	@Autowired
	private RegisterUserJpaDao registerUserJpaDao;
    @Autowired
    private RegisterUserMapper registerUserMapper;


    public Page<RegisterUser> getRegisterUserList(Map<String, Object> parameters,int pageNumber, int pageSize) {
    	PageRequest pageRequest = new PageRequest(pageNumber-1,pageSize);
    	parameters.put("begin", pageRequest.getOffset());
    	parameters.put("end", pageRequest.getPageSize());
    	List<RegisterUser> acList = registerUserMapper.getRegisterUserList(parameters);
    	return new PageImpl<RegisterUser>(acList,pageRequest,registerUserMapper.getRegisterUserCount(parameters));
    }
    public List<RegisterUser> getRegisterUserList(Map<String, Object> parameters) {
		List<RegisterUser> fList = registerUserMapper.getRegisterUserList(parameters);
		return fList;
	}
    
    /**
     * 保存
     * @param question
     * @return
     */
    public String saveOrUpdateRegisterUser(RegisterUser registerUser){
    	String id = registerUser.getId();
    	if(StringUtils.isBlank(id)){
    		registerUser.setCreateTime(new Date());
    		registerUser.setDeleteFlag(0);
    		registerUser.setPassword(StringUtil.encryptPassword(registerUser.getPassword()));
    	}else{
    		RegisterUser old = registerUserJpaDao.findOne(id);
    		if(old != null){//修改的时候不允许修改密码
    			registerUser.setPassword(old.getPassword());
    			registerUser.setCreateTime(old.getCreateTime());
    		}
    		registerUser.setUpdateTime(new Date());
    	}
    	registerUser = registerUserJpaDao.save(registerUser);
    	return registerUser.getId();
    }
    /**
     * 保存
     * @param question
     * @return
     */
    public void updatePassword(RegisterUser user){
		user.setUpdateTime(new Date());
    	registerUserJpaDao.save(user);
    }
    
    /**
     * 删除
     * @param question
     * @return
     */
    public void deleteRegisterUser(String id){
    	RegisterUser registerUser = registerUserJpaDao.findOne(id);
    	if(registerUser != null){
    		registerUser.setDeleteFlag(1);
    		registerUser.setUpdateTime(new Date());
    	}
    	registerUserJpaDao.save(registerUser);
    }
    
    /**
     * 获取单条
     * @param question
     * @return
     */
    public RegisterUser getRegisterUserObject(String id){
    	return registerUserJpaDao.findOne(id);
    }
    
    /**
     * 获取单条
     * @param question
     * @return
     */
    public RegisterUser getRegisterUserByPhone(String phone){
    	return registerUserJpaDao.findByPhone(phone);
    }
    
}
