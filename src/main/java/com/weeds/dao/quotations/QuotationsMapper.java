package com.weeds.dao.quotations;

import java.util.List;
import java.util.Map;

import com.weeds.dao.MyBatisRepository;
import com.weeds.entity.pojo.quotations.Quotations;
import com.weeds.entity.pojo.quotations.QuotationsComment;
import com.weeds.entity.pojo.quotations.QuotationsLaud;

/**
 * Created by admin on 2016/6/1.
 */
@MyBatisRepository
public interface QuotationsMapper {
	
	/********语录接口********/
	public List<Quotations> getQuotationsList(Map<String, Object> parameters);
	
	public int getQuotationsCount(Map<String, Object> parameters);
	
	/********语录点赞接口********/
	public List<QuotationsLaud> getQuotationsLaudList(Map<String, Object> parameters);
	
	public int getQuotationsLaudCount(Map<String, Object> parameters);
	
	/********语录评论接口********/
	public List<QuotationsComment> getQuotationsCommentList(Map<String, Object> parameters);

	public int getQuotationsCommentCount(Map<String, Object> parameters);

}
