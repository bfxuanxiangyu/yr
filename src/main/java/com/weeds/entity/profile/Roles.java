package com.weeds.entity.profile;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.common.collect.Lists;
import com.weeds.entity.IdEntity;

/**
 * 用户角色实体类
 * @author xuanxy
 *
 */
public class Roles extends IdEntity{
	
	private String name;     		//角色名称
	private String discription;     //角色描述
	private String roles;    		//功能
	private List<String> permissionList = Lists.newArrayList();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public List<String> getPermissionList() {
		return permissionList;
	}
	public void setPermissionList(List<String> permissionList) {
		this.permissionList = permissionList;
	}
	
	public String getPermissionNames() {
		List<String> permissionNameList = Lists.newArrayList();
		for (String permission : permissionList) {
			permissionNameList.add(Permission.parse(permission).displayName);
		}
		return StringUtils.join(permissionNameList, ",");
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
