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

import com.weeds.dao.quotations.QuotationsCommentJpaDao;
import com.weeds.dao.quotations.QuotationsJpaDao;
import com.weeds.dao.quotations.QuotationsLaudJpaDao;
import com.weeds.dao.quotations.QuotationsMapper;
import com.weeds.entity.pojo.quotations.Quotations;
import com.weeds.entity.pojo.quotations.QuotationsComment;
import com.weeds.entity.pojo.quotations.QuotationsLaud;

/**
 * Created by admin on 2016/4/20.
 */
@Service
public class QuotationsService {

	@Autowired
	private QuotationsJpaDao quotationsJpaDao;
	@Autowired
	private QuotationsCommentJpaDao quotationsCommentJpaDao;
	@Autowired
	private QuotationsLaudJpaDao quotationsLaudJpaDao;
    @Autowired
    private QuotationsMapper quotationsMapper;


    public Page<Quotations> getQuotationsList(Map<String, Object> parameters,int pageNumber, int pageSize) {
    	PageRequest pageRequest = new PageRequest(pageNumber-1,pageSize);
    	parameters.put("begin", pageRequest.getOffset());
    	parameters.put("end", pageRequest.getPageSize());
    	List<Quotations> acList = quotationsMapper.getQuotationsList(parameters);
    	return new PageImpl<Quotations>(acList,pageRequest,quotationsMapper.getQuotationsCount(parameters));
    }
    public int  getQuotationsCount(Map<String, Object> parameters) {
    	return quotationsMapper.getQuotationsCount(parameters);
    }
    public List<Quotations> getQuotationsList(Map<String, Object> parameters) {
		List<Quotations> fList = quotationsMapper.getQuotationsList(parameters);
		return fList;
	}
    
    /**
     * 保存语录
     * @param question
     * @return
     */
    public String saveOrUpdateQuotations(Quotations quotations){
    	String id = quotations.getId();
    	if(StringUtils.isBlank(id)){
    		quotations.setCreateTime(new Date());
    		quotations.setDeleteFlag(0);
    	}else{
    		Quotations old = quotationsJpaDao.findOne(id);
    		if(old != null){//修改的时候不允许修改密码
    			quotations.setCreateTime(old.getCreateTime());
    		}
    		quotations.setUpdateTime(new Date());
    	}
    	quotations = quotationsJpaDao.save(quotations);
    	return quotations.getId();
    }
    
    /**
     * 删除语录
     * @param question
     * @return
     */
    public void deleteQuotations(String id){
    	Quotations quotations = quotationsJpaDao.findOne(id);
    	if(quotations != null){
    		quotations.setDeleteFlag(1);
    		quotations.setUpdateTime(new Date());
    	}
    	quotationsJpaDao.save(quotations);
    }
    
    /**
     * 获取单条语录
     * @param question
     * @return
     */
    public Quotations getQuotationsObject(String id){
    	Quotations entity = quotationsJpaDao.findOne(id);
    	if(entity != null){
    		entity.setCommentList(quotationsCommentJpaDao.findByQuotationsId(entity.getId()));
    		entity.setLaudList(quotationsLaudJpaDao.findByQuotationsId(entity.getId()));
    	}
    	return entity;
    }
    
    /************************语录评论*************************/
    /**
     * 保存语录评论
     * @param question
     * @return
     */
    public String saveOrUpdateQuotationsComment(QuotationsComment quotationsComment){
    	String id = quotationsComment.getId();
    	if(StringUtils.isBlank(id)){
    		quotationsComment.setCreateTime(new Date());
    		quotationsComment.setDeleteFlag(0);
    	}else{
    		QuotationsComment old = quotationsCommentJpaDao.findOne(id);
    		if(old != null){//修改的时候不允许修改密码
    			quotationsComment.setCreateTime(old.getCreateTime());
    		}
    		quotationsComment.setUpdateTime(new Date());
    	}
    	quotationsComment = quotationsCommentJpaDao.save(quotationsComment);
    	return quotationsComment.getId();
    }
    
    /**
     * 删除语录评论
     * @param question
     * @return
     */
    public void deleteQuotationsComment(String id){
    	QuotationsComment quotationsComment = quotationsCommentJpaDao.findOne(id);
    	if(quotationsComment != null){
    		quotationsComment.setDeleteFlag(1);
    		quotationsComment.setUpdateTime(new Date());
    	}
    	quotationsCommentJpaDao.save(quotationsComment);
    }
    
    /**
     * 获取单条语录评论
     * @param question
     * @return
     */
    public QuotationsComment getQuotationsCommentObject(String id){
    	return quotationsCommentJpaDao.findOne(id);
    }
    /************************语录评论*************************/
    /**
     * 保存语录评论
     * @param question
     * @return
     */
    public String saveOrUpdateQuotationsLaud(QuotationsLaud quotationsLaud){
    	String id = quotationsLaud.getId();
    	if(StringUtils.isBlank(id)){
    		quotationsLaud.setCreateTime(new Date());
    		quotationsLaud.setDeleteFlag(0);
    	}else{
    		QuotationsLaud old = quotationsLaudJpaDao.findOne(id);
    		if(old != null){//修改的时候不允许修改密码
    			quotationsLaud.setCreateTime(old.getCreateTime());
    		}
    		quotationsLaud.setUpdateTime(new Date());
    	}
    	quotationsLaud = quotationsLaudJpaDao.save(quotationsLaud);
    	return quotationsLaud.getId();
    }
    
    /**
     * 删除语录评论
     * @param question
     * @return
     */
    public void deleteQuotationsLaud(String id){
    	QuotationsLaud quotationsLaud = quotationsLaudJpaDao.findOne(id);
    	if(quotationsLaud != null){
    		quotationsLaud.setDeleteFlag(1);
    		quotationsLaud.setUpdateTime(new Date());
    	}
    	quotationsLaudJpaDao.save(quotationsLaud);
    }
    
    /**
     * 获取单条语录评论
     * @param question
     * @return
     */
    public QuotationsLaud getQuotationsLaudObject(String id){
    	return quotationsLaudJpaDao.findOne(id);
    }
    
}
