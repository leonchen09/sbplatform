package com.battery.core.commons;

import java.util.HashMap;
import java.util.Map;

import com.battery.core.models.GprsDeviceType;

public class DeviceTypeHolder {

	/**
	 * 设备类型集合
	 */
	private final static Map<Integer, GprsDeviceType> gprsDeviceTypes = new HashMap<>();

	/**
	 * 根据gprsDeviceTypeCode 获取 GprsDeviceType
	 * 
	 * @param gprsDeviceType
	 * @return
	 */
	public static GprsDeviceType getGprsType(Integer gprsDeviceTypeCode) {
		if (gprsDeviceTypeCode != null) {
			return gprsDeviceTypes.get(gprsDeviceTypeCode);
		}
		return null;
	}
	
	/**
	 * 根据gprsDeviceTypeCode 获取 GprsDeviceType 名称
	 * 
	 * @param gprsDeviceType
	 * @return
	 */
	public static String getGprsTypeName(Integer gprsDeviceTypeCode) {
		GprsDeviceType gprsDeviceType = getGprsType(gprsDeviceTypeCode);
		if (gprsDeviceType != null) {
			return gprsDeviceType.getDeviceTypeName();
		}
		return null;
	}
	
	/**
	 * 更新gprsType
	 * @param gprsDeviceTypeCode
	 * @param gprsDeviceType
	 */
	public static void updateGprsType(Integer gprsDeviceTypeCode,GprsDeviceType gprsDeviceType) {
		gprsDeviceTypes.put(gprsDeviceTypeCode, gprsDeviceType);
	}
}
