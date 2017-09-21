package com.weeds.entity.pojo;

import java.util.Date;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat; 
/**
 * t_family 实体类
 * 由GenEntityMysql类自动生成
 * Wed Oct 12 13:29:37 CST 2016
 * @xuanxy
 */ 
@Entity
@Table(name="t_family")
public class Family {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String id;

	/**
	* 操作者
	*/ 
	@Column(name="create_by")
	private String createBy;

	@Column(name="create_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date createTime;

	/**
	* 修改者
	*/ 
	@Column(name="update_by")
	private String updateBy;

	@Column(name="update_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date updateTime;

	/**
	* 是否删除 0正常   1删除
	*/ 
	@Column(name="status")
	private Integer status;

	/**
	* 中文名称
	*/ 
	@Column(name="ch_name")
	private String chName;

	/**
	* 英文名称
	*/ 
	@Column(name="en_name")
	private String enName;
	
	/**
	 * 出生日期
	 */ 
	@Column(name="birthday")
	private String birthday;

	/**
	* 出生通知日期
	*/ 
	@Column(name="notice_birthday")
	private String noticeBirthday;

	/**
	* 现住地址
	*/ 
	@Column(name="address")
	private String address;

	/**
	 * 性别 0男 1女
	 */ 
	@Column(name="gender")
	private Integer gender;
	
	/**
	* 过生日   0过阴历   1过阳历
	*/ 
	@Column(name="gregorian")
	private Integer gregorian;

	/**
	* 邮寄地址
	*/ 
	@Column(name="send_address")
	private String sendAddress;

	/**
	* 邮编
	*/ 
	@Column(name="zip_code")
	private String zipCode;

	/**
	* qq
	*/ 
	@Column(name="qq")
	private String qq;

	/**
	* 信微
	*/ 
	@Column(name="wx")
	private String wx;

	/**
	* 邮箱
	*/ 
	@Column(name="email")
	private String email;

	/**
	* 手机
	*/ 
	@Column(name="mobile")
	private String mobile;

	/**
	* 家中关系
	*/ 
	@Column(name="relationship")
	private String relationship;
	
	/**
	 * 头像路径
	 */ 
	@Column(name="avatar")
	private String avatar;

	/**
	* 民族
	*/ 
	@Column(name="nation")
	private String nation;

	/**
	* 当前教育程度
	*/ 
	@Column(name="education")
	private String education;

	/**
	* 银行卡号
	*/ 
	@Column(name="bank_card")
	private String bankCard;

	/**
	* 开卡人姓名
	*/ 
	@Column(name="bank_name")
	private String bankName;

	/**
	* 开户行地址
	*/ 
	@Column(name="bank_account")
	private String bankAccount;

	/**
	* 开户人姓名
	*/ 
	@Column(name="bank_person")
	private String bankPerson;

	/**
	* 开户人电话
	*/ 
	@Column(name="bank_person_mobile")
	private String bankPersonMobile;

	/**
	* 个人描述
	*/ 
	@Column(name="content")
	private String content;

	/**
	* 备注
	*/ 
	@Column(name="remark")
	private String remark;


	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id=id;
	}

	public String getCreateBy(){
		return createBy;
	}

	public void setCreateBy(String createBy){
		this.createBy=createBy;
	}

	public Date getCreateTime(){
		return createTime;
	}

	public void setCreateTime(Date createTime){
		this.createTime=createTime;
	}

	public String getUpdateBy(){
		return updateBy;
	}

	public void setUpdateBy(String updateBy){
		this.updateBy=updateBy;
	}

	public Date getUpdateTime(){
		return updateTime;
	}

	public void setUpdateTime(Date updateTime){
		this.updateTime=updateTime;
	}

	public Integer getStatus(){
		return status;
	}

	public void setStatus(Integer status){
		this.status=status;
	}

	public String getChName(){
		return chName;
	}

	public void setChName(String chName){
		this.chName=chName;
	}

	public String getEnName(){
		return enName;
	}

	public void setEnName(String enName){
		this.enName=enName;
	}

	public String getBirthday(){
		return birthday;
	}

	public void setBirthday(String birthday){
		this.birthday=birthday;
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

	public String getSendAddress(){
		return sendAddress;
	}

	public void setSendAddress(String sendAddress){
		this.sendAddress=sendAddress;
	}

	public String getZipCode(){
		return zipCode;
	}

	public void setZipCode(String zipCode){
		this.zipCode=zipCode;
	}

	public String getQq(){
		return qq;
	}

	public void setQq(String qq){
		this.qq=qq;
	}

	public String getWx(){
		return wx;
	}

	public void setWx(String wx){
		this.wx=wx;
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email=email;
	}

	public String getMobile(){
		return mobile;
	}

	public void setMobile(String mobile){
		this.mobile=mobile;
	}

	public String getRelationship(){
		return relationship;
	}

	public void setRelationship(String relationship){
		this.relationship=relationship;
	}

	public String getAvatar(){
		return avatar;
	}

	public void setAvatar(String avatar){
		this.avatar=avatar;
	}

	public String getEducation(){
		return education;
	}

	public void setEducation(String education){
		this.education=education;
	}

	public String getBankCard(){
		return bankCard;
	}

	public void setBankCard(String bankCard){
		this.bankCard=bankCard;
	}

	public String getBankName(){
		return bankName;
	}

	public void setBankName(String bankName){
		this.bankName=bankName;
	}

	public String getBankAccount(){
		return bankAccount;
	}

	public void setBankAccount(String bankAccount){
		this.bankAccount=bankAccount;
	}

	public String getBankPerson(){
		return bankPerson;
	}

	public void setBankPerson(String bankPerson){
		this.bankPerson=bankPerson;
	}

	public String getBankPersonMobile(){
		return bankPersonMobile;
	}

	public void setBankPersonMobile(String bankPersonMobile){
		this.bankPersonMobile=bankPersonMobile;
	}

	public String getContent(){
		return content;
	}

	public void setContent(String content){
		this.content=content;
	}

	public String getRemark(){
		return remark;
	}

	public void setRemark(String remark){
		this.remark=remark;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public Integer getGregorian() {
		return gregorian;
	}

	public void setGregorian(Integer gregorian) {
		this.gregorian = gregorian;
	}

	public String getNoticeBirthday() {
		return noticeBirthday;
	}

	public void setNoticeBirthday(String noticeBirthday) {
		this.noticeBirthday = noticeBirthday;
	}

}

