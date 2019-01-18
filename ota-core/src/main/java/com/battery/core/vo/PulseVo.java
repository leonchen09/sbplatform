package com.battery.core.vo;

import java.util.List;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

import io.swagger.annotations.ApiModelProperty;

public class PulseVo {
	
	/**
     * @Fields deviceTypeCode 设备类型编号 fk
            
     */
	@ApiModelProperty(value = "设备类型", required = true)
    private Integer deviceType;
	
	@ApiModelProperty(value = "快速采样间隔（区间1和3）， 0：5ms; 1: 10ms; 2: 20ms; 3: 40ms", required = false)
	private Integer fastSampleInterval;
	/**
	 * This field corresponds to the database column
	 * gprs_config_info.slow_sample_interval 慢速采样间隔（区间1和3）， 0：1s; 1: 5s; 2: 10s; 3:
	 * 20s
	 */
	@ApiModelProperty(value = "慢速采样间隔（区间1和3）， 0：1s; 1: 5s; 2: 10s; 3: 20s", required = false)
	private Integer slowSampleInterval;
	/**
	 * This field corresponds to the database column gprs_config_info.discharge_time
	 * 区间2时间， 0：1s; 1: 2s; 2: 3s; 3: 4s
	 */
	@ApiModelProperty(value = "区间2时间， 0：1s; 1: 2s; 2: 3s; 3: 4s", required = false)
	private Integer dischargeTime;
	/**
	 * This field corresponds to the database column
	 * gprs_config_info.slow_sample_time 慢采集采样时间（区间5）， 0：1s; 1: 2s; 2: 3s; 3: 4s
	 */
	@DecimalMax(value ="600",message= "区间5的持续时间填写超过范围")
	@DecimalMin(value ="0",message= "区间5的持续时间填写超过范围")
	@ApiModelProperty(value = "慢采集采样时间（区间5）， 0：1s; 1: 2s; 2: 3s; 3: 4s", required = false)
	private Integer slowSampleTime;
	
    //------add 10/26
    @ApiModelProperty(value = "过滤后的电压", required = false)
    private String filterVoltage;
    @ApiModelProperty(value = "过滤后的电流", required = false)
    private String filterCurrent;
    
    @ApiModelProperty(value = "三级公司id", required = false)
	private Integer companyId;
	
	private List<Integer> stationIdList;

	private Integer cellIndex;
    
	
	public Integer getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}

	public String getFilterVoltage() {
		return filterVoltage;
	}

	public void setFilterVoltage(String filterVoltage) {
		this.filterVoltage = filterVoltage;
	}

	public String getFilterCurrent() {
		return filterCurrent;
	}

	public void setFilterCurrent(String filterCurrent) {
		this.filterCurrent = filterCurrent;
	}



	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}



	public Integer getFastSampleInterval() {
		return fastSampleInterval;
	}

	public void setFastSampleInterval(Integer fastSampleInterval) {
		this.fastSampleInterval = fastSampleInterval;
	}

	public Integer getSlowSampleInterval() {
		return slowSampleInterval;
	}

	public void setSlowSampleInterval(Integer slowSampleInterval) {
		this.slowSampleInterval = slowSampleInterval;
	}

	public Integer getDischargeTime() {
		return dischargeTime;
	}

	public void setDischargeTime(Integer dischargeTime) {
		this.dischargeTime = dischargeTime;
	}

	public Integer getSlowSampleTime() {
		return slowSampleTime;
	}

	public void setSlowSampleTime(Integer slowSampleTime) {
		this.slowSampleTime = slowSampleTime;
	}

	public List<Integer> getStationIdList() {
		return stationIdList;
	}

	public void setStationIdList(List<Integer> stationIdList) {
		this.stationIdList = stationIdList;
	}

	public Integer getCellIndex() {
		return cellIndex;
	}

	public void setCellIndex(Integer cellIndex) {
		this.cellIndex = cellIndex;
	}

}
