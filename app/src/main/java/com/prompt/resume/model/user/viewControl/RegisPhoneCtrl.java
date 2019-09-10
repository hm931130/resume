package com.prompt.resume.model.user.viewControl;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.github.mzule.activityrouter.router.Routers;
import com.prompt.resume.R;
import com.prompt.resume.common.RouterUrl;
import com.prompt.resume.databinding.ActRegisPhoneBinding;
import com.prompt.resume.model.user.viewModel.RegisPhoneVM;
import com.prompt.resume.network.HMClient;
import com.prompt.resume.network.RequestCallBack;
import com.prompt.resume.network.api.UserService;
import com.prompt.resume.network.entity.HttpResult;
import com.prompt.resume.utils.ContextHolder;
import com.prompt.resume.utils.NetworkUtil;
import com.prompt.resume.utils.RegularUtil;
import com.prompt.resume.utils.ToastUtil;
import com.prompt.resume.utils.Util;

import retrofit2.Call;
import retrofit2.Response;

/**
 * author ：hm
 * date : 2019/9/3 14:48
 * package：com.prompt.resume.model.user.viewControl
 * description :
 */
public class RegisPhoneCtrl implements TextWatcher {

    private RegisPhoneVM phoneVM;
    private ActRegisPhoneBinding binding;

    public RegisPhoneVM getPhoneVM() {
        return phoneVM;
    }

    public RegisPhoneCtrl(ActRegisPhoneBinding binding) {
        this.binding = binding;
        phoneVM = new RegisPhoneVM();
        binding.phoneEt.addTextChangedListener(this);

    }

    public void clearNum(View view) {
        phoneVM.setPhoneNum("");
    }

    public void nextStep(final View view) {
        if (!RegularUtil.isPhone(phoneVM.getPhoneNum())) {
            ToastUtil.toast("请输入正确的手机号");
            return;
        }

        final String mobile = phoneVM.getPhoneNum();
        Call<HttpResult> call = HMClient.getService(UserService.class).getSmsCode(mobile, "COMMON");
        NetworkUtil.showCutscenes(call);
        call.enqueue(new RequestCallBack<HttpResult>() {
            @Override
            public void onSuccess(Call<HttpResult> call, Response<HttpResult> response) {
                Routers.open(Util.getActivity(view), String.format(RouterUrl.getRouterUrl(RouterUrl.REGIS_CODE), mobile));
            }
        });

    }

    public void codeLogin(View view) {
        Routers.open(Util.getActivity(view), RouterUrl.getRouterUrl(RouterUrl.LOGIN_PWD));
    }


    /**
     * 手机号输入框
     */
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (s.toString().length() > 0) {
            phoneVM.setClearBtnVis(true);
        } else {
            phoneVM.setClearBtnVis(false);
        }
        if (s.toString().length() == 11) {
            phoneVM.setNextEnable(true);
        } else {
            phoneVM.setNextEnable(false);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
