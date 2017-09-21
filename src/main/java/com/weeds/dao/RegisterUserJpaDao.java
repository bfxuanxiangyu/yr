package com.weeds.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.weeds.entity.pojo.RegisterUser;

/**
 * Created by admin on 2016/6/1.
 */
@Repository
public interface RegisterUserJpaDao extends CrudRepository<RegisterUser, String> {
	
	RegisterUser findByPhone(String phone);
}
