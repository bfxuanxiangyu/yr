package com.weeds.dao.quotations;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.weeds.entity.pojo.quotations.QuotationsComment;

/**
 * Created by admin on 2016/6/1.
 */
@Repository
public interface QuotationsCommentJpaDao extends CrudRepository<QuotationsComment, String> {
	
	List<QuotationsComment> findByQuotationsId(String quotationsId);
	
}
