package com.weeds.service.oneproxy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weeds.dao.oneproxy.PartTestOneproxyJpaDao;
import com.weeds.dao.oneproxy.XOneproxyJpaDao;
import com.weeds.dao.oneproxy.YOneproxyJpaDao;
import com.weeds.dao.oneproxy.ZOneproxyJpaDao;
import com.weeds.entity.oneproxy.PartTestOneproxy;
import com.weeds.entity.oneproxy.XOneproxy;
import com.weeds.entity.oneproxy.YOneproxy;
import com.weeds.entity.oneproxy.ZOneproxy;

/**
 * Created by admin on 2016/4/20.
 */
@Service
public class OneproxyService {

	@Autowired
	private XOneproxyJpaDao xJpaDao;
	@Autowired
	private YOneproxyJpaDao yJpaDao;
	@Autowired
	private ZOneproxyJpaDao zJpaDao;
	@Autowired
	private PartTestOneproxyJpaDao partJapDao;
	
	/**************操作x*************/
	public List<XOneproxy> getXList(){
		return (List<XOneproxy>) xJpaDao.findAll();
	}
	
	public XOneproxy getXOne(String id){
		return xJpaDao.findOne(id);
	}
	
	public void deleteXOne(String id){
		xJpaDao.delete(id);
	}
	
	public void saveX(XOneproxy x){
		xJpaDao.save(x);
	}
	/**************操作Y*************/
	public List<YOneproxy> getYList(){
		return (List<YOneproxy>) yJpaDao.findAll();
	}
	
	public YOneproxy getYOne(String id){
		return yJpaDao.findOne(id);
	}
	
	public void deleteYOne(String id){
		yJpaDao.delete(id);
	}
	
	public void saveY(YOneproxy y){
		yJpaDao.save(y);
	}
	/**************操作Z*************/
	public List<ZOneproxy> getZList(){
		return (List<ZOneproxy>) zJpaDao.findAll();
	}
	
	public ZOneproxy getZOne(String id){
		return zJpaDao.findOne(id);
	}
	
	public void deleteZOne(String id){
		zJpaDao.delete(id);
	}
	
	public void saveZ(ZOneproxy z){
		zJpaDao.save(z);
	}
    
	/**************操作part_test*************/
	public void savePartTest(PartTestOneproxy p){
		partJapDao.save(p);
	}
}
