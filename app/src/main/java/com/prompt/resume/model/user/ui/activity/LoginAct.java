package com.prompt.resume.model.user.ui.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.github.mzule.activityrouter.annotation.Router;
import com.prompt.resume.R;
import com.prompt.resume.common.RouterUrl;
import com.prompt.resume.common.ui.BaseActivity;
import com.prompt.resume.databinding.ActLoginBinding;
import com.prompt.resume.model.user.viewControl.LoginCtrl;

/**
 * author ：hm
 * date : 2019/9/3 19:01
 * package：com.prompt.resume.model.user.ui.activity
 * description : 登陆
 */
@Router(value = RouterUrl.LOGIN_PWD)
public class LoginAct extends BaseActivity {
    private LoginCtrl loginCtrl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.act_login);
        loginCtrl = new LoginCtrl(binding);
        binding.setViewCtrl(loginCtrl);


    }
}
