package com.battery.core.models;

import java.util.Date;

public class Roles {
    /**
     * 
     */
    private Integer roleId;

    /**
     * 
     */
    private String roleName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 
     */
    private Integer createId;

    /**
     * 
     */
    private String createName;

    /**
     * 1管理后台，2支撑后台
     */
    private Integer roleSystem;

    /**
     * 
     * @return roleId 
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 
     * @param roleId 
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 
     * @return roleName 
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 
     * @param roleName 
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * 创建时间
     * @return createTime 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 
     * @return createId 
     */
    public Integer getCreateId() {
        return createId;
    }

    /**
     * 
     * @param createId 
     */
    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    /**
     * 
     * @return createName 
     */
    public String getCreateName() {
        return createName;
    }

    /**
     * 
     * @param createName 
     */
    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    /**
     * 1管理后台，2支撑后台
     * @return roleSystem 1管理后台，2支撑后台
     */
    public Integer getRoleSystem() {
        return roleSystem;
    }

    /**
     * 1管理后台，2支撑后台
     * @param roleSystem 1管理后台，2支撑后台
     */
    public void setRoleSystem(Integer roleSystem) {
        this.roleSystem = roleSystem;
    }
}