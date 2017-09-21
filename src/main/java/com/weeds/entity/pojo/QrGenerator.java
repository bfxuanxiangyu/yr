package com.weeds.entity.pojo;

import java.util.Date;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat; 
/**
 * t_qr_generator 实体类
 * 由GenEntityMysql类自动生成
 * Wed Nov 30 16:17:59 CST 2016
 * @xuanxy
 */ 
@Entity
@Table(name="t_qr_generator")
public class QrGenerator {

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
	* 登录用户id
	*/ 
	@Column(name="user_id")
	private String userId;

	/**
	* 姓名
	*/ 
	@Column(name="name")
	private String name;

	/**
	* 手机
	*/ 
	@Column(name="tel_phone")
	private String telPhone;

	/**
	* 工作电话
	*/ 
	@Column(name="tel_work")
	private String telWork;

	/**
	* 家庭电话
	*/ 
	@Column(name="tel_home")
	private String telHome;

	/**
	* 备注
	*/ 
	@Column(name="remark")
	private String remark;

	/**
	* 邮箱
	*/ 
	@Column(name="email")
	private String email;

	/**
	* 公司
	*/ 
	@Column(name="company")
	private String company;

	/**
	* 职位
	*/ 
	@Column(name="position")
	private String position;

	/**
	* 个人主页
	*/ 
	@Column(name="url")
	private String url;

	/**
	* 家庭地址
	*/ 
	@Column(name="address_home")
	private String addressHome;

	/**
	* 工作地址
	*/ 
	@Column(name="address_work")
	private String addressWork;

	/**
	* 数据状态  0正常   1删除
	*/ 
	@Column(name="delete_flag")
	private Integer deleteFlag;

	/**
	* 二维码图片保存路径
	*/ 
	@Column(name="qr_code")
	private String qrCode;


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

	public String getUserId(){
		return userId;
	}

	public void setUserId(String userId){
		this.userId=userId;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name=name;
	}

	public String getTelPhone(){
		return telPhone;
	}

	public void setTelPhone(String telPhone){
		this.telPhone=telPhone;
	}

	public String getTelWork(){
		return telWork;
	}

	public void setTelWork(String telWork){
		this.telWork=telWork;
	}

	public String getTelHome(){
		return telHome;
	}

	public void setTelHome(String telHome){
		this.telHome=telHome;
	}

	public String getRemark(){
		return remark;
	}

	public void setRemark(String remark){
		this.remark=remark;
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email=email;
	}

	public String getCompany(){
		return company;
	}

	public void setCompany(String company){
		this.company=company;
	}

	public String getPosition(){
		return position;
	}

	public void setPosition(String position){
		this.position=position;
	}

	public String getUrl(){
		return url;
	}

	public void setUrl(String url){
		this.url=url;
	}

	public String getAddressHome(){
		return addressHome;
	}

	public void setAddressHome(String addressHome){
		this.addressHome=addressHome;
	}

	public String getAddressWork(){
		return addressWork;
	}

	public void setAddressWork(String addressWork){
		this.addressWork=addressWork;
	}

	public Integer getDeleteFlag(){
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag){
		this.deleteFlag=deleteFlag;
	}

	public String getQrCode(){
		return qrCode;
	}

	public void setQrCode(String qrCode){
		this.qrCode=qrCode;
	}

}

