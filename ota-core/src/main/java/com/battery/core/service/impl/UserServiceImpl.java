package com.battery.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.battery.common.service.impl.BaseServiceImpl;
import com.battery.core.mapper.CompanyMapper;
import com.battery.core.mapper.GprsDeviceTypeMapper;
import com.battery.core.mapper.RolesMapper;
import com.battery.core.mapper.UserMapper;
import com.battery.core.models.User;
import com.battery.core.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    RolesMapper rolesMapper;
    
    
	@Override
	public void updateByCompanyIdSelective(User user) {
		userMapper.updateByCompanyIdSelective(user);
	}
	
    
	public void updateByPrimaryKeySelective(User user) {
		super.updateByPrimaryKeySelective(user);
		//更新其他表中的createName字段
		updateTableCreateName(user);
	}
	
	private void updateTableCreateName(User user) {
		User oldUser = userMapper.selectByPrimaryKey(user.getUserId());
		if(oldUser != null && oldUser.getUserType() == 1 && oldUser.getUserName() != user.getUserName()) {
				//更新所有表中的createName
				String createName = user.getUserName();
				Integer createId = user.getUserId();
				rolesMapper.updateCreateNameByUserId(createName, createId);
				userMapper.updateCreateNameByUserId(createName, createId);
		}
	}
}