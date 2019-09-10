package com.prompt.resume.model.user.ui.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.github.mzule.activityrouter.annotation.Router;
import com.prompt.resume.R;
import com.prompt.resume.common.RouterUrl;
import com.prompt.resume.common.ui.BaseActivity;
import com.prompt.resume.databinding.ActCompanyAuthBinding;
import com.prompt.resume.databinding.ActInvitationAuthBinding;
import com.prompt.resume.model.user.viewControl.CompanyCtrl;
import com.prompt.resume.model.user.viewControl.InvitationCtrl;

/**
 * author ：hm
 * date : 2019/9/3 19:35
 * package：com.prompt.resume.model.user.ui.activity
 * description :企业认证
 */
@Router(value = RouterUrl.COMPANY_AUTH)
public class CompanyAct extends BaseActivity {
    private CompanyCtrl ctrl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActCompanyAuthBinding binding = DataBindingUtil.setContentView(this, R.layout.act_company_auth);
        ctrl = new CompanyCtrl(binding);
        binding.setViewCtrl(ctrl);
    }
}
