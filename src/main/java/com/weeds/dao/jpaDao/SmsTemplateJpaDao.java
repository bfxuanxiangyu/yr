package com.weeds.dao.jpaDao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.weeds.entity.SmsTemplate;

/**
 * Created by Administrator on 2016/2/12.
 */
@Repository
public interface SmsTemplateJpaDao extends CrudRepository<SmsTemplate, String> {
}
