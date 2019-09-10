package com.prompt.resume.utils;

import android.databinding.ObservableBoolean;

import com.blankj.utilcode.util.TimeUtils;
import com.prompt.resume.common.BaseParams;
import com.prompt.resume.common.Constant;

import java.io.File;
import java.util.List;

/**
 * Created by Administrator on 2018/8/9.
 */

public class GrabInfoStatusUtils {


    public static boolean isAlready(List<String> needsList) {
        boolean contactReady, smsLogReady, callLogReady;
        contactReady = smsLogReady = callLogReady = true;
        for (String tag : needsList) {
            switch (tag) {
                case Constant.CONTACTS:
                    if (!new File(BaseParams.USERINFO_PATH + File.separator + BaseParams.CONTACTZIP_NAME).exists()
                            || !TimeUtils.isToday(new File(BaseParams.USERINFO_PATH + File.separator + BaseParams.CONTACTZIP_NAME).lastModified())) {
                        contactReady = false;
                    }
                    break;
                case Constant.SMS_LOGS:
                    if (!new File(BaseParams.USERINFO_PATH + File.separator + BaseParams.SMSZIP_NAME).exists()
                            || !TimeUtils.isToday(new File(BaseParams.USERINFO_PATH + File.separator + BaseParams.SMSZIP_NAME).lastModified())) {
                        smsLogReady = false;
                    }
                    break;
                case Constant.CALL_LOGS:
                    if (!new File(BaseParams.USERINFO_PATH + File.separator + BaseParams.RECORDZIP_NAME).exists()
                            || !TimeUtils.isToday(new File(BaseParams.USERINFO_PATH + File.separator + BaseParams.RECORDZIP_NAME).lastModified())) {
                        callLogReady = false;
                    }
                    break;
            }
        }
        return contactReady && smsLogReady && callLogReady;
    }

    public static boolean isAlready(ObservableBoolean contactNeedsUp, ObservableBoolean smsNeedsUp, ObservableBoolean recordNeedsUp) {
        if (contactNeedsUp.get()
                && smsNeedsUp.get()
                && recordNeedsUp.get()) {
            //三个压缩包准备就绪
            if (new File(BaseParams.USERINFO_PATH + File.separator + BaseParams.CONTACTZIP_NAME).exists() && TimeUtils.isToday(new File(BaseParams.USERINFO_PATH + File.separator + BaseParams.CONTACTZIP_NAME).lastModified())
                    && new File(BaseParams.USERINFO_PATH + File.separator + BaseParams.SMSZIP_NAME).exists() && TimeUtils.isToday(new File(BaseParams.USERINFO_PATH + File.separator + BaseParams.SMSZIP_NAME).lastModified())
                    && new File(BaseParams.USERINFO_PATH + File.separator + BaseParams.RECORDZIP_NAME).exists() && TimeUtils.isToday(new File(BaseParams.USERINFO_PATH + File.separator + BaseParams.RECORDZIP_NAME).lastModified())) {

                return true;
            } else {
                return false;
            }
        }
        if (contactNeedsUp.get() && smsNeedsUp.get()) {
            if (new File(BaseParams.USERINFO_PATH + File.separator + BaseParams.CONTACTZIP_NAME).exists() && TimeUtils.isToday(new File(BaseParams.USERINFO_PATH + File.separator + BaseParams.CONTACTZIP_NAME).lastModified())
                    && new File(BaseParams.USERINFO_PATH + File.separator + BaseParams.SMSZIP_NAME).exists() && TimeUtils.isToday(new File(BaseParams.USERINFO_PATH + File.separator + BaseParams.SMSZIP_NAME).lastModified())
                    ) {
                return true;
            } else {
                return false;
            }
        }
        if (smsNeedsUp.get() && recordNeedsUp.get()) {
            if (new File(BaseParams.USERINFO_PATH + File.separator + BaseParams.SMSZIP_NAME).exists() && TimeUtils.isToday(new File(BaseParams.USERINFO_PATH + File.separator + BaseParams.SMSZIP_NAME).lastModified())
                    && new File(BaseParams.USERINFO_PATH + File.separator + BaseParams.RECORDZIP_NAME).exists() && TimeUtils.isToday(new File(BaseParams.USERINFO_PATH + File.separator + BaseParams.RECORDZIP_NAME).lastModified())
                    ) {
                return true;
            } else {
                return false;
            }
        }
        if (contactNeedsUp.get() && recordNeedsUp.get()) {
            if (new File(BaseParams.USERINFO_PATH + File.separator + BaseParams.CONTACTZIP_NAME).exists() && TimeUtils.isToday(new File(BaseParams.USERINFO_PATH + File.separator + BaseParams.CONTACTZIP_NAME).lastModified())
                    && new File(BaseParams.USERINFO_PATH + File.separator + BaseParams.RECORDZIP_NAME).exists() && TimeUtils.isToday(new File(BaseParams.USERINFO_PATH + File.separator + BaseParams.RECORDZIP_NAME).lastModified())
                    ) {
                return true;
            } else {
                return false;
            }
        }

        if (contactNeedsUp.get() && new File(BaseParams.USERINFO_PATH + File.separator + BaseParams.CONTACTZIP_NAME).exists() && TimeUtils.isToday(new File(BaseParams.USERINFO_PATH + File.separator + BaseParams.CONTACTZIP_NAME).lastModified())) {
            return true;
        }
        if (smsNeedsUp.get() && new File(BaseParams.USERINFO_PATH + File.separator + BaseParams.SMSZIP_NAME).exists() && TimeUtils.isToday(new File(BaseParams.USERINFO_PATH + File.separator + BaseParams.SMSZIP_NAME).lastModified())) {
            return true;
        }
        if (recordNeedsUp.get() && new File(BaseParams.USERINFO_PATH + File.separator + BaseParams.RECORDZIP_NAME).exists() && TimeUtils.isToday(new File(BaseParams.USERINFO_PATH + File.separator + BaseParams.RECORDZIP_NAME).lastModified())) {
            return true;
        }
        return true;
    }

}
