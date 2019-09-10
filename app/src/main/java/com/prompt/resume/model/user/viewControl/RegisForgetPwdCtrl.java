package com.prompt.resume.model.user.viewControl;

import android.os.CountDownTimer;
import android.support.v4.content.ContextCompat;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;

import com.prompt.resume.R;
import com.prompt.resume.databinding.ActRegisForgetPwdBinding;
import com.prompt.resume.model.user.viewModel.RegisForgetPwdVM;
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
 * date : 2019/9/3 17:04
 * package：com.prompt.resume.model.user.viewControl
 * description :忘记密码
 */
public class RegisForgetPwdCtrl implements View.OnFocusChangeListener {

    private RegisForgetPwdVM vm;
    private CountDownTimer countDownTimer = null;
    private ActRegisForgetPwdBinding binding;


    public RegisForgetPwdVM getVm() {
        return vm;
    }

    public RegisForgetPwdCtrl(final ActRegisForgetPwdBinding binding) {

        this.binding = binding;
        vm = new RegisForgetPwdVM();
        vm.setEyeOpen(false);
        countDownTimer = new CountDownTimer(10 * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                binding.timeTv.setEnabled(false);
                binding.timeTv.setText("重新获取(" + millisUntilFinished / 1000 + "s)");
                binding.timeTv.setTextColor(ContextCompat.getColor(Util.getActivity(binding.getRoot()), R.color.text_light));
            }

            @Override
            public void onFinish() {
                binding.timeTv.setEnabled(true);
                binding.timeTv.setText("获取验证码");
                binding.timeTv.setTextColor(ContextCompat.getColor(Util.getActivity(binding.getRoot()), R.color.colorAccent));
            }
        };

        binding.phoneEt.setOnFocusChangeListener(this);
        binding.codeEt.setOnFocusChangeListener(this);
        binding.pwdEt.setOnFocusChangeListener(this);

    }

    public void codeClick(View view) {
        if (!RegularUtil.isPhone(vm.getMobile())) {
            ToastUtil.toast("请输入正确的手机号码");
            return;
        }

        if (countDownTimer != null) {
            countDownTimer.start();
        }

        Call<HttpResult> call = HMClient.getService(UserService.class).getSmsCode(vm.getMobile(), "EDITPASSWORD");
        NetworkUtil.showCutscenes(call);
        call.enqueue(new RequestCallBack<HttpResult>() {
            @Override
            public void onSuccess(Call<HttpResult> call, Response<HttpResult> response) {

            }
        });
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

    public void confirmClick(final View view) {

        if (!RegularUtil.isPassword(vm.getNewPwd())) {
            ToastUtil.toast("密码格式错误(长度为6-12位数字、字母组合)");
            return;
        }

        if (!RegularUtil.isPhone(vm.getMobile())) {
            ToastUtil.toast("手机号码格式有误");
            return;
        }
        String newPwd = MDUtil.encode(MDUtil.TYPE.MD5, vm.getNewPwd()).toUpperCase();
        Call<HttpResult> call = HMClient.getService(UserService.class).updatePassword(vm.getMobile(), vm.getSmsCode(), newPwd);
        NetworkUtil.showCutscenes(call);
        call.enqueue(new RequestCallBack<HttpResult>() {
            @Override
            public void onSuccess(Call<HttpResult> call, Response<HttpResult> response) {
                ToastUtil.toast("密码修改成功,请重新登录");
                Util.getActivity(view).finish();
            }
        });

    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {

        if (!hasFocus) {
            vm.setPhoneFocusable(false);
            vm.setCodeFocusable(false);
            vm.setPwdFocusable(false);
            return;
        }

        if (v.getId() == R.id.phoneEt) {
            vm.setPhoneFocusable(true);
        } else if (v.getId() == R.id.codeEt) {
            vm.setCodeFocusable(true);
        } else if (v.getId() == R.id.pwdEt) {
            vm.setPwdFocusable(true);
        }

    }
}
