package com.prompt.resume.model.user.dataModel.receive;

/**
 * author ：hm
 * date : 2019/9/4 10:21
 * package：com.prompt.resume.model.user.dataModel.receive
 * description :
 */
public class LoginPwdRec {


    /**
     * mobile : 136****8853
     * name : Bangic
     * headImg :
     * inviteCode : 9jeves42
     * companyName : jxl
     * position : 开发
     * inviteUserName : 测试
     * sessionId : 6468C7EF4D1CD08E88E58F5D9FB74ACE
     * needSetPwd : false
     * authStatus : 1
     * accountState : 1
     */

    private String mobile;
    private String name;
    private String headImg;
    private String inviteCode;
    private String companyName;
    private String position;
    private String inviteUserName;
    private String sessionId;
    private boolean needSetPwd;
    private int authStatus;
    private int accountState;
    private int accountType;
    private String msgUserId;
    private String msgToken;

    public String getMsgUserId() {
        return msgUserId;
    }

    public void setMsgUserId(String msgUserId) {
        this.msgUserId = msgUserId;
    }

    public String getMsgToken() {
        return msgToken;
    }

    public void setMsgToken(String msgToken) {
        this.msgToken = msgToken;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

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

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getInviteUserName() {
        return inviteUserName;
    }

    public void setInviteUserName(String inviteUserName) {
        this.inviteUserName = inviteUserName;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public boolean isNeedSetPwd() {
        return needSetPwd;
    }

    public void setNeedSetPwd(boolean needSetPwd) {
        this.needSetPwd = needSetPwd;
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
}
