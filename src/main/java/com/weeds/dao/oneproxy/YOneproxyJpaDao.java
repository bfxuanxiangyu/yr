package com.weeds.dao.oneproxy;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.weeds.entity.oneproxy.YOneproxy;

/**
 * Created by admin on 2016/6/1.
 */
@Repository
public interface YOneproxyJpaDao extends CrudRepository<YOneproxy, String> {
}
