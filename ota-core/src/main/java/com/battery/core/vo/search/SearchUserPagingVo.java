package com.battery.core.vo.search;

import java.util.Date;
import java.util.List;

import com.battery.common.vo.search.PageEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class was generated by Bill Generator.
 * This class corresponds to the database table users  
 *
 * @zdmgenerated 2017-13-19 07:13
 */
@ApiModel(value="User查询",description="User查询描述")
public class SearchUserPagingVo extends PageEntity {
    /**
     * This field corresponds to the database column users.user_id  
     */
    @ApiModelProperty(value="pk",required=false)
    private Integer userId;

    /**
     * This field corresponds to the database column users.user_name  用户名
     */
    @ApiModelProperty(value="用户名",example="用户名",required=false)
    private String userName;

    /**
     * This field corresponds to the database column users.login_id  账号
     */
    @ApiModelProperty(value="账号",example="账号",required=false)
    private String loginId;

    /**
     * This field corresponds to the database column users.user_password  用户密码
     */
    @ApiModelProperty(value="用户密码",example="用户密码",required=false)
    private String userPassword;

    /**
     * This field corresponds to the database column users.user_phone  电话
     */
    @ApiModelProperty(value="电话",example="电话",required=false)
    private String userPhone;

    /**
     * This field corresponds to the database column users.user_phone1  
     */
    @ApiModelProperty(value="userPhone1",example="userPhone1",required=false)
    private String userPhone1;

    /**
     * This field corresponds to the database column users.company_id  公司id
     */
    @ApiModelProperty(value="公司id",required=false)
    private Integer companyId;

    /**
     * This field corresponds to the database column users.company_name  公司姓名
     */
    @ApiModelProperty(value="公司姓名",example="公司姓名",required=false)
    private String companyName;

    /**
     * This field corresponds to the database column users.company_level  
     */
    @ApiModelProperty(value="companyLevel",required=false)
    private Integer companyLevel;

    /**
     * This field corresponds to the database column users.create_time  创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
     * This field corresponds to the database column users.role_id  模板id
     */
    @ApiModelProperty(value="模板id",required=false)
    private Integer roleId;
    /**
     * 模板名称
     */
    @ApiModelProperty(value="模板名称")
    private String roleName;
    
    /**
     * This field corresponds to the database column users.user_type  用户类型:1管理后台，2客户，3app
     */
    @ApiModelProperty(value="用户类型:1管理后台，2客户，3app",required=false)
    private List<Integer> userType;

    /**
     * This field corresponds to the database column users.create_id  
     */
    @ApiModelProperty(value="createId",required=false)
    private Integer createId;

    /**
     * This field corresponds to the database column users.create_name  
     */
    @ApiModelProperty(value="createName",example="createName",required=false)
    private String createName;

    /**
     * This field corresponds to the database column users.disable_flag  0启用，1禁用
     */
    @ApiModelProperty(value="0启用，1禁用",required=false)
    private Integer disableFlag;

    /**
     * This field corresponds to the database column users.remarks  备注
     */
    @ApiModelProperty(value="备注",example="备注",required=false)
    private String remarks;
    
    

    public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
     * This method returns the value of the database column users.user_id  
     * @return the value of users.user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method sets the value of the database column users.user_id  
     * @param userId the value for users.user_id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method returns the value of the database column users.user_name  用户名
     * @return the value of users.user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method sets the value of the database column users.user_name  用户名
     * @param userName the value for users.user_name
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method returns the value of the database column users.login_id  账号
     * @return the value of users.login_id
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * This method sets the value of the database column users.login_id  账号
     * @param loginId the value for users.login_id
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId == null ? null : loginId.trim();
    }

    /**
     * This method returns the value of the database column users.user_password  用户密码
     * @return the value of users.user_password
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * This method sets the value of the database column users.user_password  用户密码
     * @param userPassword the value for users.user_password
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    /**
     * This method returns the value of the database column users.user_phone  电话
     * @return the value of users.user_phone
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * This method sets the value of the database column users.user_phone  电话
     * @param userPhone the value for users.user_phone
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    /**
     * This method returns the value of the database column users.user_phone1  
     * @return the value of users.user_phone1
     */
    public String getUserPhone1() {
        return userPhone1;
    }

    /**
     * This method sets the value of the database column users.user_phone1  
     * @param userPhone1 the value for users.user_phone1
     */
    public void setUserPhone1(String userPhone1) {
        this.userPhone1 = userPhone1 == null ? null : userPhone1.trim();
    }

    /**
     * This method returns the value of the database column users.company_id  公司id
     * @return the value of users.company_id
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * This method sets the value of the database column users.company_id  公司id
     * @param companyId the value for users.company_id
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * This method returns the value of the database column users.company_name  公司姓名
     * @return the value of users.company_name
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * This method sets the value of the database column users.company_name  公司姓名
     * @param companyName the value for users.company_name
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    /**
     * This method returns the value of the database column users.company_level  
     * @return the value of users.company_level
     */
    public Integer getCompanyLevel() {
        return companyLevel;
    }

    /**
     * This method sets the value of the database column users.company_level  
     * @param companyLevel the value for users.company_level
     */
    public void setCompanyLevel(Integer companyLevel) {
        this.companyLevel = companyLevel;
    }

    /**
     * This method returns the value of the database column users.create_time  创建时间
     * @return the value of users.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column users.create_time  创建时间
     * @param createTime the value for users.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column users.role_id  模板id
     * @return the value of users.role_id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * This method sets the value of the database column users.role_id  模板id
     * @param roleId the value for users.role_id
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * This method returns the value of the database column users.user_type  用户类型:1管理后台，2客户，3app
     * @return the value of users.user_type
     */
    public List<Integer> getUserType() {
        return userType;
    }

    /**
     * This method sets the value of the database column users.user_type  用户类型:1管理后台，2客户，3app
     * @param userType the value for users.user_type
     */
    public void setUserType(List<Integer> userType) {
        this.userType = userType;
    }

    /**
     * This method returns the value of the database column users.create_id  
     * @return the value of users.create_id
     */
    public Integer getCreateId() {
        return createId;
    }

    /**
     * This method sets the value of the database column users.create_id  
     * @param createId the value for users.create_id
     */
    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    /**
     * This method returns the value of the database column users.create_name  
     * @return the value of users.create_name
     */
    public String getCreateName() {
        return createName;
    }

    /**
     * This method sets the value of the database column users.create_name  
     * @param createName the value for users.create_name
     */
    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    /**
     * This method returns the value of the database column users.disable_flag  0启用，1禁用
     * @return the value of users.disable_flag
     */
    public Integer getDisableFlag() {
        return disableFlag;
    }

    /**
     * This method sets the value of the database column users.disable_flag  0启用，1禁用
     * @param disableFlag the value for users.disable_flag
     */
    public void setDisableFlag(Integer disableFlag) {
        this.disableFlag = disableFlag;
    }

    /**
     * This method returns the value of the database column users.remarks  备注
     * @return the value of users.remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method sets the value of the database column users.remarks  备注
     * @param remarks the value for users.remarks
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}