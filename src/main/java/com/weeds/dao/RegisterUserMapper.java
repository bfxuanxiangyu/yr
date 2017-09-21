package com.weeds.dao;

import java.util.List;
import java.util.Map;

import com.weeds.entity.pojo.RegisterUser;

/**
 * Created by admin on 2016/6/1.
 */
@MyBatisRepository
public interface RegisterUserMapper {

	public List<RegisterUser> getRegisterUserList(Map<String, Object> parameters);

	public int getRegisterUserCount(Map<String, Object> parameters);

}
