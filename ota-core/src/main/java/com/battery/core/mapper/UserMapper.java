package com.battery.core.mapper;

import org.apache.ibatis.annotations.Param;

import com.battery.common.mapper.BaseMapper;
import com.battery.core.models.User;

public interface UserMapper extends BaseMapper<User, Integer> {
	//通过公司id修改公司信息
	void updateByCompanyIdSelective(User user);
	
	/**
	 * 根据用户id更新创建名称
	 * @param userName
	 * @param userId
	 */
	public void updateCreateNameByUserId(@Param("createName") String createName,@Param("createId") Integer createId);
}