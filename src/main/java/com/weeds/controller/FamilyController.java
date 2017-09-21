package com.weeds.controller;

import java.io.File;
import java.util.Date;
import java.util.Iterator;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springside.modules.web.Servlets;

import com.weeds.common.Constants;
import com.weeds.entity.pojo.Family;
import com.weeds.service.FamilyService;
import com.weeds.utils.DateUtils;
import com.weeds.utils.GlobalKeys;
import com.weeds.utils.StringUtil;

/**
 * 管理员管理用户的Controller.
 * 
 * @author calvin
 */
@Controller
@RequestMapping(value = "/family/")
public class FamilyController {
	
	private Logger logger = Logger.getLogger(FamilyController.class);

	@Autowired
	private FamilyService familyService;
	
	
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
		parameters.put("status", "0");
		Page<Family> acList = familyService.getFamilyList(parameters,pageNumber,Constants.PAGESIZE);//方式一：查询数据库得到数据
		
		model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(parameters, "search_"));
		model.addAttribute("params", parameters);
		model.addAttribute("familys",acList);
		model.addAttribute("onlick", "lifeServiceId,familyId");
		return "family/familyList";
	}
	
	/**   
	 * 此方法描述的是:保存修改
	 * @param user
	 * @param redirectAttributes
	 * @return  String
	 */   
	
	@RequestMapping(value = "saveOrUpdate")
	public String saveOrUpdate(Family family ,HttpServletRequest request,HttpServletResponse response) {
		
		try {
			
			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
					request.getSession().getServletContext());
			if (multipartResolver.isMultipart(request)) {
				MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
				
				Iterator<String> iter = multiRequest.getFileNames();
				while (iter.hasNext()) {
					MultipartFile file = multiRequest.getFile((String) iter.next());
					if (file != null && !file.isEmpty()) {
						String fileName = file.getOriginalFilename();
						String fieldName =  file.getName();
						String forder = "avatar";	
						String dataForder = DateUtils.dateToString(new Date(), "yyyyMMdd");
						String localPath = GlobalKeys.getConstantsByKeyForProperties("uploadUrl", "d://root//images//") + forder + File.separator + dataForder + File.separator;
						String imgName = new Date().getTime() + ".png";
						File targetFile = new File(localPath,imgName);
						if (!targetFile.exists()) {
							targetFile.mkdirs();
						}
						String imagePathName = localPath + imgName;
						logger.info("本地保存路径="+imagePathName);
						try {
							file.transferTo(targetFile);
							String httpPath =  GlobalKeys.getConstantsByKeyForProperties("httpUrl", "http://demo.dayiinfo.com:8080/images/")
									+ forder + "/" + dataForder + "/" + imgName;
							family.setAvatar(httpPath);
							logger.info("http访问 路径="+imagePathName);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					
				}
				
			}
			
			familyService.saveOrUpdateFamily(family);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/family/";
	}
	
	/**   
	 * 此方法描述的是：进入到一个修改页面
	 * @param id
	 * @param model
	 * @return  String
	 */   
	
	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") String id, Model model) {
		
		model.addAttribute("family", familyService.getFamilyObject(id));
		model.addAttribute("onlick", "lifeServiceId,familyId");
		return "family/familyForm";
	}
	/**   
	 * 此方法描述的是：进入到一个修改页面
	 * @param id
	 * @param model
	 * @return  String
	 */   
	
	@RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
	public String detail(@PathVariable("id") String id, Model model) {
		
		model.addAttribute("family", familyService.getFamilyObject(id));
		model.addAttribute("onlick", "lifeServiceId,familyId");
		return "family/familyDetail";
	}
	/**   
	 * 此方法描述的是：进入到一个创建页面
	 * @param id
	 * @param model
	 * @return  String
	 */   
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String createForm(Model model) {
		
		model.addAttribute("family", new Family());
		model.addAttribute("onlick", "lifeServiceId,familyId");
		return "family/familyForm";
	}
	/**   
	 * 此方法描述的是:删除
	 * @param id
	 * @param redirectAttributes
	 * @return  String
	 */   
	
	@RequestMapping(value = "delete/{id}")
	public String delete(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
			familyService.deleteFamily(id);
		redirectAttributes.addFlashAttribute("message", "删除成功");
		return "redirect:/family/";
	}
}

