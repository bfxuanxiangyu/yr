package com.weeds.controller;

import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springside.modules.web.Servlets;

import com.weeds.common.Constants;
import com.weeds.entity.pojo.ExpertDepart;
import com.weeds.service.ExpertDepartService;
import com.weeds.utils.StringUtil;

/**
 * 管理员管理用户的Controller.
 * 
 * @author calvin
 */
@Controller
@RequestMapping(value = "/depart/")
public class ExpertDepartController {
	
	private Logger logger = Logger.getLogger(ExpertDepartController.class);

	@Autowired
	private ExpertDepartService expertDepartService;
	
	
	/**   
	 * 此方法描述的是:根据不同条件查询医生列表
	 * @param model
	 * @return  String
	 */   
	    
	@RequestMapping(method = RequestMethod.GET)
	public String list(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
			Model model,ServletRequest request) throws Exception {		
		Map<String, Object> parameters = StringUtil.getParametersStartingWith(request, "search_");
		parameters = StringUtil.removeVauleNull(parameters);
		Page<ExpertDepart> acList = expertDepartService.getExpertDepartList(parameters,pageNumber,Constants.PAGESIZE);//方式一：查询数据库得到数据
		
		model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(parameters, "search_"));
		model.addAttribute("params", parameters);
		model.addAttribute("expertDeparts",acList);
		model.addAttribute("onlick", "systemId,specialtyId");
		return "depart/expertDepartList";
	}
	
	/**   
	 * 此方法描述的是:保存修改
	 * @param user
	 * @param redirectAttributes
	 * @return  String
	 */   
	
	@RequestMapping(value = "saveOrUpdate")
	public String saveOrUpdate(ExpertDepart expertDepart ,HttpServletRequest request,HttpServletResponse response) {
		
		try {
			
			expertDepartService.saveOrUpdateExpertDepart(expertDepart);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/depart/";
	}
	
	/**   
	 * 此方法描述的是：进入到一个修改页面
	 * @param id
	 * @param model
	 * @return  String
	 */   
	
	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") String id, Model model) {
		
		model.addAttribute("expertDepart", expertDepartService.getExpertDepartObject(id));
		model.addAttribute("onlick", "systemId,specialtyId");
		return "depart/expertDepartForm";
	}
	/**   
	 * 此方法描述的是：进入到一个创建页面
	 * @param id
	 * @param model
	 * @return  String
	 */   
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String createForm(Model model) {
		
		model.addAttribute("expertDepart", new ExpertDepart());
		model.addAttribute("onlick", "systemId,specialtyId");
		return "depart/expertDepartForm";
	}
	/**   
	 * 此方法描述的是:删除
	 * @param id
	 * @param redirectAttributes
	 * @return  String
	 */   
	
	@RequestMapping(value = "delete/{id}")
	public String delete(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
			expertDepartService.deleteExpertDepart(id);
		redirectAttributes.addFlashAttribute("message", "删除成功");
		return "redirect:/depart/";
	}
}

