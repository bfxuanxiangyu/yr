package com.weeds.dao;

import java.util.List;
import java.util.Map;

import com.weeds.entity.pojo.ExpertDepart;

/**
 * Created by admin on 2016/6/1.
 */
@MyBatisRepository
public interface ExpertDepartMapper {

	public List<ExpertDepart> getExpertDepartList(Map<String, Object> parameters);

	public int getExpertDepartCount(Map<String, Object> parameters);

}
