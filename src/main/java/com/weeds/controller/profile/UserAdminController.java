package com.weeds.controller.profile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springside.modules.mapper.JsonMapper;
import org.springside.modules.web.Servlets;

import com.weeds.common.Constants;
import com.weeds.entity.json.JsonTest;
import com.weeds.entity.profile.AdminUser;
import com.weeds.entity.profile.AdminUserRoles;
import com.weeds.entity.profile.Permission;
import com.weeds.entity.profile.Roles;
import com.weeds.service.profile.AdminUserService;
import com.weeds.service.profile.ShiroDbRealm.ShiroUser;
import com.weeds.utils.DateUtils;
import com.weeds.utils.DownModelExcel;
import com.weeds.utils.GlobalKeys;
import com.weeds.utils.StringUtil;
import com.weeds.utils.cache.UserCache;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 管理员管理用户的Controller.
 * 
 * @author calvin
 */
@Controller
@RequestMapping(value = "/admin/user")
public class UserAdminController {

	@Autowired
	private AdminUserService adminUserService;
	
	private UserCache userCache = UserCache.getInstance();
	
	/**   
	 * 此方法描述的是:根据不同条件查询用户列表
	 * @param model
	 * @return  String
	 */   
	
	@RequestMapping(value="home")
	public String home(Model model) {
		model.addAttribute("onlick", "myHomeId,myHomeId");
		return "common/home";
	}
	@RequestMapping(value="updatePassword")//修改密码
	public String updatePassword(AdminUser adminUser, RedirectAttributes redirectAttributes){
		adminUserService.updatePassword(adminUser);
		return "redirect:/admin/user";
	}
	/**   
	 * 此方法描述的是:根据不同条件查询用户列表
	 * @param model
	 * @return  String
	 */   
	    
	@RequestMapping(method = RequestMethod.GET)
	public String list(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
			Model model,ServletRequest request) throws Exception {		
		Map<String, Object> parameters = StringUtil.getParametersStartingWith(request, "search_");
		parameters = StringUtil.removeVauleNull(parameters);
		Page<AdminUser> users = adminUserService.getAdminUser(parameters,pageNumber,Constants.PAGESIZE);//方式一：查询数据库得到数据
		
		model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(parameters, "search_")+"&index=systemId");
		model.addAttribute("params", parameters);
		model.addAttribute("users", users);
		model.addAttribute("onlick", "systemId,userId");
		
		return "account/adminUserList";
	}
	
	/**   
	 * 此方法描述的是:保存修改用户信息
	 * @param user
	 * @param redirectAttributes
	 * @return  String
	 */   
	    
	@RequestMapping(value = "saveOrUpdate", method = RequestMethod.POST)
	public String saveOrUpdate(Long id,AdminUser adminUser, RedirectAttributes redirectAttributes) {
		
		/*String roles = getRoles(adminUser.getPermissionList());
		if(roles != null){
			adminUser.setPermissions(roles);
		}*/
		 
		if(id!=null){//修改
			adminUserService.updateAdminUser(adminUser);
			//修改用户角色关联表
			Map<String, Object> parameters = Maps.newHashMap();
			parameters.put("userId", adminUser.getId());
			//parameters.put("roleId", adminUser.getRoleId());
			AdminUserRoles adminUserRoles = adminUserService.searchAdminUserRolesObject(parameters);
			if(adminUserRoles == null ){
				adminUserRoles = new AdminUserRoles();
				adminUserRoles.setUserId(adminUser.getId());
			}
			adminUserRoles.setRoleId(adminUser.getRoleId());
			adminUserService.saveOrUpdateAdminUserRoles(adminUserRoles);
			redirectAttributes.addFlashAttribute("message", "更新成功");
		}else{//新增
			adminUserService.saveAdminUser(adminUser);
			//要先入到用户角色关联表中才会生效
			//首先进行查询是否存在，如果存在删除，重新插入
			Map<String, Object> parameters = Maps.newHashMap();
			parameters.put("userId", adminUser.getId());
			//parameters.put("roleId", adminUser.getRoleId());
			AdminUserRoles adminUserRoles = adminUserService.searchAdminUserRolesObject(parameters);
			if(adminUserRoles !=null ){
				adminUserService.deleteAdminUserRoles(parameters);
			}
			adminUserRoles = new AdminUserRoles();
			adminUserRoles.setRoleId(adminUser.getRoleId());
			adminUserRoles.setUserId(adminUser.getId());
			adminUserService.saveOrUpdateAdminUserRoles(adminUserRoles);
			redirectAttributes.addFlashAttribute("message", "新增成功");
		}
		return "redirect:/admin/user";
	}
	

	/**   
	 * 此方法描述的是：进入到一个修改页面
	 * @param id
	 * @param model
	 * @return  String
	 */   
	    
	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") Long id, Model model) {
		
		//带出现有的所有角色
		Map<String, Object> parameters = Maps.newHashMap();
		List<Roles> roles = adminUserService.searchRolesList(parameters); 
		model.addAttribute("roles", roles);
		model.addAttribute("adminUser", adminUserService.getAdminUser(id));
		model.addAttribute("onlick", "systemId,userId");
		return "account/adminUserForm";
	}
	
	/**   
	 * 此方法描述的是:进入一个新增用户页面
	 * @param model
	 * @return  String
	 */   
	    
	@RequestMapping(value="create")
	public String create(Model model){
		//带出现有的所有角色
		Map<String, Object> parameters = Maps.newHashMap();
		List<Roles> roles = adminUserService.searchRolesList(parameters); 
		model.addAttribute("roles", roles);
		model.addAttribute("adminUser", new AdminUser());
		model.addAttribute("onlick", "systemId,userId");
		return "account/adminUserForm";
	}


	/**   
	 * 此方法描述的是:删除用户
	 * @param id
	 * @param redirectAttributes
	 * @return  String
	 */   
	    
	@RequestMapping(value = "delete/{id}")
	public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		AdminUser adminUser = adminUserService.getAdminUser(id);
		//首先删除用户角色关联表中改用户数据
		Map<String, Object> parameters = Maps.newHashMap();
		parameters.put("userId", id);
		adminUserService.deleteAdminUserRoles(parameters);
		if(adminUser != null ){
			adminUserService.deleteAdminUser(id);
		}
		redirectAttributes.addFlashAttribute("message", "删除成功");
		return "redirect:/admin/user";
	}

	/**
	 * 使用@ModelAttribute, 实现Struts2 Preparable二次部分绑定的效果,先根据form的id从数据库查出User对象,再把Form提交的内容绑定到该对象上。
	 * 因为仅update()方法的form中有id属性，因此本方法在该方法中执行.
	 */
	@ModelAttribute("preloadUser")
	public AdminUser getAdminUser(@RequestParam(value = "id", required = false) Long id) {
		if (id != null) {
			return adminUserService.getAdminUser(id);
		}
		return null;
	}
	
	@RequestMapping(value = "checkLoginName")
	@ResponseBody
	public String checkLoginName(@RequestParam("oldLoginName") String oldLoginName,
			@RequestParam("loginName") String loginName) {
		if (loginName.equals(oldLoginName)) {
			return "true";
		} else if (adminUserService.findAdminUserByLoginName(loginName) == null) {
			return "true";
		}

		return "false";
	}
	
	
	/***************************************************角色****************************************************/
	
	/**   
	 * 此方法描述的是:根据不同条件查询角色列表
	 * @param model
	 * @return  String
	 */   
	    
	@RequestMapping(value = "rolesList",method = RequestMethod.GET)
	public String rolesList(Model model) {
		Map<String, Object> parameters = Maps.newHashMap();
		List<Roles> roles = adminUserService.searchRolesList(parameters);
		List<String> permissionListTmp = Lists.newArrayList();
		if(!roles.isEmpty()){
			for(Roles role : roles){
				permissionListTmp.clear();
				String roleStrs = role.getRoles();
				String split[] = roleStrs.split(",");
				for (int i = 0; i < split.length; i++) {
					permissionListTmp.add(split[i]);
				}
				role.setPermissionList(permissionListTmp);
				role.setRoles(role.getPermissionNames());
			}
		}
		
		model.addAttribute("roles", roles);
		model.addAttribute("onlick", "systemId,roleId");
		return "account/rolesList";
	}
	
	/**   
	 * 此方法描述的是:保存修改角色信息
	 * @param user
	 * @param redirectAttributes
	 * @return  String
	 */   
	    
	@RequestMapping(value = "saveOrUpdateRoles", method = RequestMethod.POST)
	public String saveOrUpdateRoles(Long id,Roles role, RedirectAttributes redirectAttributes) {
		
		String roles = getRoles(role.getPermissionList());
		if(roles != null){
			role.setRoles(roles);
		}
		 
		//String resultStr = adminUserService.saveOrUpdateRoles(role);
		redirectAttributes.addFlashAttribute("message", "success");
		return "redirect:/admin/user/rolesList";
	}
	

	/**   
	 * 此方法描述的是：进入到一个角色修改页面
	 * @param id
	 * @param model
	 * @return  String
	 */   
	    
	@RequestMapping(value = "updateRoles/{id}", method = RequestMethod.GET)
	public String updateRolesForm(@PathVariable("id") Long id, Model model) {
		Map<String, Object> parameters = Maps.newHashMap();
		List<String> permissionListTmp = Lists.newArrayList();
		parameters.put("id", id);
		
		Roles role = adminUserService.searchRolesObject(parameters);
		if(role != null){
			String split[] = role.getRoles().split(",");
			for (int i = 0; i < split.length; i++) {
				permissionListTmp.add(split[i]);
			}
			role.setPermissionList(permissionListTmp);
			model.addAttribute("role", role);
			//带出现有的所有权限
			model.addAttribute("allPermissions", Permission.values());
			model.addAttribute("onlick", "systemId,roleId");
			return "account/rolesForm";
		}else{
			model.addAttribute("allPermissions", Permission.values());
			model.addAttribute("role", new Roles());
			model.addAttribute("onlick", "systemId,roleId");
			return "account/rolesForm";
		}
	}
	
	/**   
	 * 此方法描述的是:进入一个新增角色页面
	 * @param model
	 * @return  String
	 */   
	    
	@RequestMapping(value="addRoles")
	public String addRoles(Model model){
		//带出现有的所有权限
		model.addAttribute("allPermissions", Permission.values());
		model.addAttribute("role", new Roles());
		model.addAttribute("onlick", "systemId,roleId");
		return "account/rolesForm";
	}


	/**   
	 * 此方法描述的是:删除角色
	 * @param id
	 * @param redirectAttributes
	 * @return  String
	 */   
	    
	@RequestMapping(value = "deleteRoles/{id}")
	public String deleteRoles(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		Map<String, Object> parameters = Maps.newHashMap();
		parameters.put("id", id);
		Roles role = adminUserService.searchRolesObject(parameters);
		if(role != null ){
			adminUserService.deleteRoles(id);
			redirectAttributes.addFlashAttribute("message", "删除成功");
		}else{
			redirectAttributes.addFlashAttribute("message", "没有找的需要删除的角色");
		}
		return "redirect:/admin/user/rolesList";
	}
	
	
	
	
	
	
	
	/****************************************************角色***************************************************/
	
	
	
	
	
	/**   
	 * 此方法描述的是:处理得到的页面权限
	 * @param per
	 * @return  String
	 */   
	    
	public String getRoles(List<String> per){
		String roles = "";
		if(per!=null && !per.isEmpty()){
			for (int i = 0; i < per.size(); i++) {
				String str = per.get(i);
				roles += str+",";
			}
			roles = roles.substring(0, roles.length()-1);
		}
		if(roles==null || roles.equals("")){
			return null;
		}else{
			return roles;
		}
	}

	/**   
	 * 此方法描述的是:进入一个新增用户页面
	 * @param model
	 * @return  String
	 */   
	
	@RequestMapping(value="addSessionStyle")
	public String addSessionStyle(HttpServletRequest request){
		String headTitles = request.getParameter("headTitles");
		String childTiles = request.getParameter("childTiles");
		HttpSession session = request.getSession();
		session.setAttribute("headTitles", headTitles);
		session.setAttribute("childTiles", childTiles);
		return null;
	}
	/**
	 * 返回折线图页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="zhedian")
	public String zhedian(Model model) {
		return "account/zhexian";
	}
	/**
	 * 返回仪表盘页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="yibiaopan")
	public String yibiaopan(Model model) {
		return "account/yibiaopan";
	}
	/**
	 * 返回饼图 页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="bingtu")
	public String bingtu(Model model) {
		return "account/bingtu";
	}
	/**
	 * 获取当前登录菜单id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="jsonGetMenuId")
	public String getMenuId(Model model,HttpServletResponse response) {
		String str = null;
		try {
			ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
			if(user != null){
				str = GlobalKeys.menuIdMaps.get(user.loginName);
			}
			response.getWriter().print(str);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	/**
	 * 更新当前登录菜单id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="jsonUpdateMenuId")
	public String updateMenuId(String clickMenuId, Model model,HttpServletResponse response) {
		try {
			ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
			if(user != null){
				GlobalKeys.menuIdMaps.put(user.loginName,clickMenuId);
			}
			response.getWriter().print("success");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	/**
	 * 获取json数据
	 * @param model
	 * @return
	 */
	@RequestMapping(value="jsonData")
	public String jsonData(Model model,HttpServletResponse response) {
		List<JsonTest> jt = Lists.newArrayList();
		JsonTest jtO = new JsonTest();
		DecimalFormat df = new DecimalFormat("0.0");
		Random rd=new Random();//随机数生成器
		for (int i = 3; i < 13; i++) {
			jtO = new JsonTest();
			String name = "";
			double data = 0.0;
			double j= rd.nextDouble()*10 + 20;
			name = DateUtils.dateToString(DateUtils.getOffsetTime(new Date(), i, 2),DateUtils.FORMAT_DATE_ONE);
			data = Double.valueOf(df.format(j));
			jtO.setName(name);
			jtO.setData(data);
			jt.add(jtO);
		}
		try {
			JsonMapper jm = new JsonMapper();
			String str = jm.toJson(jt);
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print(str);
			response.getWriter().close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	// 导出函数
	@RequestMapping(value="export")
	public void  export(HttpServletRequest request,HttpServletResponse response) throws Exception{
		// 导出类型
		String type = request.getParameter("type");
		// SVG代码，官方默认是以文件形式上传，用jsp/servlet 的request.getParameter(arg0)是无法获取该值的，所以这里利用Struts2来帮我们处理。更多详情我将在Highcharts中文论坛上详细说明
		String svg  = request.getParameter("svg");
		// 文件名
		float width = Float.valueOf(request.getParameter("width"));
		/**
		 * 第二步：将svg代码保存为svg文件
		 */
		
		// 打印获取的参数，确保可以获取值且中文不会乱码，如果出现乱码，请将你的Highcharts页面的编码设置为UTF-8
		// System.out.println(type + "\n" + filename + "\n" +svg + "\n" + width+"\n"+scale); 
		
		// 获取项目的绝对路径
		@SuppressWarnings("deprecation")
		String WebRoot = request.getRealPath("")+"\\temp\\";
		
		// SVG临时文件名
		String temp = WebRoot+System.currentTimeMillis()+(int)(Math.random()*1000)+".svg";

		// 将svg代码写入到临时文件中，文件后缀的.svg
		File svgTempFile = new File(temp);
		//写入文件，注意文件编码
		OutputStreamWriter svgFileOsw = new OutputStreamWriter(new FileOutputStream(svgTempFile),"UTF-8");
		svgFileOsw.write(svg);
		svgFileOsw.flush();
		svgFileOsw.close();
		
		/**
		 * 第三步：调用转换函数，生成目标文件
		 */
		/*MyConverter mc = new MyConverter();
		// 调用转换函数，返回目标文件名
		String filename = mc.conver(temp,WebRoot, type, width);
		
		// 读取目标文件流，转换调用下载
		File resultFile = new File(WebRoot+filename);
		FileInputStream resultFileFi = new FileInputStream(resultFile);
		long l = resultFile.length();
		int k = 0;
		byte abyte0[] = new byte[65000];
		
		*//**
		 * 第四步：调用浏览器下载
		 *//*
		
		// 调用下载
		response.setContentType("application/x-msdownload");
		response.setContentLength((int) l);
		response.setHeader("Content-Disposition", "attachment; filename=" + filename);
		while ((long) k < l) {
			int j;
			j = resultFileFi.read(abyte0, 0, 65000);
			k += j;
			response.getOutputStream().write(abyte0, 0, j);
		}
		resultFileFi.close();
		
		// 转换成功后，删除临时文件
		svgTempFile.delete();
		resultFile.delete();	*/	
	}
	
	
	
	// 导出函数
	@RequestMapping(value="exportUserInfo")
	public void  exportUserInfo(HttpServletRequest request,HttpServletResponse response) throws Exception{
		try {
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-disposition", "attachment;filename="
					+ new String("用户信息".getBytes(), "ISO-8859-1") + ".xlsx");
			response.setBufferSize(1024 * 1024);
			// 随机生成文件编号
			int random = new Random().nextInt(10000);
			String path = "d:\\11\\";
			String tmpPath = File.separator + "down" + File.separator;
			File targetFolder = new File(path, tmpPath);
			if (!targetFolder.exists()) {
				targetFolder.mkdirs();
			}
			// 转换为字符串
			String formatDate =  DateUtils.dateToString(new Date(),"yyyyMMddHHmmss");
			String savePath = targetFolder.getPath() + File.separator
					+ formatDate + "_" + random + ".xlsx";
			FileOutputStream out1 = new FileOutputStream(savePath);
			long start = System.currentTimeMillis();
			List<AdminUser> list =userCache.getAllUserCache();//方式二：查询缓存得到数据
			this.downExcel(out1, list);
			System.err.println("导出成功...消耗ms：" + (System.currentTimeMillis() - start));
			DownModelExcel.downSaveExcel(request, response, "location_" + formatDate, savePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 导出
	 * @param out
	 * @param list
	 * @throws IOException
	 */
	public void downExcel(OutputStream out, List<AdminUser> list) throws IOException {
		// 存100行在内存中 100后就刷新缓存

		try {
			//存100行在内存中  100后就刷新缓存 
			SXSSFWorkbook wb = new SXSSFWorkbook(100); // keep 100 rows in memory, exceeding rows will be flushed to disk
			Sheet sh = wb.createSheet("sheet1");
	        Row head_row = sh.createRow(0);
	        head_row.createCell(0).setCellValue("库编号 ");
	        head_row.createCell(1).setCellValue("库名称");
	        int h=0;
	        for(AdminUser au : list){
				if(h<100000){
	            	 Row row = sh.createRow(h+1);
					 row.createCell(0).setCellValue(au.getLoginName());
					 row.createCell(1).setCellValue(au.getName());
					 h++;
	            }else{
	            	if(h%100000==0){
	               	 	sh = wb.createSheet("sheet1"+(h/100000));
	                }
	            	 Row row = sh.createRow(h%100000);
	            	 row.createCell(0).setCellValue(au.getLoginName());
					 row.createCell(1).setCellValue(au.getName());
					 h++;
	            }
	        }
	        wb.write(out);
	        out.close();
	        wb.dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

