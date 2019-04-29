package com.zw.admin.server.dto;

import java.util.List;

import com.zw.admin.server.model.User;
import org.apache.commons.lang3.builder.ToStringExclude;

public class UserDto extends User {

	private static final long serialVersionUID = -184009306207076712L;

	private List<Long> roleIds;

	public List<Long> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<Long> roleIds) {
		this.roleIds = roleIds;
	}


}
