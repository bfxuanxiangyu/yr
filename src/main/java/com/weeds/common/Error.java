package com.weeds.common;



/**
 * 错误实体
 * @author xuanxy
 *
 */
public class Error {

	/**
	 * 错误编码
	 */
	private String errorCode;
	/**
	 * 错误内容
	 */
	private String errorMessage;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
