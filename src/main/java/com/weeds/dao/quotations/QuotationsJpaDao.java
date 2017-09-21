package com.weeds.dao.quotations;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.weeds.entity.pojo.quotations.Quotations;

/**
 * Created by admin on 2016/6/1.
 */
@Repository
public interface QuotationsJpaDao extends CrudRepository<Quotations, String> {
}
