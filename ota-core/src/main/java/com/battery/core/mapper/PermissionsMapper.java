package com.battery.core.mapper;

import java.util.List;

import com.battery.common.mapper.BaseMapper;
import com.battery.core.models.Permissions;

public interface PermissionsMapper extends BaseMapper<Permissions, Integer> {
	List<Permissions> selectListByUserId(Integer userId);

	List<Permissions> selectListByRoleId(Integer roleId);
}