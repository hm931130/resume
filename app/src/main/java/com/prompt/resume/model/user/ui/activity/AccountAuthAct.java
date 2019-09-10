package com.prompt.resume.model.user.ui.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.github.mzule.activityrouter.annotation.Router;
import com.prompt.resume.R;
import com.prompt.resume.common.RouterUrl;
import com.prompt.resume.common.ui.BaseActivity;
import com.prompt.resume.databinding.ActAccountAuthBinding;
import com.prompt.resume.model.user.viewControl.AccountAuthCtrl;

/**
 * author ：hm
 * date : 2019/9/3 19:18
 * package：com.prompt.resume.model.user.ui.activity
 * description :账户认证
 */
@Router(value = RouterUrl.ACCOUNT_AUTH)
public class AccountAuthAct extends BaseActivity {

    private AccountAuthCtrl ctrl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActAccountAuthBinding binding = DataBindingUtil.setContentView(this, R.layout.act_account_auth);
        ctrl = new AccountAuthCtrl(binding);
        binding.setViewCtrl(ctrl);
    }
}
