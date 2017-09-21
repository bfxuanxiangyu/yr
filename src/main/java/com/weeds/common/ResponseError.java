package com.weeds.common;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springside.modules.mapper.JsonMapper;

import com.weeds.common.Error;

/**
 * 错误信息响应
 * @author xuanxy
 */
public class ResponseError {
	//请求失败
		public static final int FAIL = 0;
		//token失效
		public static final int TOKEN_FAIL = -1;
		
		private int result = FAIL;
		private String error;
		
		private Error data;
		
		public ResponseError(int result) {
			this.result = result;
		}
		public ResponseError(String error) {
			this.error = error;
		}
		public ResponseError(String error, int result) {
			this.error = error;
			this.result = result;
		}
		
		public ResponseError(Error errorEntity,int result){
			this.data=errorEntity;
			this.result = result;
		}
		public int getResult() {
			return result;
		}
		public void setResult(int result) {
			this.result = result;
		}
		
		public String getError() {
			return error;
		}
		public void setError(String error) {
			this.error = error;
		}
		
		public String toJson(){
			return JsonMapper.nonEmptyMapper().toJson(this);
		}
		
		public void printJson(HttpServletResponse response) throws IOException{
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print(toJson());
			response.getWriter().close();
		}
		public Error getData() {
			return data;
		}
		public void setData(Error data) {
			this.data = data;
		}
}
