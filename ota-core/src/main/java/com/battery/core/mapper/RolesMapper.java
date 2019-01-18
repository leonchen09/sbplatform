package com.battery.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.battery.common.mapper.BaseMapper;
import com.battery.core.models.Roles;

public interface RolesMapper extends BaseMapper<Roles, Integer> {
	List<Roles> selectListByUserId(Integer userId);
	
	/**
	 * 根据用户id更新创建名称
	 * @param userName
	 * @param userId
	 */
	public void updateCreateNameByUserId(@Param("createName") String createName,@Param("createId") Integer createId);
}