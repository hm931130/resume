package com.prompt.resume.utils;

import android.content.Context;

import com.blankj.utilcode.util.PermissionUtils;


/**
 * Created by Administrator on 2019/4/24.
 */

public class PermissionRequestUtils {

    public static void requestPermissions(final Context context, final GrantedListener listener, String... permissions) {
        PermissionUtils.permission(permissions).callback(new PermissionUtils.SimpleCallback() {
            @Override
            public void onGranted() {
                if (listener != null) {
                    listener.isAllGranted();
                }
            }

            @Override
            public void onDenied() {
//                new SweetAlertDialog(context).setTitleText("权限申请")
//                        .setCancelText("取消")
//                        .setContentText("去设置")
//                        .setContentText("应用需要开启权限。")
//                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                            @Override
//                            public void onClick(SweetAlertDialog sweetAlertDialog) {
//                                sweetAlertDialog.dismissWithAnimation();
//                            }
//                        }).setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                    @Override
//                    public void onClick(SweetAlertDialog sweetAlertDialog) {
//                        sweetAlertDialog.dismissWithAnimation();
//                        PermissionUtils.launchAppDetailsSettings();
//                    }
//                }).show();
            }
        }).request();
    }

    public interface GrantedListener {
        void isAllGranted();
    }
}
