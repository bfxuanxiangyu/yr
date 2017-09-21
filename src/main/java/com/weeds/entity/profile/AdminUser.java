package com.weeds.entity.profile;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.common.collect.Lists;
import com.weeds.entity.IdEntity;
/**
 * 
 * 
 * @author: 一橡  轩翔宇   
 * Date：2013-2-3 下午12:18:54  
 */
@Entity
@Table(name="t_admin_user")
public class AdminUser extends IdEntity implements Serializable{
	
	private Long   roleId; // 角色ID
	@Column(name="login_name")
	private String loginName;//登录名
	private String password;//登录密码
	private String plainPassword;//界面传来的明文密码
	private String salt;//密码加密密匙
	private String name;//用户名称
	private String gender;//用户性别
	private String permissions;//角色(查询后赋为权限)
	private String remark;//备注
	@Column(name="update_time")
	private Date updateTime;//更新时间
	@Column(name="created_time")
	private Date createdTime;//创建时间
	private String permissionName;//角色名称
	private List<String> permissionList = Lists.newArrayList();
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPermissions() {
		return permissions;
	}
	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Transient
	public String getPlainPassword() {
		return plainPassword;
	}
	public void setPlainPassword(String plainPassword) {
		this.plainPassword = plainPassword;
	}
	@Transient
	public List<String> getPermissionList() {
		return permissionList;
	}
	public void setPermissionList(List<String> permissionList) {
		this.permissionList = permissionList;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	@Transient
	public String getPermissionName() {
		return permissionName;
	}
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
}
