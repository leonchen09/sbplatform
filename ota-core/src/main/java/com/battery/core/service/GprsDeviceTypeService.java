package com.battery.core.service;
import com.battery.common.service.BaseService;
import com.battery.core.models.GprsDeviceType;

/**
 * @author zhangjia
 *
 */
public interface GprsDeviceTypeService extends BaseService<GprsDeviceType, Integer>{

	
	/**
	 * 根据gprsDeivceType获取从机数量
	 * @param gprsDeviceType
	 * @return
	 */
	int getSubDeviceCount(Integer gprsDeviceType); 
	
	/**
	 * 根据deviceTypeCode 获取GprsDeviceType
	 * @param deviceType
	 * @return
	 */
	GprsDeviceType selectDevieceType(Integer deviceType);
}
