package com.weeds.common;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springside.modules.mapper.JsonMapper;


/**
 * @author xuanxy
 *
 * @param <T>
 */
public class Response<T> {
	// 请求成功
		public static final int SUCCESS = 1;
		/** 服务器内部异常 */
		public static final int SERVERUPLOAD = 10000;
		// 用户编码 10 结果码集合
		/*** 缺少参数 ***/
		public static final int TOKENINVALID = 1399;
		/*** 缺少参数 ***/
		public static final int PARAMETERS = 1400;
		/*** 密码错误 ***/
		public static final int PASSWORDFAIL = 1401;
		/*** 手机号不合法 ***/
		public static final int PHONEFAIL = 1402;
		/*** RSA解密失败 ***/
		public static final int RSAFAIL = 1403;
		/*** 手机号已注册 ***/
		public static final int PHONEALEDY = 1404;
		/*** 昵称已存在 ***/
		public static final int NICKALEDY = 1405;
		/*** 手机未注册 ***/
		public static final int PHONENO = 1406;
		/*** 邮箱不合法 ***/
		public static final int EMAILFIAL = 1407;
		/*** 邮箱为空 ***/
		public static final int EMAILNO = 1408;
		/*** 缺少对象，该字段是根据id、或者其他条件获取对象 ***/
		public static final int NOOBJECT = 1409;
		/*** 改商品已收藏 ***/
		public static final int ALREADYADD = 1410;
		/*** 密码不合法 ***/
		public static final int PASSWORDILLEGAL = 1411;
		/*** 服务器内部错误 ***/
		public static final int SERVERFAIL = 500;
		// 系统模块 起始编码 15
		/*** 根据最大版本号查询，没有版本控制信息 ***/
		public static final int VERSIONNOBIG = 1501;
		/*** 获取版本信息，没有版本控制信息 ***/
		public static final int NOVERSION = 1502;
		/*** 该版本无需升级 ***/
		public static final int NOUP = 1503;
		/*** 没有版本控制信息 ***/
		public static final int NOSERVICE = 1504;
		/** 验证码错误 */
		public static final int validateError = 1505;
		/** 失败 */
		public static final int failed = 1506;
		/** 图片上传失败 */
		public static final int PICUPLOADFAIL = 1507;
		private int status = SUCCESS;
		private String funName;
		private T data;

		public Response(int status) {
			this.status = status;
		}

		public Response(T data) {
			this.funName = "data";
			this.data = data;
		}

		public Response(String funName, T data) {
			this.funName = funName;
			this.data = data;
		}

		public Response(String funName, T data, int status) {
			this.funName = funName;
			this.data = data;
			this.status = status;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public T getData() {
			return data;
		}

		public String getFunName() {
			return funName;
		}

		public void setFunName(String funName) {
			this.funName = funName;
		}

		public String toJson() {
			StringBuffer sbf = new StringBuffer();
			JsonMapper jm = new JsonMapper();
			sbf.append("{\"result\":" + status + ",");
			sbf.append("\"" + funName + "\":" + jm.toJson(data) + "}");
			return sbf.toString().replace("null", "\"\"").replace("\"\"\"", "\"");
		}

		public void printJson(HttpServletResponse response) throws IOException {
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print(toJson());
			response.getWriter().close();
		}

		public String toNonEmptyJson() {
			StringBuffer sbf = new StringBuffer();
			sbf.append("{\"result\":" + status + ",");
			sbf.append("\"" + funName + "\":" + JsonMapper.nonEmptyMapper().toJson(data) + "}");
			return sbf.toString();
		}

		public void printNonEmptyJson(HttpServletResponse response) throws IOException {
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print(toNonEmptyJson());
			response.getWriter().close();
		}

}
