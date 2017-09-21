package com.weeds.dao.quotations;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.weeds.entity.pojo.quotations.QuotationsLaud;

/**
 * Created by admin on 2016/6/1.
 */
@Repository
public interface QuotationsLaudJpaDao extends CrudRepository<QuotationsLaud, String> {
	
	List<QuotationsLaud> findByQuotationsId(String quotationsId);
}
