package com.weeds.entity.profile;

import com.weeds.entity.IdEntity;

/**
 * 用户与角色关联实体
 * @author xuanxy
 *
 */
public class AdminUserRoles extends IdEntity{

	private Long userId ;    //用户Id
	
	private Long roleId ;    //角色Id

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}


	
}
