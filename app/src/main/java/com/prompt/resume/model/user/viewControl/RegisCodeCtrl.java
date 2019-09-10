package com.prompt.resume.model.user.viewControl;

import android.os.CountDownTimer;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.SPUtils;
import com.github.mzule.activityrouter.annotation.Router;
import com.github.mzule.activityrouter.router.Routers;
import com.prompt.resume.R;
import com.prompt.resume.common.BaseParams;
import com.prompt.resume.common.Constant;
import com.prompt.resume.common.RouterUrl;
import com.prompt.resume.common.dataModel.OauthTokenMo;
import com.prompt.resume.common.logic.UserLogic;
import com.prompt.resume.databinding.ActRegisCodeBinding;
import com.prompt.resume.model.user.dataModel.receive.LoginPwdRec;
import com.prompt.resume.model.user.viewModel.RegisCodeVM;
import com.prompt.resume.network.HMClient;
import com.prompt.resume.network.RequestCallBack;
import com.prompt.resume.network.api.UserService;
import com.prompt.resume.network.entity.HttpResult;
import com.prompt.resume.utils.NetworkUtil;
import com.prompt.resume.utils.Util;

import retrofit2.Call;
import retrofit2.Response;

/**
 * author ：hm
 * date : 2019/9/3 14:48
 * package：com.prompt.resume.model.user.viewControl
 * description :
 */
public class RegisCodeCtrl implements TextWatcher, KeyboardUtils.OnSoftInputChangedListener {
    private ActRegisCodeBinding binding;
    private CountDownTimer countDownTimer = null;

    private String mobile;
    private RegisCodeVM codeVM;

    public RegisCodeVM getCodeVM() {
        return codeVM;
    }

    public RegisCodeCtrl(final ActRegisCodeBinding binding, String mobile) {
        this.binding = binding;
        this.mobile = mobile;
        codeVM = new RegisCodeVM();
        codeVM.setMobile(mobile);
        codeVM.setNextStepEnable(false);

        binding.codeEdit.addTextChangedListener(this);
        KeyboardUtils.registerSoftInputChangedListener(Util.getActivity(binding.getRoot()), this);

        binding.codeEdit.setFocusable(true);
        binding.codeEdit.setFocusableInTouchMode(true);
        binding.codeEdit.requestFocus();
        Util.getActivity(binding.getRoot()).getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);

        countDownTimer = new CountDownTimer(10 * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                binding.timeTv.setEnabled(false);
                binding.timeTv.setText("重新发送(" + millisUntilFinished / 1000 + ")");
                binding.timeTv.setTextColor(ContextCompat.getColor(Util.getActivity(binding.getRoot()), R.color.text_light));
            }

            @Override
            public void onFinish() {
                binding.timeTv.setEnabled(true);
                binding.timeTv.setText("重新发送");
                binding.timeTv.setTextColor(ContextCompat.getColor(Util.getActivity(binding.getRoot()), R.color.colorAccent));
            }
        }.start();
    }

    /**
     * @param s
     * @param start
     * @param count
     * @param after
     */
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        changeCodeTextBg();
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        String inputStr = s.toString().trim();
        codeVM.setCode(inputStr);
        int strCont = inputStr.length();

        switch (strCont) {
            case 0:
                binding.code1.setText("");
                binding.code2.setText("");
                binding.code3.setText("");
                binding.code4.setText("");
                binding.code5.setText("");
                binding.code6.setText("");
                break;
            case 1:
                binding.code1.setText(String.valueOf(inputStr.charAt(0)));
                binding.code2.setText("");
                binding.code3.setText("");
                binding.code4.setText("");
                binding.code5.setText("");
                binding.code6.setText("");
                break;
            case 2:
                binding.code1.setText(String.valueOf(inputStr.charAt(0)));
                binding.code2.setText(String.valueOf(inputStr.charAt(1)));
                binding.code3.setText("");
                binding.code4.setText("");
                binding.code5.setText("");
                binding.code6.setText("");
                break;
            case 3:
                binding.code1.setText(String.valueOf(inputStr.charAt(0)));
                binding.code2.setText(String.valueOf(inputStr.charAt(1)));
                binding.code3.setText(String.valueOf(inputStr.charAt(2)));
                binding.code4.setText("");
                binding.code5.setText("");
                binding.code6.setText("");
                break;
            case 4:
                binding.code1.setText(String.valueOf(inputStr.charAt(0)));
                binding.code2.setText(String.valueOf(inputStr.charAt(1)));
                binding.code3.setText(String.valueOf(inputStr.charAt(2)));
                binding.code4.setText(String.valueOf(inputStr.charAt(3)));
                binding.code5.setText("");
                binding.code6.setText("");
                break;
            case 5:
                binding.code1.setText(String.valueOf(inputStr.charAt(0)));
                binding.code2.setText(String.valueOf(inputStr.charAt(1)));
                binding.code3.setText(String.valueOf(inputStr.charAt(2)));
                binding.code4.setText(String.valueOf(inputStr.charAt(3)));
                binding.code5.setText(String.valueOf(inputStr.charAt(4)));
                binding.code6.setText("");
                break;
            case 6:
                binding.code1.setText(String.valueOf(inputStr.charAt(0)));
                binding.code2.setText(String.valueOf(inputStr.charAt(1)));
                binding.code3.setText(String.valueOf(inputStr.charAt(2)));
                binding.code4.setText(String.valueOf(inputStr.charAt(3)));
                binding.code5.setText(String.valueOf(inputStr.charAt(4)));
                binding.code6.setText(String.valueOf(inputStr.charAt(5)));
                KeyboardUtils.hideSoftInput(binding.getRoot());
                break;
        }

        changeCodeTextBg();
    }

    @Override
    public void afterTextChanged(Editable s) {
        changeCodeTextBg();
    }


    private void changeCodeTextBg() {
        int size = binding.codeEdit.getText().toString().length();
        switch (size) {
            case 0:
                binding.code1.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_hightlight));
                binding.code2.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_normal));
                binding.code3.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_normal));
                binding.code4.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_normal));
                binding.code5.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_normal));
                binding.code6.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_normal));
                break;
            case 1:
                binding.code1.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_normal));
                binding.code2.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_hightlight));
                binding.code3.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_normal));
                binding.code4.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_normal));
                binding.code5.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_normal));
                binding.code6.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_normal));
                break;
            case 2:
                binding.code1.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_normal));
                binding.code2.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_normal));
                binding.code3.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_hightlight));
                binding.code4.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_normal));
                binding.code5.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_normal));
                binding.code6.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_normal));
                break;
            case 3:
                binding.code1.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_normal));
                binding.code2.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_normal));
                binding.code3.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_normal));
                binding.code4.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_hightlight));
                binding.code5.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_normal));
                binding.code6.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_normal));
                break;
            case 4:
                binding.code1.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_normal));
                binding.code2.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_normal));
                binding.code3.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_normal));
                binding.code4.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_normal));
                binding.code5.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_hightlight));
                binding.code6.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_normal));
                break;
            case 5:
                binding.code1.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_normal));
                binding.code2.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_normal));
                binding.code3.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_normal));
                binding.code4.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_normal));
                binding.code5.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_normal));
                binding.code6.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_hightlight));
                break;
            case 6:
                binding.code1.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_normal));
                binding.code2.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_normal));
                binding.code3.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_normal));
                binding.code4.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_normal));
                binding.code5.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_normal));
                binding.code6.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_normal));
                break;
        }
    }

    @Override
    public void onSoftInputChanged(int height) {
        boolean flag = KeyboardUtils.isSoftInputVisible(Util.getActivity(binding.getRoot()));
        if (flag) {
            changeCodeTextBg();
        } else {
            binding.code1.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_normal));
            binding.code2.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_normal));
            binding.code3.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_normal));
            binding.code4.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_normal));
            binding.code5.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_normal));
            binding.code6.setBackground(ContextCompat.getDrawable(Util.getActivity(binding.getRoot()), R.drawable.drawable_edittext_normal));
        }
    }

    public void timeClick(View view) {
        if (countDownTimer != null) {
            countDownTimer.start();
        }

        final String mobile = getCodeVM().getMobile();
        Call<HttpResult> call = HMClient.getService(UserService.class).getSmsCode(mobile, "COMMON");
        NetworkUtil.showCutscenes(call);
        call.enqueue(new RequestCallBack<HttpResult>() {
            @Override
            public void onSuccess(Call<HttpResult> call, Response<HttpResult> response) {
            }
        });
    }

    public void nextStep(final View view) {


        Call<HttpResult<LoginPwdRec>> call = HMClient.getService(UserService.class).loginSmsCode(codeVM.getMobile(), codeVM.getCode());
        NetworkUtil.showCutscenes(call);
        call.enqueue(new RequestCallBack<HttpResult<LoginPwdRec>>() {
            @Override
            public void onSuccess(Call<HttpResult<LoginPwdRec>> call, Response<HttpResult<LoginPwdRec>> response) {
                LoginPwdRec loginPwdRec = response.body().getData();
                if (Constant.NUMBER_1 == loginPwdRec.getAuthStatus()) {//已认证通过  跳转首页
                    OauthTokenMo tokenMo = new OauthTokenMo();
                    tokenMo.setMobile(loginPwdRec.getMobile());
                    tokenMo.setName(loginPwdRec.getName());
                    tokenMo.setCompanyName(loginPwdRec.getCompanyName());
                    tokenMo.setSessionId(loginPwdRec.getSessionId());
                    tokenMo.setAuthStatus(loginPwdRec.getAuthStatus());
                    tokenMo.setAccountType(loginPwdRec.getAccountType());
                    tokenMo.setAccountState(loginPwdRec.getAccountState());
                    UserLogic.login(Util.getActivity(view), tokenMo, Constant.STATUS_1);
                } else { //去认证
                    SPUtils.getInstance(BaseParams.SP_SmsCodeInfo.SP_NAME).put(BaseParams.SP_SmsCodeInfo.SMS_CODE, codeVM.getCode());
                    SPUtils.getInstance(BaseParams.SP_SmsCodeInfo.SP_NAME).put(BaseParams.SP_SmsCodeInfo.MOBILE, codeVM.getMobile());
                    Routers.open(Util.getActivity(view), RouterUrl.getRouterUrl(RouterUrl.ACCOUNT_AUTH));

                }


            }
        });
    }

    public void onDestory() {
        KeyboardUtils.unregisterSoftInputChangedListener(Util.getActivity(binding.getRoot()));
        if (countDownTimer != null) {
            countDownTimer.cancel();
            countDownTimer = null;
        }
    }
}
