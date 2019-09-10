package com.prompt.resume.common.dataModel;

/**
 * Author: chenming
 * E-mail: cm1@erongdu.com
 * Date: 16/3/18 下午3:15
 * <p/>
 * Description: 登录信息
 */
public class OauthTokenMo {

    private String mobile;
    private String name;
    private String companyName;
    private String sessionId;
    private int authStatus;
    private int accountState;
    private int accountType;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }


    public int getAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(int authStatus) {
        this.authStatus = authStatus;
    }

    public int getAccountState() {
        return accountState;
    }

    public void setAccountState(int accountState) {
        this.accountState = accountState;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }
}
