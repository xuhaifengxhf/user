package com.user.parent.mybatis.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *  member
 *   系统帐号表
 *
 */
public class Member {
    private Long  id;
    private String openid;
    private String unionid;
    private String email;
    private String loginName;
    private String  realName;
    private String  memberSkillName;
    private String  mobileNo;
    private Long orgId;
    private String departmentCode;
    private Long reporterId;
    private String roleIds;
    private String passwdHash;
    private Boolean enabled;
    private String locale;
    private String memberType;
    private String identifyType;
    private BigDecimal workerWages;
    private Integer isConcurrentPost;
    private String parttimeDate;
    private Integer failedLogins;
    private Date updateTime;
    private List<String> roleAuthorities;
    private String fNewPwd;
    private String sNewPwd;

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getfNewPwd() {
        return fNewPwd;
    }

    public void setfNewPwd(String fNewPwd) {
        this.fNewPwd = fNewPwd;
    }

    public String getsNewPwd() {
        return sNewPwd;
    }

    public void setsNewPwd(String sNewPwd) {
        this.sNewPwd = sNewPwd;
    }

    public List<String> getRoleAuthorities() {
        return roleAuthorities;
    }

    public void setRoleAuthorities(List<String> roleAuthorities) {
        this.roleAuthorities = roleAuthorities;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getFailedLogins() {
        return failedLogins;
    }

    public void setFailedLogins(Integer failedLogins) {
        this.failedLogins = failedLogins;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMemberSkillName() {
        return memberSkillName;
    }

    public void setMemberSkillName(String memberSkillName) {
        this.memberSkillName = memberSkillName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public Long getReporterId() {
        return reporterId;
    }

    public void setReporterId(Long reporterId) {
        this.reporterId = reporterId;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public String getPasswdHash() {
        return passwdHash;
    }

    public void setPasswdHash(String passwdHash) {
        this.passwdHash = passwdHash;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getIdentifyType() {
        return identifyType;
    }

    public void setIdentifyType(String identifyType) {
        this.identifyType = identifyType;
    }

    public BigDecimal getWorkerWages() {
        return workerWages;
    }

    public void setWorkerWages(BigDecimal workerWages) {
        this.workerWages = workerWages;
    }

    public Integer getIsConcurrentPost() {
        return isConcurrentPost;
    }

    public void setIsConcurrentPost(Integer isConcurrentPost) {
        this.isConcurrentPost = isConcurrentPost;
    }

    public String getParttimeDate() {
        return parttimeDate;
    }

    public void setParttimeDate(String parttimeDate) {
        this.parttimeDate = parttimeDate;
    }
}
