package com.user.parent.mybatis.response;

import com.user.parent.mybatis.bean.Member;

/**
 * member
 * 返回信息
 */
public class MemberResponse {
    private Long userId;
    private Long time;
    private String loginName;
    private String phoneNum;
    private String address;
    private String shopName;
    private String companyName;
    private String brandName;
    private String shopCode;
    private String passHash;
    private String roleIds;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getPassHash() {
        return passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public MemberResponse(Member member) {
        this.userId = member.getId();
        this.loginName = member.getLoginName();
        this.shopCode = member.getDepartmentCode();
        this.passHash = member.getPasswdHash();
        this.roleIds = member.getRoleIds();
    }

    public MemberResponse() {
    }
}
