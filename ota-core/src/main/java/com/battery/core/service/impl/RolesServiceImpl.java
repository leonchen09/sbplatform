package com.battery.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.battery.common.service.impl.BaseServiceImpl;
import com.battery.core.mapper.RolesMapper;
import com.battery.core.models.Roles;
import com.battery.core.service.RolesService;

@Service
public class RolesServiceImpl extends BaseServiceImpl<Roles, Integer> implements RolesService {

	@Autowired
	RolesMapper rolesMapper;

	@Override
	public List<Roles> selectListByUserId(Integer userId) {
		return rolesMapper.selectListByUserId(userId);
	}

}
