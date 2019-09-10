package com.prompt.resume.model.user.viewModel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.prompt.resume.BR;

/**
 * author ：hm
 * date : 2019/9/3 18:11
 * package：com.prompt.resume.model.user.viewModel
 * description :
 */
public class RegisForgetPwdVM extends BaseObservable {

    private boolean phoneFocusable;
    private boolean codeFocusable;
    private boolean pwdFocusable;
    private boolean eyeOpen;

    private boolean confirmEnable;

    private String mobile = "";
    private String smsCode = "";
    private String newPwd = "";

    @Bindable
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
        checkInput();
        notifyPropertyChanged(BR.mobile);
    }

    private void checkInput() {
        if (getMobile().length() > 0 && getSmsCode().length() > 0 && getNewPwd().length() > 0) {
            setConfirmEnable(true);
        } else {
            setConfirmEnable(false);
        }
    }

    @Bindable
    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
        checkInput();
        notifyPropertyChanged(BR.smsCode);
    }

    @Bindable
    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
        checkInput();
        notifyPropertyChanged(BR.newPwd);
    }

    @Bindable
    public boolean isConfirmEnable() {
        return confirmEnable;
    }

    public void setConfirmEnable(boolean confirmEnable) {
        this.confirmEnable = confirmEnable;
        notifyPropertyChanged(BR.confirmEnable);
    }

    @Bindable
    public boolean isEyeOpen() {
        return eyeOpen;
    }

    public void setEyeOpen(boolean eyeOpen) {
        this.eyeOpen = eyeOpen;
        notifyPropertyChanged(BR.eyeOpen);
    }

    @Bindable
    public boolean isPhoneFocusable() {
        return phoneFocusable;
    }

    public void setPhoneFocusable(boolean phoneFocusable) {
        this.phoneFocusable = phoneFocusable;
        notifyPropertyChanged(BR.phoneFocusable);
    }

    @Bindable
    public boolean isCodeFocusable() {
        return codeFocusable;
    }

    public void setCodeFocusable(boolean codeFocusable) {
        this.codeFocusable = codeFocusable;
        notifyPropertyChanged(BR.codeFocusable);
    }

    @Bindable
    public boolean isPwdFocusable() {
        return pwdFocusable;
    }

    public void setPwdFocusable(boolean pwdFocusable) {
        this.pwdFocusable = pwdFocusable;
        notifyPropertyChanged(BR.pwdFocusable);
    }
}
