package com.prompt.resume.model.user.viewControl;

import android.view.View;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.StringUtils;
import com.prompt.resume.R;
import com.prompt.resume.common.BaseParams;
import com.prompt.resume.databinding.ActInvitationAuthBinding;
import com.prompt.resume.model.user.dataModel.receive.LoginPwdRec;
import com.prompt.resume.model.user.viewModel.InvitationVM;
import com.prompt.resume.network.HMClient;
import com.prompt.resume.network.RequestCallBack;
import com.prompt.resume.network.api.UserService;
import com.prompt.resume.network.encryption.MDUtil;
import com.prompt.resume.network.entity.HttpResult;
import com.prompt.resume.utils.NetworkUtil;
import com.prompt.resume.utils.ToastUtil;

import retrofit2.Call;
import retrofit2.Response;

/**
 * author ：hm
 * date : 2019/9/3 19:56
 * package：com.prompt.resume.model.user.viewControl
 * description :
 */
public class InvitationCtrl implements View.OnFocusChangeListener {
    private ActInvitationAuthBinding binding;

    private InvitationVM vm;

    public InvitationVM getVm() {
        return vm;
    }

    public InvitationCtrl(ActInvitationAuthBinding binding) {
        binding = binding;
        vm = new InvitationVM();
        vm.setConfirmEnable(false);
        binding.nameEt.setOnFocusChangeListener(this);
        binding.companyEt.setOnFocusChangeListener(this);
        binding.emailEt.setOnFocusChangeListener(this);
        binding.invitaEt.setOnFocusChangeListener(this);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (!hasFocus) {
            vm.setCompanyFocusable(false);
            vm.setNameFocusable(false);
            vm.setEmailFocusable(false);
            vm.setInviteCodeFocusable(false);

            return;
        }
        switch (v.getId()) {
            case R.id.nameEt:
                vm.setNameFocusable(true);
                break;
            case R.id.companyEt:
                vm.setCompanyFocusable(true);
                break;
            case R.id.emailEt:
                vm.setEmailFocusable(true);
                break;
            case R.id.invitaEt:
                vm.setInviteCodeFocusable(true);
                break;
        }
    }

    public void confirmClick(View view) {
        if (StringUtils.isEmpty(vm.getName())) {
            ToastUtil.toast("请填写姓名");
            return;
        }
        if (StringUtils.isEmpty(vm.getCompanyName())) {
            ToastUtil.toast("请填写公司名称");
            return;
        }
        if (StringUtils.isEmpty(vm.getEmail())) {
            ToastUtil.toast("请填写联系邮箱");
            return;
        }
        if (StringUtils.isEmpty(vm.getInvitationCode())) {
            ToastUtil.toast("请填写邀请码");
            return;
        }

        String mobile = SPUtils.getInstance(BaseParams.SP_SmsCodeInfo.SP_NAME).getString(BaseParams.SP_SmsCodeInfo.MOBILE, "");
        String smsCode = SPUtils.getInstance(BaseParams.SP_SmsCodeInfo.SP_NAME).getString(BaseParams.SP_SmsCodeInfo.SMS_CODE, "");
        String password = MDUtil.encode(MDUtil.TYPE.MD5, "123456abc").toUpperCase();
        Call<HttpResult<LoginPwdRec>> call = HMClient.getService(UserService.class).authAccount(mobile, vm.getName(),
                vm.getCompanyName(), vm.getEmail(), smsCode, "ANDROID", vm.getInvitationCode(), password);
        NetworkUtil.showCutscenes(call);
        call.enqueue(new RequestCallBack<HttpResult<LoginPwdRec>>() {
            @Override
            public void onSuccess(Call<HttpResult<LoginPwdRec>> call, Response<HttpResult<LoginPwdRec>> response) {
                LoginPwdRec rec = response.body().getData();

            }
        });
    }
}
