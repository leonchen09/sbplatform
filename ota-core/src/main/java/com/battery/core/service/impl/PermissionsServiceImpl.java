package com.battery.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.battery.common.service.impl.BaseServiceImpl;
import com.battery.core.mapper.PermissionsMapper;
import com.battery.core.models.Permissions;
import com.battery.core.service.PermissionsService;

@Service
public class PermissionsServiceImpl extends BaseServiceImpl<Permissions, Integer> implements PermissionsService {

	@Autowired
	PermissionsMapper permissionsMapper;

	@Override
	public List<Permissions> selectListByUserId(Integer userId) {
		return permissionsMapper.selectListByUserId(userId);
	}

	@Override
	public List<Permissions> selectListByRoleId(Integer roleId) {
		return permissionsMapper.selectListByRoleId(roleId);
	}

}
