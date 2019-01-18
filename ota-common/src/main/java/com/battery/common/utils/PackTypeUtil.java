package com.battery.common.utils;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PackTypeUtil {
	
	static Logger logger = LoggerFactory.getLogger(PackTypeUtil.class);
	
	/**
	 * 获取电池标准容量
	 * @param stationCap
	 * @return
	 */
	public static BigDecimal getStationStandardCap(String stationCap) {
		if(StringUtils.isNotEmpty(stationCap)) {
			stationCap = convertString(stationCap);
			try {
				return new BigDecimal(stationCap.substring(stationCap.indexOf("V") + 1, stationCap.length() - 2));
			} catch (Exception e) {
				logger.error("转换标准容量失败:"+stationCap,e);
			}
		}
		return null;
	}
	
	/**
	 * 获取电池标准容量
	 * @param stationCap
	 * @return
	 */
	public static Double getStationStandardCap(String stationCap,Double defualt) {
		BigDecimal r = getStationStandardCap(stationCap);
		if(r == null) {
			return defualt;
		}
		return r.doubleValue();
	}
	
	/**
	 * 获取电池标准电压
	 * @param stationCap
	 * @return
	 */
	public static Integer getStationStandardVol(String stationCap) {
		if(StringUtils.isNotEmpty(stationCap)) {
			stationCap = convertString(stationCap);
			try {
				return Integer.parseInt(stationCap.substring(0, stationCap.lastIndexOf("V")));
			} catch (Exception e) {
				logger.error("获取电池组标准电压失败:"+stationCap,e);
			}
		}
		return null;
	}
	
	/**
	 * 改变输入字符串的大小写
	 * @param stationCap
	 * @return
	 */
	private static String convertString(String stationCap) {
		return stationCap.toUpperCase();
	}
}
