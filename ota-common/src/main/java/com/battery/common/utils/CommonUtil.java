package com.battery.common.utils;

import org.apache.commons.lang3.StringUtils;

public class CommonUtil {

	/**
	 * 验证手机格式
	 */
	public static boolean isMobileNO(String mobiles) {
		String telRegex = "[1][3578]\\d{9}";
		if (StringUtils.isEmpty(mobiles))
			return false;
		else
			return mobiles.matches(telRegex);
	}
}
