package com.battery.core.service;

import java.util.List;

import com.battery.common.service.BaseService;
import com.battery.core.models.Roles;

public interface RolesService extends BaseService<Roles, Integer> {
	List<Roles> selectListByUserId(Integer userId);
}
