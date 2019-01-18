package com.battery.core.service;

import java.util.List;

import com.battery.common.service.BaseService;
import com.battery.core.models.Permissions;

public interface PermissionsService extends BaseService<Permissions, Integer> {
	List<Permissions> selectListByUserId(Integer userId);

	List<Permissions> selectListByRoleId(Integer roleId);
}
