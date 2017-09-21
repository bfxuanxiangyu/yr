package com.weeds.dao;

import java.util.List;
import java.util.Map;

import com.weeds.entity.pojo.Family;

/**
 * Created by admin on 2016/6/1.
 */
@MyBatisRepository
public interface FamilyMapper {

	public List<Family> getFamilyList(Map<String, Object> parameters);

	public int getFamilyCount(Map<String, Object> parameters);

}
