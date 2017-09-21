package com.weeds.entity.profile;

import com.weeds.entity.IdEntity;


/**
 * 
 * @author Aizhimin
 *
 */
public class AccessToken extends IdEntity {
	
	public static final long EXPIRES_IN = 1000*3600*24*30L;//30天
	
	private Long user_id;//用户id
	private String access_token;//
	private Long expires_in;//过期时间
	private String refresh_token;//
	private Long created_time;//创建时间
	
	public AccessToken(){}
	
	public AccessToken(Long user_id, String access_token, Long expires_in,
			String refresh_token, Long created_at) {
		super();
		this.user_id = user_id;
		this.access_token = access_token;
		this.expires_in = expires_in;
		this.refresh_token = refresh_token;
		this.setCreated_time(created_at);
	}

	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public Long getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(Long expires_in) {
		this.expires_in = expires_in;
	}
	public String getRefresh_token() {
		return refresh_token;
	}
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public Long getCreated_time() {
		return created_time;
	}

	public void setCreated_time(Long created_time) {
		this.created_time = created_time;
	}
	
}
