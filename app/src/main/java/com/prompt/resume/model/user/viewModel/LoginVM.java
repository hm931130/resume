package com.prompt.resume.model.user.viewModel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

import com.prompt.resume.BR;
import com.prompt.resume.utils.RegularUtil;
import com.prompt.resume.utils.ToastUtil;

/**
 * author ：hm
 * date : 2019/9/3 19:09
 * package：com.prompt.resume.model.user.viewModel
 * description :
 */
public class LoginVM extends BaseObservable {


    private boolean phoneFocusable;
    private boolean eyeOpen;
    private boolean pwdFocusable;
    private int eyeVis;
    private String phoneNum = "";
    private String pwdNum = "";
    private boolean loginEnable;

    @Bindable
    public boolean isLoginEnable() {
        return loginEnable;
    }

    public void setLoginEnable(boolean loginEnable) {
        this.loginEnable = loginEnable;
        notifyPropertyChanged(BR.loginEnable);
    }

    @Bindable
    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
        checkInput();
        notifyPropertyChanged(BR.phoneNum);
    }

    private void checkInput() {
        if (getPhoneNum().length() == 11 && getPwdNum().length() > 0) {
            setLoginEnable(true);
        } else {
            setLoginEnable(false);
        }
    }

    @Bindable
    public String getPwdNum() {
        return pwdNum;
    }

    public void setPwdNum(String pwdNum) {
        this.pwdNum = pwdNum;
        checkInput();
        notifyPropertyChanged(BR.pwdNum);
    }

    @Bindable
    public int getEyeVis() {
        return eyeVis;
    }

    public void setEyeVis(int eyeVis) {
        this.eyeVis = eyeVis;
        notifyPropertyChanged(BR.eyeVis);
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
    public boolean isPwdFocusable() {
        return pwdFocusable;
    }

    public void setPwdFocusable(boolean pwdFocusable) {
        this.pwdFocusable = pwdFocusable;
        notifyPropertyChanged(BR.pwdFocusable);
    }
}
