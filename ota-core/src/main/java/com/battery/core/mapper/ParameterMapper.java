package com.battery.core.mapper;

import java.util.List;
import java.util.Map;

import com.battery.common.mapper.BaseMapper;
import com.battery.core.models.Parameter;


public interface ParameterMapper extends BaseMapper<Parameter, String> {
	
	void updateByparameterCategory(Parameter parameter);
	
	/**
	 * 通过parameter_code和parameter_category，两个PK查询
	 * @param p   key = parameterCode, parameterCategory
	 */
	Parameter selectByPrimaryKeys(Map p);
	
	/**
	 * 通过category和code集合查询
	 * @param p   key = parameterCategory, codes 
	 */
	List<Parameter> selectByCategroyAndCodes(Map p);
}