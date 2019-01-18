package com.battery.core.service;

import java.util.List;

import com.battery.common.service.BaseService;
import com.battery.core.models.Parameter;
import com.battery.core.vo.AppConfigVo;



public interface ParameterService extends BaseService<Parameter, String> {

	void updateParameterAll(AppConfigVo appConfig,String parameterCategory) throws IllegalArgumentException, IllegalAccessException;
	
	/**
	 * 后期设置参数，都通过前台设置
	 */
	void parameterConsole(List<Parameter> list);
	
	Parameter selectByPrimaryKeys(String parameterCode, String parameterCategory);
	
	List<Parameter> selectByCategroyAndCodes(List<String> codes, String parameterCategory);
}