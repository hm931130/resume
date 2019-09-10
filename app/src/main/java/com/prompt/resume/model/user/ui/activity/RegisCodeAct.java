package com.prompt.resume.model.user.ui.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.github.mzule.activityrouter.annotation.Router;
import com.prompt.resume.R;
import com.prompt.resume.common.BundleKeys;
import com.prompt.resume.common.RequestParams;
import com.prompt.resume.common.RouterUrl;
import com.prompt.resume.common.ui.BaseActivity;
import com.prompt.resume.databinding.ActRegisCodeBinding;
import com.prompt.resume.model.user.viewControl.RegisCodeCtrl;

/**
 * author ：hm
 * date : 2019/9/3 14:47
 * package：com.prompt.resume.model.user.ui.activity
 * description :注册输入手机号
 */
@Router(value = RouterUrl.REGIS_CODE, stringParams = {RequestParams.MOBILE})
public class RegisCodeAct extends BaseActivity {

    private RegisCodeCtrl codeCtrl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActRegisCodeBinding binding = DataBindingUtil.setContentView(this, R.layout.act_regis_code);
        codeCtrl = new RegisCodeCtrl(binding,getIntent().getStringExtra(RequestParams.MOBILE));
        binding.setViewCtrl(codeCtrl);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        codeCtrl.onDestory();
    }
}
