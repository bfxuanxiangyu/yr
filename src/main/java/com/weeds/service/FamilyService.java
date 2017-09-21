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

import com.weeds.dao.FamilyJpaDao;
import com.weeds.dao.FamilyMapper;
import com.weeds.entity.pojo.Family;
import com.weeds.utils.StringUtil;

/**
 * Created by admin on 2016/4/20.
 */
@Service
public class FamilyService {

	@Autowired
	private FamilyJpaDao familyJpaDao;
    @Autowired
    private FamilyMapper familyMapper;


    public Page<Family> getFamilyList(Map<String, Object> parameters,int pageNumber, int pageSize) {
    	PageRequest pageRequest = new PageRequest(pageNumber-1,pageSize);
    	parameters.put("begin", pageRequest.getOffset());
    	parameters.put("end", pageRequest.getPageSize());
    	List<Family> acList = familyMapper.getFamilyList(parameters);
    	return new PageImpl<Family>(acList,pageRequest,familyMapper.getFamilyCount(parameters));
    }
    public List<Family> getFamilyList(Map<String, Object> parameters) {
		List<Family> fList = familyMapper.getFamilyList(parameters);
		return fList;
	}
    
    /**
     * 保存
     * @param question
     * @return
     */
    public String saveOrUpdateFamily(Family family){
    	String id = family.getId();
    	if(StringUtils.isBlank(id)){
    		family.setCreateBy(StringUtil.getCurrentUserName());
    		family.setCreateTime(new Date());
    		family.setStatus(0);
    	}else{
    		Family old = familyJpaDao.findOne(id);
    		if(old != null){
    			family.setCreateBy(old.getCreateBy());
    			family.setCreateTime(old.getCreateTime());
    		}
    		family.setUpdateBy(StringUtil.getCurrentUserName());
    		family.setUpdateTime(new Date());
    		
    		if(StringUtil.isEmpty(family.getAvatar())){
    			family.setAvatar(old.getAvatar());
    		}
    	}
    	family = familyJpaDao.save(family);
    	return family.getId();
    }
    
    /**
     * 批处理保存信息
     * @param familyList
     */
    public void batchPersistentFamily(List<Family> familyList){
    	if(familyList != null && !familyList.isEmpty()){
    		for (Family family : familyList) {
    			family.setUpdateTime(new Date());
				familyJpaDao.save(family);
			}
    	}
    }
    
    /**
     * 删除
     * @param question
     * @return
     */
    public void deleteFamily(String id){
    	Family family = familyJpaDao.findOne(id);
    	if(family != null){
    		family.setStatus(1);
    		family.setUpdateBy(StringUtil.getCurrentUserName());
    		family.setUpdateTime(new Date());
    	}
    	familyJpaDao.save(family);
    }
    
    /**
     * 获取单条
     * @param question
     * @return
     */
    public Family getFamilyObject(String id){
    	return familyJpaDao.findOne(id);
    }
    
}
