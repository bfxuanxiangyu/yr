package com.weeds.dao.jpaDao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.weeds.entity.SmsSend;

/**
 * Created by Administrator on 2016/2/11.
 */
public interface SmsSendJpaDao extends PagingAndSortingRepository<SmsSend, String> {
}
