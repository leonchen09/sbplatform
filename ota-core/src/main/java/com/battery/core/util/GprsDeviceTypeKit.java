package com.battery.core.util;

import com.battery.common.utils.SpringContextHolder;
import com.battery.core.models.GprsDeviceType;
import com.battery.core.service.GprsDeviceTypeService;

public class GprsDeviceTypeKit {

	/**
	 * 根据id获取GprsdeviceType对象
	 * 
	 * @param companyId
	 * @return
	 */
	public static GprsDeviceType getGprsDeviceTypeById(Integer gprsdeviceTypeId) {
		if (gprsdeviceTypeId != null) {
			return SpringContextHolder.getBean(GprsDeviceTypeService.class).selectByPrimaryKey(gprsdeviceTypeId);
		}
		return null;
	}

	/**
	 * 根据code获取GprsdeviceType对象
	 * 
	 * @param companyId
	 * @return
	 */
	public static GprsDeviceType getGprsDeviceTypeByCode(Integer gprsdeviceTypeCode) {
		if (gprsdeviceTypeCode != null) {
			return SpringContextHolder.getBean(GprsDeviceTypeService.class).selectDevieceType(gprsdeviceTypeCode);
		}
		return null;
	}
	
	/**
	 * 根据code获取GprsdeviceType -> gprsdevicetypeName
	 * 
	 * @param companyId
	 * @return
	 */
	public static String getGprsdeviceTypeNameByCode(Integer gprsdeviceTypeCode) {
		return getGprsdeviceTypeNameByObject(getGprsDeviceTypeByCode(gprsdeviceTypeCode));
	}
	
	/**
	 * 根据id获取GprsdeviceType -> gprsdevicetypeName
	 * 
	 * @param companyId
	 * @return
	 */
	public static String getGprsdeviceTypeNameById(Integer gprsdeviceTypeId) {
		return getGprsdeviceTypeNameByObject(getGprsDeviceTypeById(gprsdeviceTypeId));
	}

	/**
	 * 根据id获取GprsdeviceType -> gprsdevicetypeCode
	 * 
	 * @param companyId
	 * @return
	 */
	public static Integer getGprsdeviceTypeCodeById(Integer gprsdeviceTypeId) {
		GprsDeviceType gprsDeviceType = getGprsDeviceTypeById(gprsdeviceTypeId);
		if (gprsDeviceType != null) {
			return gprsDeviceType.getDeviceTypeCode();
		}
		return null;
	}
	
	/**
	 * 根据对象GprsDeviceType获取GprsdeviceTypeName
	 * @param gprsDeviceType
	 * @return
	 */
	private static String getGprsdeviceTypeNameByObject(GprsDeviceType gprsDeviceType) {
		if (gprsDeviceType != null) {
			return gprsDeviceType.getDeviceTypeName();
		}
		return null;
	}
}
