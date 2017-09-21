package com.weeds.entity.profile;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * Resource Base Access Control中的资源定义.
 * 
 */
public enum Permission {

	USER_VIEW("user:view", "查看用戶"), USER_EDIT("user:edit", "修改用户"),
	SYSTEM_VIEW("system:view", "系统级查看"), SYSTEM_EDIT("system:edit", "系统级操作");
	

	private static Map<String, Permission> valueMap = Maps.newHashMap();

	public String value;
	public String displayName;

	static {
		for (Permission permission : Permission.values()) {
			valueMap.put(permission.value, permission);
		}
	}

	Permission(String value, String displayName) {
		this.value = value;
		this.displayName = displayName;
	}

	public static Permission parse(String value) {
		return valueMap.get(value);
	}

	public String getValue() {
		return value;
	}

	public String getDisplayName() {
		return displayName;
	}
}
