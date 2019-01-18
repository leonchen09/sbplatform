package com.battery.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.battery.common.mapper.BaseMapper;
import com.battery.core.models.Company;


public interface CompanyMapper extends BaseMapper<Company, Integer> {
	int selectListCountSelective(Company company);
	
	// add 通过用户返回用户对应所以的一级公司	 
	public List<Company> selectCompany1ByUser(@Param("loginId") String loginId); 
	// 二级公司
	public List<Company> selectCompany2ByUser(@Param("loginId") String loginId); 
	// 三级公司
	public List<Company> selectCompany3ByUser(@Param("loginId") String loginId);
	
	/**
	 * 根据用户id更新创建名称
	 * @param userName
	 * @param userId
	 */
	public void updateCreateNameByUserId(@Param("createName") String createName,@Param("createId") Integer createId);
	
}