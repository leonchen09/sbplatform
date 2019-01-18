/*
 * @ClassName GprsDeviceType1
 * @Description 
 * @version 1.0
 * @Date 2018-05-18 11:52:03
 */
package com.battery.core.models;

import java.math.BigDecimal;
import java.util.Date;

public class GprsDeviceType {
    /**
     * @Fields id 
     */
    private Integer id;
    /**
     * @Fields deviceTypeCode 设备类型编号
     */
    private Integer deviceTypeCode;
    /**
     * @Fields deviceTypeName 设备类型
     */
    private String deviceTypeName;
    /**
     * @Fields subVol 从机电压
     */
    private BigDecimal subVol;
    /**
     * @Fields volLevelCode 电压平台编码 FK
     */
    private Integer volLevel;
    /**
     * @Fields createId 创建人员id
     */
    private Integer createId;
    
    /**
     * @Fields createId 创建人员id
     */
    private String createName;
    
    /**
     * @Fields createTime 创建时间
     */
    private Date createTime;
    /**
     * @Fields subDeviceCount 从机数量
     */
    private Integer subDeviceCount;
    //电压平台名称
    private String volLevelName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeviceTypeCode() {
        return deviceTypeCode;
    }

    public void setDeviceTypeCode(Integer deviceTypeCode) {
        this.deviceTypeCode = deviceTypeCode;
    }

    public String getDeviceTypeName() {
        return deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName == null ? null : deviceTypeName.trim();
    }

    public BigDecimal getSubVol() {
        return subVol;
    }

    public void setSubVol(BigDecimal subVol) {
        this.subVol = subVol;
    }

    public Integer getVolLevel() {
        return volLevel;
    }

    public void setVolLevel(Integer volLevel) {
        this.volLevel = volLevel;
    }

    public Integer getCreateId() {
		return createId;
	}

	public void setCreateId(Integer createId) {
		this.createId = createId;
	}

	public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getSubDeviceCount() {
        return subDeviceCount;
    }

    public void setSubDeviceCount(Integer subDeviceCount) {
        this.subDeviceCount = subDeviceCount;
    }

	public String getVolLevelName() {
		return volLevelName;
	}

	public void setVolLevelName(String volLevelName) {
		this.volLevelName = volLevelName;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

}