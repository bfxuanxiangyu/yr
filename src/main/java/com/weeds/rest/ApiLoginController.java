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
import com.weeds.utils.GlobalKeys;
import com.weeds.utils.ResponseUtil;
import com.weeds.utils.StringUtil;


/**
 * 登录接口
 * 
 * @author xuanxy
 */
@Controller
@RequestMapping(value = "/api/login")
public class ApiLoginController extends HttpServlet{


	private static final long serialVersionUID = 1L;
	
	private Logger logger = Logger.getLogger(ApiLoginController.class);
	
	@Autowired
	private RegisterUserService registerUserService;
	
	/**
	 * 用户登录http://localhost/api/login/login.json?phone=15601605036&password=111111
	 * @param response
	 * @param user
	 * @throws IOException
	 */
	@RequestMapping (value = "login.json")
	public void register(HttpServletResponse response,String phone ,String password)  throws IOException {
		
		try {
			if(StringUtil.isEmpty(phone) || StringUtil.isEmpty(password) ){
				ResponseUtil.printFailError(response, Response.PARAMETERS + "", "缺少参数");
				return;
			}
			
			RegisterUser dbUser = registerUserService.getRegisterUserByPhone(phone);
			if(dbUser == null){
				ResponseUtil.printFailError(response, Response.PHONENO + "", "手机未注册");
				return;
			}
			if(!StringUtil.encryptPassword(password).equals(dbUser.getPassword())){
				ResponseUtil.printFailError(response, Response.PASSWORDFAIL + "", "密码错误");
				return;
			}
			
			logger.info("用户"+phone+"登录成功");
			ResponseUtil.printNonEmptyJson(response, "data" , dbUser);
			
		} catch (Exception e) {
			
			ResponseUtil.printFail(response, 505, "系统升级");
		}
		
	}
	/**
	 * 用户登录http://localhost/api/login/login.json?phone=15601605036&password=111111
	 * @param response
	 * @param user
	 * @throws IOException
	 */
	@RequestMapping (value = "forgetPassword.json")
	public void forgetPassword(HttpServletResponse response,String phone ,String realName)  throws IOException {
		
		try {
			if(StringUtil.isEmpty(phone) || StringUtil.isEmpty(realName) ){
				ResponseUtil.printFailError(response, Response.PARAMETERS + "", "缺少参数");
				return;
			}
			RegisterUser dbUser = registerUserService.getRegisterUserByPhone(phone);
			if(dbUser == null){
				ResponseUtil.printFailError(response, Response.PHONENO + "", "手机未注册");
				return;
			}
			if(!realName.equals(dbUser.getRealName())){
				String message = "用户校验失败，无权限修改密码，请联系轩轩-"+GlobalKeys.getConstantsByKeyForProperties("adminPhone", "15601605036");
				ResponseUtil.printFailError(response, Response.NOOBJECT + "", message);
				return;
			}
			registerUserService.updatePassword(dbUser);
			ResponseUtil.printNonEmptyJson(response, "data" , "修改成功,请牢记密码");
			
		} catch (Exception e) {
			
			ResponseUtil.printFail(response, 505, "系统升级");
		}
		
	}
	
    
}
