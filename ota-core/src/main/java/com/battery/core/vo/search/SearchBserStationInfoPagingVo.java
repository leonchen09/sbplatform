package com.battery.core.vo.search;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.battery.common.vo.search.PageEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class SearchBserStationInfoPagingVo extends PageEntity {

	/**
	 * @Fields id
	 */
	private Integer id;
	/**
	 * @Fields gprsId 基站gprs ID
	 */
	private String gprsId;
	/**
	 * @Fields gprsIdOut
	 */
	private String gprsIdOut;
	/**
	 * @Fields name 基站名称
	 */
	private String name;
	/**
	 * @Fields address 基站地址
	 */
	private String address;
	/**
	 * @Fields updateTime
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;
	/**
	 * @Fields province 省
	 */
	private String province;
	/**
	 * @Fields city 市
	 */
	private String city;
	/**
	 * @Fields district 区
	 */
	private String district;
	/**
	 * @Fields companyId1 一级公司id
	 */
	private Integer companyId1;
	/**
	 * @Fields companyId2 二级公司id
	 */
	private Integer companyId2;
	/**
	 * @Fields companyId3 三级公司id
	 */
	private Integer companyId3;
	/**
	 * @Fields lat 纬度 -90 to +90 (degrees)
	 */
	private BigDecimal lat;
	/**
	 * @Fields lng 经度 -180 to +180 (degrees)
	 */
	private BigDecimal lng;
	/**
	 * @Fields addressCoding 站址编码
	 */
	private String addressCoding;
	/**
	 * @Fields maintainanceId 运维ID
	 */
	private String maintainanceId;
	/**
	 * @Fields batteryType 电池类型 1，铅酸电池，2，锂电池
	 */
	private Integer batteryType;
	/**
	 * @Fields packType 电池组类型
	 */
	private String packType;
	/**
	 * @Fields roomType 机房类型
	 */
	private String roomType;
	/**
	 * @Fields volLevel 电压级别
	 */
	private Integer volLevel;
	/**
	 * @Fields okNum 正常数量
	 */
	private Integer okNum;
	/**
	 * @Fields poorNum 较差数量
	 */
	private Integer poorNum;
	/**
	 * @Fields errorNum 故障数量
	 */
	private Integer errorNum;
	/**
	 * @Fields loadCurrent 负载电流
	 */
	private BigDecimal loadCurrent;
	/**
	 * @Fields loadPower 负载功率，单位为w，默认2400w。
	 */
	private BigDecimal loadPower;
	/**
	 * @Fields packCapPred 电池组预测容量
	 */
	private BigDecimal packCapPred;
	/**
	 * @Fields status 电池组容量性: 0:正常,1:较差, 2: 故障
	 */
	private Integer status;
	/**
	 * @Fields durationStatus 电池组时长:1优2良3中4差
	 */
	private Integer durationStatus;
	/**
	 * @Fields duration 预测时长，单位分钟
	 */
	private BigDecimal duration;
	/**
	 * @Fields realDuration 剩余时长实时预测，单位分钟
	 */
	private BigDecimal realDuration;
	/**
	 * @Fields inspectStatus 安装、维护流程，电池组状态。99:未安装，
	 *         10:安装中，11:安装中等待确认状态，12:安装中后台确认未完成状态，
	 *         20:维护中，21:维护中等待确认状态，22:维护中后台确认未完成状态 23跟换单体等待确定状态 24 跟换单体后台确定未完成状态；30
	 *         已安装，31:在线，32:离线
	 */
	private Integer inspectStatus;
	/**
	 * @Fields cellCount 电池总数
	 */
	private Integer cellCount;

	private boolean isGprsIdNotNull = false;

	@ApiModelProperty(value = "设备在线状态,0离线,1在线", required = false)
	private Byte linkStatus;
	@ApiModelProperty(value = "设备类型编号", required = false)
	private Integer deviceTypeCode;

	@ApiModelProperty(value = "电池状态： 充电,放电,浮充", example = "电池状态： 充电,放电,浮充", required = false)
	private String state;
	// 总电压
	private BigDecimal genVol;
	// 总电流
	private BigDecimal genCur;
	@NotNull
	private Integer companyLevel;

	// 巡检人员姓名
	@ApiModelProperty(value = "巡检人员姓名", required = false)
	private String operateName;

	/*
	 * --10/16 add 安装维护状态
	 */
	@ApiModelProperty(value = "状态搜索 1是按装维护中,2是按装成功,3是失败", required = false)
	private Integer routingInspectionStatus;
	
	private String companyName3;
	
	public String getCompanyName3() {
		return companyName3;
	}

	public void setCompanyName3(String companyName3) {
		this.companyName3 = companyName3;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGprsId() {
		return gprsId;
	}

	public void setGprsId(String gprsId) {
		this.gprsId = gprsId;
	}

	public String getGprsIdOut() {
		return gprsIdOut;
	}

	public void setGprsIdOut(String gprsIdOut) {
		this.gprsIdOut = gprsIdOut;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Integer getCompanyId1() {
		return companyId1;
	}

	public void setCompanyId1(Integer companyId1) {
		this.companyId1 = companyId1;
	}

	public Integer getCompanyId2() {
		return companyId2;
	}

	public void setCompanyId2(Integer companyId2) {
		this.companyId2 = companyId2;
	}

	public Integer getCompanyId3() {
		return companyId3;
	}

	public void setCompanyId3(Integer companyId3) {
		this.companyId3 = companyId3;
	}

	public BigDecimal getLat() {
		return lat;
	}

	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}

	public BigDecimal getLng() {
		return lng;
	}

	public void setLng(BigDecimal lng) {
		this.lng = lng;
	}

	public String getAddressCoding() {
		return addressCoding;
	}

	public void setAddressCoding(String addressCoding) {
		this.addressCoding = addressCoding;
	}

	public String getMaintainanceId() {
		return maintainanceId;
	}

	public void setMaintainanceId(String maintainanceId) {
		this.maintainanceId = maintainanceId;
	}

	public Integer getBatteryType() {
		return batteryType;
	}

	public void setBatteryType(Integer batteryType) {
		this.batteryType = batteryType;
	}

	public String getPackType() {
		return packType;
	}

	public void setPackType(String packType) {
		this.packType = packType;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public Integer getVolLevel() {
		return volLevel;
	}

	public void setVolLevel(Integer volLevel) {
		this.volLevel = volLevel;
	}

	public Integer getOkNum() {
		return okNum;
	}

	public void setOkNum(Integer okNum) {
		this.okNum = okNum;
	}

	public Integer getPoorNum() {
		return poorNum;
	}

	public void setPoorNum(Integer poorNum) {
		this.poorNum = poorNum;
	}

	public Integer getErrorNum() {
		return errorNum;
	}

	public void setErrorNum(Integer errorNum) {
		this.errorNum = errorNum;
	}

	public BigDecimal getLoadCurrent() {
		return loadCurrent;
	}

	public void setLoadCurrent(BigDecimal loadCurrent) {
		this.loadCurrent = loadCurrent;
	}

	public BigDecimal getLoadPower() {
		return loadPower;
	}

	public void setLoadPower(BigDecimal loadPower) {
		this.loadPower = loadPower;
	}

	public BigDecimal getPackCapPred() {
		return packCapPred;
	}

	public void setPackCapPred(BigDecimal packCapPred) {
		this.packCapPred = packCapPred;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getDurationStatus() {
		return durationStatus;
	}

	public void setDurationStatus(Integer durationStatus) {
		this.durationStatus = durationStatus;
	}

	public BigDecimal getDuration() {
		return duration;
	}

	public void setDuration(BigDecimal duration) {
		this.duration = duration;
	}

	public BigDecimal getRealDuration() {
		return realDuration;
	}

	public void setRealDuration(BigDecimal realDuration) {
		this.realDuration = realDuration;
	}

	public Integer getInspectStatus() {
		return inspectStatus;
	}

	public void setInspectStatus(Integer inspectStatus) {
		this.inspectStatus = inspectStatus;
	}

	public Integer getCellCount() {
		return cellCount;
	}

	public void setCellCount(Integer cellCount) {
		this.cellCount = cellCount;
	}

	public boolean isGprsIdNotNull() {
		return isGprsIdNotNull;
	}

	public void setGprsIdNotNull(boolean isGprsIdNotNull) {
		this.isGprsIdNotNull = isGprsIdNotNull;
	}

	public Byte getLinkStatus() {
		return linkStatus;
	}

	public void setLinkStatus(Byte linkStatus) {
		this.linkStatus = linkStatus;
	}

	public Integer getDeviceTypeCode() {
		return deviceTypeCode;
	}

	public void setDeviceTypeCode(Integer deviceTypeCode) {
		this.deviceTypeCode = deviceTypeCode;
	}

	public BigDecimal getGenVol() {
		return genVol;
	}

	public void setGenVol(BigDecimal genVol) {
		this.genVol = genVol;
	}

	public BigDecimal getGenCur() {
		return genCur;
	}

	public void setGenCur(BigDecimal genCur) {
		this.genCur = genCur;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getCompanyLevel() {
		return companyLevel;
	}

	public void setCompanyLevel(Integer companyLevel) {
		this.companyLevel = companyLevel;
	}

	public String getOperateName() {
		return operateName;
	}

	public void setOperateName(String operateName) {
		this.operateName = operateName;
	}

	public Integer getRoutingInspectionStatus() {
		return routingInspectionStatus;
	}

	public void setRoutingInspectionStatus(Integer routingInspectionStatus) {
		this.routingInspectionStatus = routingInspectionStatus;
	}

}
