package com.weeds.entity.pojo;

import java.util.Date;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat; 
/**
 * t_register_user 实体类
 * 由GenEntityMysql类自动生成
 * Wed Nov 23 14:36:06 CST 2016
 * @xuanxy
 */ 
@Entity
@Table(name="t_register_user")
public class RegisterUser {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String id;

	@Column(name="create_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date createTime;

	@Column(name="update_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date updateTime;

	/**
	* 手机号-登录账号
	*/ 
	@Column(name="phone")
	private String phone;

	/**
	* 真实姓名
	*/ 
	@Column(name="real_name")
	private String realName;

	/**
	* 登录密码 md5不可逆加密
	*/ 
	@Column(name="password")
	private String password;

	/**
	* 联系地址
	*/ 
	@Column(name="address")
	private String address;

	/**
	* 性别 0男  1女
	*/ 
	@Column(name="gender")
	private Integer gender;

	/**
	* 邮箱
	*/ 
	@Column(name="email")
	private String email;
	
	/**
	* 数据状态   0正常   1删除
	*/ 
	@Column(name="delete_flag")
	private Integer deleteFlag;


	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id=id;
	}

	public Date getCreateTime(){
		return createTime;
	}

	public void setCreateTime(Date createTime){
		this.createTime=createTime;
	}

	public Date getUpdateTime(){
		return updateTime;
	}

	public void setUpdateTime(Date updateTime){
		this.updateTime=updateTime;
	}

	public String getPhone(){
		return phone;
	}

	public void setPhone(String phone){
		this.phone=phone;
	}

	public String getRealName(){
		return realName;
	}

	public void setRealName(String realName){
		this.realName=realName;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password=password;
	}

	public String getAddress(){
		return address;
	}

	public void setAddress(String address){
		this.address=address;
	}

	public Integer getGender(){
		return gender;
	}

	public void setGender(Integer gender){
		this.gender=gender;
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email=email;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

}

