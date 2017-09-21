package com.weeds.common;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.common.collect.Lists;
import com.weeds.service.profile.AccountService;
import com.weeds.utils.ResponseUtil;
/**
 * oauth 过滤器
 * @author xuanxy
 *
 */
public class OauthFilter implements Filter{
	private AccountService accountService;
	private List<String> oauthUriList = Lists.newArrayList();
	public void init(FilterConfig filterConfig) throws ServletException {
		accountService = WebApplicationContextUtils.getWebApplicationContext(filterConfig.getServletContext()).getBean(AccountService.class);
		oauthUriList.add("/api/v1/profile");
		oauthUriList.add("/api/v1/message");
	}
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hsRequest = (HttpServletRequest)request;
		HttpServletResponse hsResponse = (HttpServletResponse)response;
		String uri = hsRequest.getRequestURI();
		//用户相关接口需要认证
		if(isOauthUri(uri)){
			if(uri.contains("upload.json")){
				chain.doFilter(request,response);
			}else{
				String access_token = hsRequest.getParameter("access_token");
				boolean isValid = accountService.isValid(access_token);
				if(!isValid){
					ResponseUtil.printFailError(hsResponse, Response.TOKENINVALID + "", "token失效");
				}else{
					chain.doFilter(request,response);
				}
			}
		}else{
			chain.doFilter(request,response);
		}
	}

	public void destroy() {
		
	}
	/**
	 * 需要验证
	 * @param uri
	 * @return
	 */
	public boolean isOauthUri(String uri){
		boolean isOauth = false;
		for (String oauthUri: oauthUriList) {
			if(uri.contains(oauthUri)){
				return true;
			}
		}
		return isOauth;
	}
}
