package com.prompt.resume.model.user.viewModel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.prompt.resume.BR;

/**
 * author ：hm
 * date : 2019/9/4 11:06
 * package：com.prompt.resume.model.user.viewModel
 * description :
 */
public class RegisCodeVM extends BaseObservable {
    private String mobile;

    private String code = "";


    private boolean nextStepEnable;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
        checkInput();
    }

    private void checkInput() {
        if (getCode().length() == 6){
            setNextStepEnable(true);
        }else{
            setNextStepEnable(false);
        }
    }

    @Bindable
    public boolean isNextStepEnable() {
        return nextStepEnable;
    }

    public void setNextStepEnable(boolean nextStepEnable) {
        this.nextStepEnable = nextStepEnable;
        notifyPropertyChanged(BR.nextStepEnable);
    }

    @Bindable
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
        notifyPropertyChanged(BR.mobile);
    }
}
