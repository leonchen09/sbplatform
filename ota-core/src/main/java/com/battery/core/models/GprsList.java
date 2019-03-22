package com.battery.core.models;

import java.util.Date;

public class GprsList {
    /**
     * 
     */
    private Integer id;

    /**
     * 设备编号
     */
    private String gprsId;

    /**
     * 设备名称
     */
    private String name;

    /**
     * 最近一次接收数据时间
     */
    private Date rcvTime;

    /**
     * 
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 设备编号
     * @return gprsId 设备编号
     */
    public String getGprsId() {
        return gprsId;
    }

    /**
     * 设备编号
     * @param gprsId 设备编号
     */
    public void setGprsId(String gprsId) {
        this.gprsId = gprsId == null ? null : gprsId.trim();
    }

    /**
     * 设备名称
     * @return name 设备名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设备名称
     * @param name 设备名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 最近一次接收数据时间
     * @return rcvTime 最近一次接收数据时间
     */
    public Date getRcvTime() {
        return rcvTime;
    }

    /**
     * 最近一次接收数据时间
     * @param rcvTime 最近一次接收数据时间
     */
    public void setRcvTime(Date rcvTime) {
        this.rcvTime = rcvTime;
    }
}