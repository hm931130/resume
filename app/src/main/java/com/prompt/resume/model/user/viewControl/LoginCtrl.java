package com.prompt.resume.model.user.viewControl;

import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;

import com.blankj.utilcode.util.EncodeUtils;
import com.blankj.utilcode.util.SPUtils;
import com.github.mzule.activityrouter.router.Routers;
import com.prompt.resume.R;
import com.prompt.resume.common.BaseParams;
import com.prompt.resume.common.Constant;
import com.prompt.resume.common.RouterUrl;
import com.prompt.resume.common.dataModel.OauthTokenMo;
import com.prompt.resume.common.logic.UserLogic;
import com.prompt.resume.databinding.ActLoginBinding;
import com.prompt.resume.model.user.dataModel.receive.LoginPwdRec;
import com.prompt.resume.model.user.viewModel.LoginVM;
import com.prompt.resume.network.HMClient;
import com.prompt.resume.network.RequestCallBack;
import com.prompt.resume.network.api.UserService;
import com.prompt.resume.network.encryption.MDUtil;
import com.prompt.resume.network.entity.HttpResult;
import com.prompt.resume.utils.NetworkUtil;
import com.prompt.resume.utils.RegularUtil;
import com.prompt.resume.utils.ToastUtil;
import com.prompt.resume.utils.Util;

import retrofit2.Call;
import retrofit2.Response;

/**
 * author ：hm
 * date : 2019/9/3 19:02
 * package：com.prompt.resume.model.user.viewControl
 * description :
 */
public class LoginCtrl implements View.OnFocusChangeListener {

    private LoginVM vm;
    private ActLoginBinding binding;

    public LoginVM getVm() {
        return vm;
    }

    public LoginCtrl(ActLoginBinding binding) {
        this.binding = binding;
        vm = new LoginVM();
        vm.setEyeVis(View.INVISIBLE);
        vm.setLoginEnable(false);
        binding.phoneEt.setOnFocusChangeListener(this);
        binding.pwdEt.setOnFocusChangeListener(this);

        binding.pwdEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().length() > 0) {
                    vm.setEyeVis(View.VISIBLE);
                } else {
                    vm.setEyeVis(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (!hasFocus) {
            vm.setPhoneFocusable(false);
            vm.setPwdFocusable(false);
            return;
        }

        if (v.getId() == R.id.phoneEt) {
            vm.setPhoneFocusable(true);
        } else if (v.getId() == R.id.pwdEt) {
            vm.setPwdFocusable(true);
        }

    }

    /**
     * 登录
     */
    public void loginClick(final View view) {
        if (!RegularUtil.isPhone(vm.getPhoneNum())) {
            ToastUtil.toast("请输入正确的手机号");
            return;
        }
        if (!RegularUtil.isPassword(vm.getPwdNum())) {
            ToastUtil.toast("密码格式错误(长度为6-12位数字、字母组合)");
            return;
        }

        String mobile = vm.getPhoneNum();
        String pwd = MDUtil.encode(MDUtil.TYPE.MD5, vm.getPwdNum()).toUpperCase();
        Call<HttpResult<LoginPwdRec>> call = HMClient.getService(UserService.class).loginPwd(mobile, pwd);
        NetworkUtil.showCutscenes(call);
        call.enqueue(new RequestCallBack<HttpResult<LoginPwdRec>>() {
            @Override
            public void onSuccess(Call<HttpResult<LoginPwdRec>> call, Response<HttpResult<LoginPwdRec>> response) {
                LoginPwdRec loginPwdRec = response.body().getData();
                OauthTokenMo tokenMo = new OauthTokenMo();
                tokenMo.setMobile(loginPwdRec.getMobile());
                tokenMo.setName(loginPwdRec.getName());
                tokenMo.setCompanyName(loginPwdRec.getCompanyName());
                tokenMo.setSessionId(loginPwdRec.getSessionId());
                tokenMo.setAuthStatus(loginPwdRec.getAuthStatus());
                tokenMo.setAccountType(loginPwdRec.getAccountType());
                tokenMo.setAccountState(loginPwdRec.getAccountState());
                UserLogic.login(Util.getActivity(view), tokenMo, Constant.STATUS_1);


            }
        });
    }

    /**
     * 验证码登录
     */
    public void invitaLogin(View view) {
        Util.getActivity(view).finish();
    }

    /**
     * 忘记密码
     */
    public void forgetPwd(View view) {
        Routers.open(Util.getActivity(view), RouterUrl.getRouterUrl(RouterUrl.REGIS_FORGET_PWD));
    }

    public void eyeClick(View view) {
        vm.setEyeOpen(!vm.isEyeOpen());
        //开眼
        if (vm.isEyeOpen()) {
            binding.pwdEt.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            binding.pwdEt.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }

        binding.pwdEt.setSelection(binding.pwdEt.getText().toString().trim().length());
    }

}
