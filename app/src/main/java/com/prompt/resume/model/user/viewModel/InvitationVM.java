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
public class InvitationVM extends BaseObservable {


    private boolean nameFocusable;
    private boolean companyFocusable;
    private boolean emailFocusable;
    private boolean inviteCodeFocusable;
    private boolean confirmEnable;


    private String invitationCode = "";
    private String companyName = "";
    private String email = "";
    private String name = "";

    @Bindable
    public boolean isConfirmEnable() {
        return confirmEnable;
    }

    public void setConfirmEnable(boolean confirmEnable) {
        this.confirmEnable = confirmEnable;
        notifyPropertyChanged(BR.confirmEnable);
    }

    @Bindable
    public String getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode;
        checkInput();
        notifyPropertyChanged(BR.invitationCode);
    }

    private void checkInput() {
        if (getName().length() > 0
                && getCompanyName().length() > 0
                && getEmail().length() > 0
                && getInvitationCode().length() > 0) {
            setConfirmEnable(true);
        } else {
            setConfirmEnable(false);
        }

    }

    @Bindable
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
        checkInput();
        notifyPropertyChanged(BR.companyName);
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        checkInput();
        notifyPropertyChanged(BR.email);
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        checkInput();
        notifyPropertyChanged(BR.name);
    }

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

    @Bindable
    public boolean isInviteCodeFocusable() {
        return inviteCodeFocusable;
    }

    public void setInviteCodeFocusable(boolean inviteCodeFocusable) {
        this.inviteCodeFocusable = inviteCodeFocusable;
        notifyPropertyChanged(BR.inviteCodeFocusable);
    }
}
