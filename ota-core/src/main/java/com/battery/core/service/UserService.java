package com.battery.core.service;

import com.battery.common.service.BaseService;
import com.battery.core.models.User;

public interface UserService extends BaseService<User, Integer> {
	
	 void updateByCompanyIdSelective(User user);
	
}