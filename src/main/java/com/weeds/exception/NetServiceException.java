package com.weeds.exception;
/**
 * 网络服务异常
 * @author aizhimin
 *
 */
public class NetServiceException extends Exception {
	private static final long serialVersionUID = 1815019508115036756L;

	public NetServiceException(String message,Exception cause){
		super(message, cause);
	}
	
}
