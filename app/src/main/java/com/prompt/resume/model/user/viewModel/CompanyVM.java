package com.prompt.resume.model.user.viewModel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.prompt.resume.BR;

/**
 * author ：hm
 * date : 2019/9/3 19:53
 * package：com.prompt.resume.model.user.viewModel
 * description :
 */
public class CompanyVM extends BaseObservable {


    private boolean nameFocusable;
    private boolean companyFocusable;
    private boolean emailFocusable;

    @Bindable
    public boolean isNameFocusable() {
        return nameFocusable;
    }

    public void setNameFocusable(boolean nameFocusable) {
        this.nameFocusable = nameFocusable;
        notifyPropertyChanged(BR.nameFocusable);
    }

    @Bindable
    public boolean isCompanyFocusable() {
        return companyFocusable;
    }

    public void setCompanyFocusable(boolean companyFocusable) {
        this.companyFocusable = companyFocusable;
        notifyPropertyChanged(BR.companyFocusable);
    }

    @Bindable
    public boolean isEmailFocusable() {
        return emailFocusable;
    }

    public void setEmailFocusable(boolean emailFocusable) {
        this.emailFocusable = emailFocusable;
        notifyPropertyChanged(BR.emailFocusable);
    }

}
