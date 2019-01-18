/*
 * @ClassName GprsDeviceType1Mapper
 * @Description 
 * @version 1.0
 * @Date 2018-05-18 11:52:03
 */
package com.battery.core.mapper;

import org.apache.ibatis.annotations.Param;

import com.battery.common.mapper.BaseMapper;
import com.battery.core.models.GprsDeviceType;

public interface GprsDeviceTypeMapper extends BaseMapper<GprsDeviceType, Integer>{
	
	GprsDeviceType selectDevieceTypeName(String deviceTypeName);
	
	GprsDeviceType selectDevieceType(Integer deviceType);
	
	GprsDeviceType selectVolLevelAanCellCount(String gprsId);
	
	/**
	 * 根据用户id更新创建名称
	 * @param userName
	 * @param userId
	 */
	public void updateCreateNameByUserId(@Param("createName") String createName,@Param("createId") Integer createId);
}