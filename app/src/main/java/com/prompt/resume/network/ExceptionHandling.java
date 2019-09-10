package com.prompt.resume.network;

import com.prompt.resume.common.dataModel.OauthTokenMo;
import com.prompt.resume.common.logic.UserLogic;
import com.prompt.resume.database.SharedInfo;
import com.prompt.resume.network.entity.HttpResult;
import com.prompt.resume.utils.ToastUtil;

/**
 * Author: TinhoXu
 * E-mail: xth@erongdu.com
 * Date: 2016/5/30 11:53
 * <p/>
 * Description: 异常处理
 */
@SuppressWarnings("unchecked")
public final class ExceptionHandling {
    public static boolean isToast = false;

    static void operate(final HttpResult result) {
        switch (result.getCode()) {
            case AppResultCode.TOKEN_TIMEOUT:
                OauthTokenMo tokenMo = SharedInfo.getInstance().getEntity(OauthTokenMo.class);
                if (null != tokenMo) {
//                    Call<HttpResult<OauthTokenMo>> call = HMClient.getService(UserService.class).refreshToken(tokenMo.getRefreshToken(),
//                            SPUtils.getInstance(BaseParams.SP_ClientInfo.SP_NAME).getString(BaseParams.SP_ClientInfo.CLIENT_ID, ""));
//                    call.enqueue(new RequestCallBack<HttpResult<OauthTokenMo>>() {
//                        @Override
//                        public void onSuccess(Call<HttpResult<OauthTokenMo>> call, Response<HttpResult<OauthTokenMo>> response) {
//                            SharedInfo.getInstance().saveEntity(response.body().getData());
//                        }
//                    });
                } else {
                    UserLogic.signOut();
//                    Routers.openForResult(ActivityManage.peek(), RouterUrl.getRouterUrl(String.format(RouterUrl.REGIS_INPUT_NUMBER, Constant.STATUS_1)), 0);
                }
                break;

            case AppResultCode.TOKEN_REFRESH_TIMEOUT:
                UserLogic.signOut();
//                Routers.openForResult(ActivityManage.peek(), RouterUrl.getRouterUrl(String.format(RouterUrl.REGIS_INPUT_NUMBER, Constant.STATUS_1)), 0);
                break;
            case AppResultCode.TOKEN_NOT_UNIQUE:
            case AppResultCode.TOKEN_NOT_EXIT:
                if (!isToast) {
                    isToast = true;
//                    DialogUtils.showDialog(ActivityManage.peek(), R.string.user_login_reset, R.string.user_login_two, new SweetAlertDialog.OnSweetClickListener() {
//                        @Override
//                        public void onClick(SweetAlertDialog sweetAlertDialog) {
//                            isToast = false;
//                            UserLogic.signOut();
//                            Routers.openForResult(ActivityManage.peek(), RouterUrl.getRouterUrl(String.format(RouterUrl.REGIS_INPUT_NUMBER, Constant.STATUS_1))
//                                    , 0);
//                            sweetAlertDialog.dismissWithAnimation();
//                        }
//                    }, new SweetAlertDialog.OnSweetClickListener() {
//                        @Override
//                        public void onClick(SweetAlertDialog sweetAlertDialog) {
//                            isToast = false;
//                            UserLogic.signOut();
//                            Routers.openForResult(ActivityManage.peek(), RouterUrl.getRouterUrl(String.format(RouterUrl.REGIS_INPUT_NUMBER, Constant
//                                            .STATUS_1))
//                                    , 0);
//                            sweetAlertDialog.dismissWithAnimation();
//                        }
//                    });
                }
                break;

            default:
                break;
        }
        if (result.getCode() != 410 && result.getCode() != 413 && result.getCode() != 412 && result.getCode() != 411) {
            ToastUtil.toast(result.getMsg());
        }
    }
}
