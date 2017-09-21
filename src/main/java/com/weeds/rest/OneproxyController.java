package com.weeds.rest;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weeds.entity.oneproxy.PartTestOneproxy;
import com.weeds.entity.oneproxy.XOneproxy;
import com.weeds.entity.oneproxy.YOneproxy;
import com.weeds.entity.oneproxy.ZOneproxy;
import com.weeds.service.oneproxy.OneproxyService;
import com.weeds.utils.DateUtils;
import com.weeds.utils.ResponseUtil;
import com.weeds.utils.StringUtil;


/**
 * 语录接口
 * 
 * @author xuanxy
 */
@Controller
@RequestMapping(value = "/api/proxy")
public class OneproxyController extends HttpServlet{


	private static final long serialVersionUID = 1L;
	
	private Logger logger = Logger.getLogger(OneproxyController.class);
	
	@Autowired
	private OneproxyService oneproxyService;
	
	@RequestMapping (value = "operX.json")
	public void operX(HttpServletResponse response)  throws IOException {
		
		try {
			XOneproxy x = new XOneproxy();
			x.setName("轩"+StringUtil.getRandomVal(2, 6, null));
			x.setAddress("上海"+StringUtil.getRandomVal(2, 6, null));
			//新增一条
			//oneproxyService.saveX(x);
			//获取所有
			List<XOneproxy> xList = oneproxyService.getXList();
			System.out.println(xList.size());
			//修改一条
			x.setName("轩翔宇");
			x.setAddress("上海市天地软件园");
			x.setId("8a9e91aa5ba45244015ba4539c6f0001");
			//oneproxyService.saveX(x);
			//删除一条
			oneproxyService.deleteXOne("1");
			ResponseUtil.printNonEmptyJson(response, "data", "success");
			
		} catch (Exception e) {
			
			ResponseUtil.printFail(response, 505, "系统升级");
		}
		
	}
	
	@RequestMapping (value = "operY.json")
	public void operY(HttpServletResponse response)  throws IOException {
		
		try {
			YOneproxy y = new YOneproxy();
			y.setName("轩"+StringUtil.getRandomVal(2, 6, null));
			y.setAddress("上海"+StringUtil.getRandomVal(2, 6, null));
			//新增一条
			//oneproxyService.saveY(y);
			//获取所有
			List<YOneproxy> yList = oneproxyService.getYList();
			System.out.println(yList.size());
			//修改一条
			y.setName("轩翔宇");
			y.setAddress("上海市天地软件园");
			y.setId("8a9e91aa5ba45244015ba4539c6f0001");
			//oneproxyService.saveY(y);
			//删除一条
			oneproxyService.deleteYOne("1");
			ResponseUtil.printNonEmptyJson(response, "data", "success");
			
		} catch (Exception e) {
			
			ResponseUtil.printFail(response, 505, "系统升级");
		}
		
	}
	@RequestMapping (value = "operZ.json")
	public void operZ(HttpServletResponse response)  throws IOException {
		
		try {
			ZOneproxy z = new ZOneproxy();
			z.setName("轩"+StringUtil.getRandomVal(2, 6, null));
			z.setAddress("上海"+StringUtil.getRandomVal(2, 6, null));
			//新增一条
			//oneproxyService.saveZ(z);
			//获取所有
			List<ZOneproxy> zList = oneproxyService.getZList();
			System.out.println(zList.size());
			//修改一条
			z.setName("轩翔宇");
			z.setAddress("上海市天地软件园");
			z.setId("8a9e91aa5ba45244015ba4539c6f0001");
			//oneproxyService.saveZ(z);
			//删除一条
			oneproxyService.deleteZOne("1");
			ResponseUtil.printNonEmptyJson(response, "data", "success");
			
		} catch (Exception e) {
			
			ResponseUtil.printFail(response, 505, "系统升级");
		}
		
	}
	
	@RequestMapping (value = "operPart.json")
	public void operPart(HttpServletResponse response)  throws IOException {
		
		try {
			PartTestOneproxy p = null;
			for (int i = 0; i < 100; i++) {
				p = new PartTestOneproxy();
				p.setId(StringUtil.getRandomVal(2, 32, null));
				p.setContent("阿斯顿发生的发发的"+StringUtil.getRandomVal(2, 6, null));
				p.setFtime(DateUtils.randomDate("2017-04-24 00:00:00", "2017-04-25 23:59:59"));
				//新增一条
				oneproxyService.savePartTest(p);;
				System.out.println("第"+i+"次插入");
			}
			ResponseUtil.printNonEmptyJson(response, "data", "success");
			
		} catch (Exception e) {
			
			ResponseUtil.printFail(response, 505, "系统升级");
		}
		
	}
    
}
