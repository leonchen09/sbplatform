package com.battery.core.service.impl;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.battery.common.service.impl.BaseServiceImpl;
import com.battery.common.utils.ReflectUtil;
import com.battery.common.utils.StringUtils;
import com.battery.core.mapper.ParameterMapper;
import com.battery.core.models.Parameter;
import com.battery.core.service.ParameterService;
import com.battery.core.vo.AppConfigVo;


@Service
public class ParameterServiceImpl extends BaseServiceImpl<Parameter, String> implements ParameterService {
	@Autowired
	ParameterMapper parameterMapper;

	@Override
	public void updateParameterAll(AppConfigVo appConfig, String parameterCategory)
			throws IllegalArgumentException, IllegalAccessException {
		List<Field> fieldList = ReflectUtil.getAllFields(AppConfigVo.class);
		for (Field f : fieldList) {
			f.setAccessible(true);
			if (!StringUtils.isNull(f.get(appConfig))) {
				// 查询出是否有设备类型和parameterCode相互对应的，如果有就修改，没就新增，有就修改
				if (parameterCategory != null) {
					Parameter parameter = new Parameter();
					String parameterCode = (String) f.getName();
					parameter.setParameterCode(parameterCode);
					parameter.setParameterCategory(parameterCategory);
					List<Parameter> parameterList = parameterMapper.selectListSelective(parameter);
					if (parameterList.size() == 0) {
						parameter.setParameterValue((String) f.get(appConfig));
						insert(parameter);
					} else {
						parameter.setParameterValue((String) f.get(appConfig));
						parameterMapper.updateByparameterCategory(parameter);
					}
				} else {// 没有传递设备类型的情况新增和更新
					Parameter parameter2 = new Parameter();
					String parameterCode = (String) f.getName();
					parameter2.setParameterCode(parameterCode);
					List<Parameter> parameterList = parameterMapper.selectListSelective(parameter2);
					if (parameterList.size() == 0) {
						parameter2.setParameterValue((String) f.get(appConfig));
						parameter2.setParameterCategory("1");
						insertSelective(parameter2);
					} else {
						parameter2.setParameterValue((String) f.get(appConfig));
						parameterMapper.updateByPrimaryKeySelective(parameter2);
					}
				}


			}
		}
	}

	@Override
	public void parameterConsole(List<Parameter> list) {
		if (CollectionUtils.isNotEmpty(list)) {
			Parameter record = new Parameter();
			for (Parameter parameter : list) {
				record.setParameterCode(parameter.getParameterCode());
				record.setParameterCategory(parameter.getParameterCategory());
				List<Parameter> selectList = parameterMapper.selectListSelective(record);
				if (CollectionUtils.isEmpty(selectList)) {
					parameterMapper.insertSelective(parameter);
				}else if(parameter.getParameterValue() != null) {
					parameterMapper.updateByparameterCategory(parameter);
				}
			}
		}
	}

	@Override
	public Parameter selectByPrimaryKeys(String parameterCode, String parameterCategory) {
		Map<String, Object> param = new HashMap<>();
		param.put("parameterCode", parameterCode);
		param.put("parameterCategory", parameterCategory);
		return parameterMapper.selectByPrimaryKeys(param);
	}

	@Override
	public List<Parameter> selectByCategroyAndCodes(List<String> codes, String parameterCategory) {
		Map<String, Object> param = new HashMap<>();
		param.put("parameterCategory", parameterCategory);
		param.put("codes", codes);
		return parameterMapper.selectByCategroyAndCodes(param);
	}

}