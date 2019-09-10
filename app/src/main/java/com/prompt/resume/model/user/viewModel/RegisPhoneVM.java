package com.prompt.resume.model.user.viewModel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.prompt.resume.BR;

/**
 * author ：hm
 * date : 2019/9/4 9:06
 * package：com.prompt.resume.model.user.viewModel
 * description :
 */
public class RegisPhoneVM extends BaseObservable {
    private String phoneNum;
    private boolean nextEnable;
    private boolean clearBtnVis;

    @Bindable
    public boolean isClearBtnVis() {
        return clearBtnVis;
    }

    public void setClearBtnVis(boolean clearBtnVis) {
        this.clearBtnVis = clearBtnVis;
        notifyPropertyChanged(BR.clearBtnVis);
    }

    @Bindable
    public boolean isNextEnable() {
        return nextEnable;
    }

    public void setNextEnable(boolean nextEnable) {
        this.nextEnable = nextEnable;
        notifyPropertyChanged(BR.nextEnable);
    }

    @Bindable
    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
        notifyPropertyChanged(BR.phoneNum);
    }
}
