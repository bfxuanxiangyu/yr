package com.weeds.rest;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weeds.common.Response;
import com.weeds.entity.pojo.RegisterUser;
import com.weeds.service.RegisterUserService;
import com.weeds.utils.ResponseUtil;
import com.weeds.utils.StringUtil;
import com.weeds.utils.ValidateUtil;


/**
 * 微信接口
 * 
 * @author xuanxy
 */
@Controller
@RequestMapping(value = "/api/register")
public class ApiRegisterUserController extends HttpServlet{


	private static final long serialVersionUID = 1L;
	
	private Logger logger = Logger.getLogger(ApiRegisterUserController.class);
	
	@Autowired
	private RegisterUserService registerUserService;
	
	@RequestMapping (value = "test.json")
	public void test(HttpServletResponse response)  throws IOException {
		
		try {
			logger.info("test success");
			ResponseUtil.printNonEmptyJson(response, "data","success");
			
		} catch (Exception e) {
			
			ResponseUtil.printFail(response, 505, "系统升级");
		}
		
	}
	
	/**
	 * 注册用户http://localhost/api/register/register.json?phone=15601605036&password=111111&realName=xuanxy
	 * @param response
	 * @param user
	 * @throws IOException
	 */
	@RequestMapping (value = "register.json")
	public void register(HttpServletResponse response,RegisterUser user)  throws IOException {
		
		try {
			if(StringUtil.isEmpty(user.getPhone()) || StringUtil.isEmpty(user.getPassword()) 
					|| StringUtil.isEmpty(user.getRealName())){
				ResponseUtil.printFailError(response, Response.PARAMETERS + "", "缺少参数");
				return;
			}
			if(!ValidateUtil.isMobile(user.getPhone())){
				ResponseUtil.printFailError(response, Response.PHONEFAIL + "", "手机不合法");
				return;
			}
			if(!ValidateUtil.isPasswordLength(6,user.getPassword())){
				ResponseUtil.printFailError(response, Response.PASSWORDILLEGAL + "", "密码不合法");
				return;
			}
			
			RegisterUser dbUser = registerUserService.getRegisterUserByPhone(user.getPhone());
			if(dbUser != null){
				ResponseUtil.printFailError(response, Response.PHONEALEDY + "", "手机已注册");
				return;
			}
			
			String userId = registerUserService.saveOrUpdateRegisterUser(user);
			
			ResponseUtil.printNonEmptyJson(response, "data" , userId);
			
		} catch (Exception e) {
			
			ResponseUtil.printFail(response, 505, "系统升级");
		}
		
	}
    
}
