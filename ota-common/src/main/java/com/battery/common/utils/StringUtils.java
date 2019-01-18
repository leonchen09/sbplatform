package com.battery.common.utils;

public class StringUtils {
	public static boolean isNull(Object obj) {
		if (obj == null || obj.toString().trim().equals("")) {
			return true;
		} else {
			return false;
		}
	}

	public static String getString(Object obj) {
		if (obj == null) {
			return null;
		} else {
			String result = obj.toString().trim();
			if (result.equals("")) {
				result = null;
			}
			return result;
		}
	}
	
	public static boolean isNotEmpty(String obj) {
		if(obj == null)
			return false;
		if(obj.trim().length() < 1)
			return false;
		return true;
	}
	
	public static String replace(String str) {
		          	
		str = str.replaceAll("\\\\", "");
        str = str.replaceAll("////", "");
        str = str.replaceAll(":", "");
        str = str.replaceAll("\\*", "");
        str = str.replaceAll(">", "");
        str = str.replaceAll("<", "");
        str = str.replaceAll("\\?", "");
        str = str.replaceAll("|", "");
		return str;
		
	}
}
