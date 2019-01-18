package com.battery.core.util;

import javax.servlet.http.HttpServletRequest;

import com.battery.common.Constant;
import com.battery.common.utils.SpringContextHolder;
import com.battery.core.models.User;
import com.battery.core.service.UserService;

public class UserKit {

	/**
	 * 根据requst中的userId获取User对象
	 * @param request
	 * @return
	 */
	public static User getLoginUser(HttpServletRequest request) {
		Object _userId = request.getAttribute(Constant.REQUEST_USER_ID);
		if(_userId != null) {
			return SpringContextHolder.getBean(UserService.class).selectByPrimaryKey(Integer.valueOf(_userId.toString()));
		}
		return new User();
	}
	
	
	/**
	 * 判断用户类型是否能访问该系统
	 * @param userType 用户类型
	 * @param position 判断位置,通过该位置的状态是否为1判断
	 * @return
	 */
	public static boolean checkUserType(Integer userType,Integer position) {
		if(userType == null) {
			return false;
		}
		String binaryUserType =  Integer.toBinaryString(userType);
		Integer length = binaryUserType.length();
		if(length >= position + 1 && "1".equals(binaryUserType.substring(length-position-1, length - position))) {
			return true;
		}
		return false;
	}
}
