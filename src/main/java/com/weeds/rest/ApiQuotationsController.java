package com.weeds.rest;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.common.collect.Maps;
import com.weeds.common.Response;
import com.weeds.entity.Page;
import com.weeds.entity.pojo.quotations.Quotations;
import com.weeds.entity.pojo.quotations.QuotationsComment;
import com.weeds.entity.pojo.quotations.QuotationsLaud;
import com.weeds.service.QuotationsService;
import com.weeds.utils.ResponseUtil;
import com.weeds.utils.StringUtil;


/**
 * 语录接口
 * 
 * @author xuanxy
 */
@Controller
@RequestMapping(value = "/api/quotations")
public class ApiQuotationsController extends HttpServlet{


	private static final long serialVersionUID = 1L;
	
	private Logger logger = Logger.getLogger(ApiQuotationsController.class);
	
	@Autowired
	private QuotationsService quotationsService;
	
	/**
	 * 语录列表接口 http://localhost/api/quotations/quotationsList.json?pageIndex=1&pageSize=10
	 * @param response
	 * @param pageIndex
	 * 		  pageSize
	 * @throws IOException
	 */
	@RequestMapping (value = "quotationsList.json")
	public void quotationsList(HttpServletResponse response,int pageIndex,int pageSize)  throws IOException {
		
		try {
			Map<String, Object> parameters = Maps.newHashMap();
			int totalCount = quotationsService.getQuotationsCount(parameters);
			Page page = new Page(totalCount, pageIndex, pageSize);
			parameters.put("begin", page.getBegin());
			parameters.put("end", page.getEnd());
			List<Quotations> qList = quotationsService.getQuotationsList(parameters);
			page.setResults(qList);
			ResponseUtil.printNonEmptyJson(response, "data" , page);
			
		} catch (Exception e) {
			
			ResponseUtil.printFail(response, 505, "系统升级");
		}
		
	}
	/**
	 * 语录单条接口localhost/api/quotations/quotationsDetail.json?quotationsId=8a9e91aa58906b770158906e86780001
	 * @param response
	 * @param pageIndex
	 * 		  pageSize
	 * @throws IOException
	 */
	@RequestMapping (value = "quotationsDetail.json")
	public void quotationsDetail(HttpServletResponse response,String quotationsId)  throws IOException {
		
		try {
			
			if(StringUtil.isEmpty(quotationsId) ){
				ResponseUtil.printFailError(response, Response.PARAMETERS + "", "缺少参数");
				return;
			}
			
			Quotations quotations = quotationsService.getQuotationsObject(quotationsId);
			
			ResponseUtil.printNonEmptyJson(response, "data" , quotations);
			
		} catch (Exception e) {
			
			ResponseUtil.printFail(response, 505, "系统升级");
		}
		
	}
	
	/**
	 * 发起语录http://localhost/api/quotations/quotations.json?userId=8a9e91aa58906b770158906d2b070000&content=hi
	 * @param response
	 * @param quotations
	 * @throws IOException
	 */
	@RequestMapping (value = "quotations.json")
	public void quotations(HttpServletResponse response,Quotations quotations)  throws IOException {
		
		try {
			
			if(StringUtil.isEmpty(quotations.getUserId()) || StringUtil.isEmpty(quotations.getContent())){
				ResponseUtil.printFailError(response, Response.PARAMETERS + "", "缺少参数");
				return;
			}
			
			quotationsService.saveOrUpdateQuotations(quotations);
			logger.info(quotations.getUserId()+"发布语录---"+ quotations.getContent());
			ResponseUtil.printNonEmptyJson(response, "data" , "success");
			
		} catch (Exception e) {
			
			ResponseUtil.printFail(response, 505, "系统升级");
		}
		
	}
	/**
	 * 发起语录评论 http://localhost/api/quotations/commentQuotations.json?userId=8a9e91aa58906b770158906d2b070000&quotationsId=8a9e91aa58906b770158906e86780001&content=%E5%B2%81%E9%9B%A8%E4%BA%BA
	 * @param response
	 * @param quotations
	 * @throws IOException
	 */
	@RequestMapping (value = "commentQuotations.json")
	public void commentQuotations(HttpServletResponse response,QuotationsComment quotationsComment)  throws IOException {
		
		try {
			
			if(StringUtil.isEmpty(quotationsComment.getQuotationsId()) || StringUtil.isEmpty(quotationsComment.getContent())
					|| StringUtil.isEmpty(quotationsComment.getUserId())){
				ResponseUtil.printFailError(response, Response.PARAMETERS + "", "缺少参数");
				return;
			}
			
			quotationsService.saveOrUpdateQuotationsComment(quotationsComment);
			
			ResponseUtil.printNonEmptyJson(response, "data" , "success");
			
		} catch (Exception e) {
			
			ResponseUtil.printFail(response, 505, "系统升级");
		}
		
	}
	/**
	 * 发起语录点赞 http://localhost/api/quotations/laudQuotations.json?userId=8a9e91aa58906b770158906d2b070000&quotationsId=8a9e91aa58906b770158906e86780001
	 * @param response
	 * @param quotations
	 * @throws IOException
	 */
	@RequestMapping (value = "laudQuotations.json")
	public void laudQuotations(HttpServletResponse response,QuotationsLaud quotationsLaud)  throws IOException {
		
		try {
			
			if(StringUtil.isEmpty(quotationsLaud.getQuotationsId()) || StringUtil.isEmpty(quotationsLaud.getUserId())){
				ResponseUtil.printFailError(response, Response.PARAMETERS + "", "缺少参数");
				return;
			}
			
			quotationsService.saveOrUpdateQuotationsLaud(quotationsLaud);
	    	
			ResponseUtil.printNonEmptyJson(response, "data" , "success");
			
		} catch (Exception e) {
			
			ResponseUtil.printFail(response, 505, "系统升级");
		}
		
	}
	
    
}
