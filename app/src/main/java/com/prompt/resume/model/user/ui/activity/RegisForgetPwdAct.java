package com.prompt.resume.model.user.ui.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.github.mzule.activityrouter.annotation.Router;
import com.prompt.resume.R;
import com.prompt.resume.common.RouterUrl;
import com.prompt.resume.common.ui.BaseActivity;
import com.prompt.resume.databinding.ActRegisForgetPwdBinding;
import com.prompt.resume.model.user.viewControl.RegisForgetPwdCtrl;

/**
 * author ：hm
 * date : 2019/9/3 17:03
 * package：com.prompt.resume.model.user.ui.activity
 * description :注册/忘记密码
 */
@Router(value = RouterUrl.REGIS_FORGET_PWD)
public class RegisForgetPwdAct extends BaseActivity {

    private RegisForgetPwdCtrl ctrl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActRegisForgetPwdBinding binding = DataBindingUtil.setContentView(this, R.layout.act_regis_forget_pwd);
        ctrl = new RegisForgetPwdCtrl(binding);
        binding.setViewCtrl(ctrl);
    }
}
