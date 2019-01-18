package com.battery.core.models;

public class Permissions {
    /**
     * 
     */
    private Integer permissionId;

    /**
     * 权限类型：1菜单，2菜单目录，3按钮，4页面区域
     */
    private Integer permissionType;

    /**
     * 
     */
    private String permissionName;

    /**
     * 
     */
    private String permissionCode;

    /**
     * 
     */
    private Integer parentId;

    /**
     * 
     */
    private String url;

    /**
     * 数字越大排序越靠前
     */
    private Integer permissionSort;

    /**
     * 1管理后台，2支撑后台
     */
    private Integer permissionSystem;

    /**
     * 
     * @return permissionId 
     */
    public Integer getPermissionId() {
        return permissionId;
    }

    /**
     * 
     * @param permissionId 
     */
    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    /**
     * 权限类型：1菜单，2菜单目录，3按钮，4页面区域
     * @return permissionType 权限类型：1菜单，2菜单目录，3按钮，4页面区域
     */
    public Integer getPermissionType() {
        return permissionType;
    }

    /**
     * 权限类型：1菜单，2菜单目录，3按钮，4页面区域
     * @param permissionType 权限类型：1菜单，2菜单目录，3按钮，4页面区域
     */
    public void setPermissionType(Integer permissionType) {
        this.permissionType = permissionType;
    }

    /**
     * 
     * @return permissionName 
     */
    public String getPermissionName() {
        return permissionName;
    }

    /**
     * 
     * @param permissionName 
     */
    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    /**
     * 
     * @return permissionCode 
     */
    public String getPermissionCode() {
        return permissionCode;
    }

    /**
     * 
     * @param permissionCode 
     */
    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode == null ? null : permissionCode.trim();
    }

    /**
     * 
     * @return parentId 
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 
     * @param parentId 
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 
     * @return url 
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url 
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 数字越大排序越靠前
     * @return permissionSort 数字越大排序越靠前
     */
    public Integer getPermissionSort() {
        return permissionSort;
    }

    /**
     * 数字越大排序越靠前
     * @param permissionSort 数字越大排序越靠前
     */
    public void setPermissionSort(Integer permissionSort) {
        this.permissionSort = permissionSort;
    }

    /**
     * 1管理后台，2支撑后台
     * @return permissionSystem 1管理后台，2支撑后台
     */
    public Integer getPermissionSystem() {
        return permissionSystem;
    }

    /**
     * 1管理后台，2支撑后台
     * @param permissionSystem 1管理后台，2支撑后台
     */
    public void setPermissionSystem(Integer permissionSystem) {
        this.permissionSystem = permissionSystem;
    }
}