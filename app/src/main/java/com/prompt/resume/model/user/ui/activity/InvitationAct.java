package com.prompt.resume.model.user.ui.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.github.mzule.activityrouter.annotation.Router;
import com.prompt.resume.R;
import com.prompt.resume.common.RouterUrl;
import com.prompt.resume.common.ui.BaseActivity;
import com.prompt.resume.databinding.ActInvitationAuthBinding;
import com.prompt.resume.model.user.viewControl.InvitationCtrl;

/**
 * author ：hm
 * date : 2019/9/3 19:35
 * package：com.prompt.resume.model.user.ui.activity
 * description :邀请码认证
 */
@Router(value = RouterUrl.INVITATION_AUTH)
public class InvitationAct extends BaseActivity {
    private InvitationCtrl ctrl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActInvitationAuthBinding binding = DataBindingUtil.setContentView(this, R.layout.act_invitation_auth);
        ctrl = new InvitationCtrl(binding);
        binding.setViewCtrl(ctrl);
    }
}
