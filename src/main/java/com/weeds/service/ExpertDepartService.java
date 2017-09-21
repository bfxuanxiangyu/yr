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

import com.weeds.dao.ExpertDepartJpaDao;
import com.weeds.dao.ExpertDepartMapper;
import com.weeds.entity.pojo.ExpertDepart;

/**
 * Created by admin on 2016/4/20.
 */
@Service
public class ExpertDepartService {

	@Autowired
	private ExpertDepartJpaDao expertDepartJpaDao;
    @Autowired
    private ExpertDepartMapper expertDepartMapper;


    public Page<ExpertDepart> getExpertDepartList(Map<String, Object> parameters,int pageNumber, int pageSize) {
		PageRequest pageRequest = new PageRequest(pageNumber-1,pageSize);
		parameters.put("begin", pageRequest.getOffset());
		parameters.put("end", pageRequest.getPageSize());
		List<ExpertDepart> acList = expertDepartMapper.getExpertDepartList(parameters);
		return new PageImpl<ExpertDepart>(acList,pageRequest,expertDepartMapper.getExpertDepartCount(parameters));
	}
    
    /**
     * 保存
     * @param question
     * @return
     */
    public String saveOrUpdateExpertDepart(ExpertDepart expertDepart){
    	String id = expertDepart.getId();
    	if(StringUtils.isBlank(id)){
    		expertDepart.setcCreateDate(new Date());
    		expertDepart.setcUpdateDate(new Date());
    	}else{
    		expertDepart.setcUpdateDate(new Date());
    	}
    	expertDepartJpaDao.save(expertDepart);
    	return expertDepart.getId();
    }
    
    /**
     * 删除
     * @param question
     * @return
     */
    public void deleteExpertDepart(String id){
    	ExpertDepart ac = expertDepartJpaDao.findOne(id);
    	if(ac != null){
    		ac.setcDeleteFlag(1);
    	}
    	expertDepartJpaDao.save(ac);
    }
    
    /**
     * 获取单条
     * @param question
     * @return
     */
    public ExpertDepart getExpertDepartObject(String id){
    	return expertDepartJpaDao.findOne(id);
    }
    
}
