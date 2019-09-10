package com.prompt.resume.model.user.ui.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.prompt.resume.R;
import com.prompt.resume.common.ui.BaseActivity;
import com.prompt.resume.databinding.ActRegisPhoneBinding;
import com.prompt.resume.model.user.viewControl.RegisPhoneCtrl;

/**
 * author ：hm
 * date : 2019/9/3 14:47
 * package：com.prompt.resume.model.user.ui.activity
 * description :注册输入手机号
 */
public class RegisPhoneAct extends BaseActivity {

    private RegisPhoneCtrl phoneCtrl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActRegisPhoneBinding binding = DataBindingUtil.setContentView(this, R.layout.act_regis_phone);
        phoneCtrl = new RegisPhoneCtrl(binding);
        binding.setViewCtrl(phoneCtrl);
    }
}
