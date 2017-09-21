package com.weeds.dao.jpaDao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.weeds.entity.profile.AdminUser;

/**
 * 
 * jpa 只做增加、修改、删除单个对象
 * @author xuanxy
 */
public interface AdminUserJpaDao extends PagingAndSortingRepository<AdminUser, Long>, JpaSpecificationExecutor<AdminUser> {
	
}
