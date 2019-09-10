package com.prompt.resume.common.logic;

import android.app.Activity;
import android.text.TextUtils;

import com.blankj.utilcode.util.SPUtils;
import com.github.mzule.activityrouter.router.Routers;
import com.prompt.resume.common.BaseParams;
import com.prompt.resume.common.Constant;
import com.prompt.resume.common.RouterUrl;
import com.prompt.resume.common.dataModel.OauthTokenMo;
import com.prompt.resume.database.SharedInfo;
import com.prompt.resume.utils.ActivityManage;


/**
 * Author: TinhoXu
 * E-mail: xth@erongdu.com
 * Date: 2016/11/16 17:55
 * <p/>
 * Description:
 */
public class UserLogic {
    /**
     * 用户登录
     */
    public static void login(Activity activity, OauthTokenMo oauthTokenMo, String type) {
        /** 登录逻辑处理 */
        SharedInfo.getInstance().saveValue(Constant.IS_LAND, true);
        SharedInfo.getInstance().saveEntity(oauthTokenMo);
        if (Constant.STATUS_1.equals(type)) {
            Routers.open(activity, RouterUrl.getRouterUrl(String.format(RouterUrl.AppCommon_Main, Constant.NUMBER_1)));
        } else if (Constant.STATUS_2.equals(type)) {
            Routers.open(activity, RouterUrl.getRouterUrl(String.format(RouterUrl.AppCommon_Main, Constant.NUMBER_2)));
        } else if (Constant.STATUS_3.equals(type)) {
            Routers.open(activity, RouterUrl.getRouterUrl(String.format(RouterUrl.AppCommon_Main, Constant.NUMBER_3)));
        } else if (Constant.STATUS_4.equals(type)) {
            Routers.open(activity, RouterUrl.getRouterUrl(String.format(RouterUrl.AppCommon_Main, Constant.NUMBER_4)));
        }
        activity.setResult(Activity.RESULT_OK);
        ActivityManage.finishAll();
    }

    /**
     * 登出必须执行的操作
     */
    public static void signOut() {
        OauthTokenMo tokenMo = SharedInfo.getInstance().getEntity(OauthTokenMo.class);
        // 标记未登录
        SharedInfo.getInstance().remove(Constant.IS_LAND);
        // 删除保存的OauthToken信息
        SharedInfo.getInstance().remove(OauthTokenMo.class);
        //清除clientID
        SPUtils.getInstance(BaseParams.SP_ClientInfo.SP_NAME).clear();
    }

    /**
     * 用户被动登出
     */
    public static void signOutForcibly(Activity activity) {
        signOut();
        Routers.open(activity, RouterUrl.getRouterUrl(String.format(RouterUrl.AppCommon_Main, Constant.NUMBER_1)));
    }

    /**
     * 用户主动登出(到主界面)
     */
    public static void signOutToMain(final Activity activity) {
//        DialogUtils.showDialog(activity, R.string.user_login_out, new OnSweetClickListener() {
//            @Override
//            public void onClick(SweetAlertDialog dialog) {
//                dialog.dismiss();
//                signOutForcibly(activity);
//            }
//        });
    }

    /**
     * 用户主动登出(到登录界面)
     */
    public static void signOutToLogin(final Activity activity) {

//        DialogUtils.showDialog(activity, R.string.user_login_out, new SweetAlertDialog.OnSweetClickListener() {
//            @Override
//            public void onClick(SweetAlertDialog dialog) {
//                signOut();
//                Routers.openForResult(activity, RouterUrl.getRouterUrl(String.format(RouterUrl.REGIS_INPUT_NUMBER, Constant.STATUS_1)), 0);
//                activity.finish();
//            }
//        });
    }

    /**
     * 是否已经登录
     */
    public static boolean isLand() {
        boolean isLand = (boolean) SharedInfo.getInstance().getValue(Constant.IS_LAND, false);
        OauthTokenMo tokenRec = SharedInfo.getInstance().getEntity(OauthTokenMo.class);
        // 是否已经登录
        return isLand && null != tokenRec && !TextUtils.isEmpty(tokenRec.getSessionId());
    }
}
