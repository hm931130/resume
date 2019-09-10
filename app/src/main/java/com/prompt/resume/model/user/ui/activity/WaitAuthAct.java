package com.prompt.resume.model.user.ui.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.github.mzule.activityrouter.annotation.Router;
import com.prompt.resume.R;
import com.prompt.resume.common.RouterUrl;
import com.prompt.resume.common.ui.BaseActivity;
import com.prompt.resume.databinding.ActWaitAuthBinding;
import com.prompt.resume.model.user.viewControl.WaitAuthCtrl;

/**
 * author ：hm
 * date : 2019/9/3 20:09
 * package：com.prompt.resume.model.user.ui.activity
 * description :等待认证
 */
@Router(value = RouterUrl.WAIT_AUTH)
public class WaitAuthAct extends BaseActivity {
    private WaitAuthCtrl waitAuthCtrl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActWaitAuthBinding binding = DataBindingUtil.setContentView(this, R.layout.act_wait_auth);
        waitAuthCtrl = new WaitAuthCtrl(binding);
        binding.setViewCtrl(waitAuthCtrl);
    }
}
