package com.prompt.resume.utils;

import android.content.Context;
import android.os.Environment;

import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.FileUtils;
import com.prompt.resume.common.BaseParams;

import java.io.File;

/**
 * Created by Administrator on 2018/7/3.
 */

public class ForceUpdateUtils {

    public static boolean deletePackageFile() {
        String downloadPath = ContextHolder.getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
        return FileUtils.deleteAllInDir(downloadPath);
    }

    public static boolean isExistPackageFile() {
        File file = new File(ContextHolder.getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + File.separator + BaseParams.NEW_APPNAME);
        return FileUtils.isFileExists(file);
    }

    public static void installPackage(Context context) {
        File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + File.separator + BaseParams.NEW_APPNAME);
        if (null == file || FileUtils.getFileLength(file) == -1
                || file.length() == 0l) {
            ToastUtil.toast("安装包错误");
            return;
        }
        AppUtils.installApp(file);
//        AppUtils.installApp(file, AppUtils.getAppPackageName() + ".fileProvider");
    }
}
