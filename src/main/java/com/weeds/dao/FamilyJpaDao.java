package com.weeds.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.weeds.entity.pojo.Family;

/**
 * Created by admin on 2016/6/1.
 */
@Repository
public interface FamilyJpaDao extends CrudRepository<Family, String> {
}
