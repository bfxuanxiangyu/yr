package com.weeds.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.weeds.common.Response;
import com.weeds.common.ResponseError;
/**
 * 数据输出工具类：json
 * @author xuanxy
 * 输出json格式数据
 */
public class ResponseUtil {
	/**
	 * 返回成功信息
	 * @param response
	 * @param data
	 * @throws IOException
	 */
	public static <T> void printJson(HttpServletResponse response,T data) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(new Response(data).toJson());
		response.getWriter().close();
	}
	
	/**
	 * 返回成功信息
	 * @param response
	 * @param data
	 * @throws IOException
	 */
	public static <T> void printJson(HttpServletResponse response,String funName,T data) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(new Response(funName,data).toJson());
		response.getWriter().close();
	}
	/**
	 * 返回成功信息 指定结果码
	 * @param response
	 * @param data  成功数据
	 * @param status  结果码
	 * @throws IOException
	 */
	public static <T> void printJson(HttpServletResponse response,String funName,T data,int status) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(new Response(funName,data,status).toJson());
		response.getWriter().close();
	}
	
	/**
	 * 返回成功信息  为null的不返回
	 * @param response
	 * @param data
	 * @throws IOException
	 */
	public static <T> void printNonEmptyJson(HttpServletResponse response,T data) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(new Response(data).toNonEmptyJson());
		response.getWriter().close();
	}
	
	/**
	 * 返回成功信息  为null的不返回
	 * @param response
	 * @param data
	 * @throws IOException
	 */
	public static <T> void printNonEmptyJson(HttpServletResponse response,String funName,T data) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(new Response(funName,data).toNonEmptyJson());
		response.getWriter().close();
	}
	/**
	 * 返回成功信息 指定结果码  为null的不返回
	 * @param response
	 * @param data  成功数据
	 * @param status  结果码
	 * @throws IOException
	 */
	public static <T> void printNonEmptyJson(HttpServletResponse response,String funName,T data,int status) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(new Response(funName,data,status).toNonEmptyJson());
		response.getWriter().close();
	}
	
	/**
	 * 输出字符串
	 * @param response
	 * @param jsonString
	 * @throws IOException
	 */
	public static void printString(HttpServletResponse response,String jsonString) throws IOException{
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().print(jsonString);
		response.getWriter().close();
	}
	
	/**
	 * 返回错误信息  指定错误码
	 * @param response
	 * @param error
	 * @param status 
	 * @throws IOException
	 */
	public static void printFail(HttpServletResponse response,int code,String error) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(new ResponseError(error,code).toJson());
		response.getWriter().close();
	}
	
	/**
	 * 返回错误信息 指定错误码
	 * 
	 * @param response
	 * @param error
	 * @param status
	 * @throws IOException
	 */
	public static void printFailError(HttpServletResponse response,
			String errorCode, String errorMessage){
		try {
			com.weeds.common.Error errorEntity = new com.weeds.common.Error();
			errorEntity.setErrorCode(errorCode);
			errorEntity.setErrorMessage(errorMessage);
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print(new ResponseError(errorEntity, 0).toJson());
			response.getWriter().close();
		} catch (Exception e) {
		}
	}
}
