package com.prompt.resume.common;

import android.Manifest;
import android.os.Environment;


import com.prompt.resume.BuildConfig;

import java.io.File;

/**
 * Created by Administrator on 2019/4/1.
 */

public class BaseParams {
    /**
     * 请求地址
     */
    public static final String URI = BuildConfig.API_URL;
    /**
     * ios传“1”，安卓传“2”
     */
    public static final String MOBILE_TYPE = "3";
    /**
     * 根路径
     */
    public static final String ROOT_PATH = getSDPath() + "/PO";
    /**
     * 照片文件文件保存路径
     */
    public static final String PHOTO_PATH = ROOT_PATH + "/photo";

    /**
     * 截屏保存
     */
    public static final String SCREEN_SHOT_PATH = PHOTO_PATH + "/jietu.png";
    /**
     * 错误日志
     */
    public static final String ERROR_PATH = ROOT_PATH + "/crash-log/";
    /**
     * SP文件名
     */
    public static final String SP_NAME = "basic_params";
    /**
     * 强制更新 App名称
     */
    public static final String NEW_APPNAME = "po.apk";

    /**
     * 第一次启动
     */
    public static final String LAUNCHER_FIRST = "launcher_first";

    //未登录时，跳转登录界面标识
    public static final int REQUEST_LOGIN = 0X11;
    //收藏页面请求登录
    public static final int REQUEST_CARDFRAG_LOGIN = 0X12;
    //购买会员成功请求
    public static final int REQUEST_VIP_SUCCESS = 0X13;
    //购买会员成功RESULT
    public static final int RESULT_VIP_SUCCESS = 0X14;
    //购买会员失败RESULT
    public static final int RESULT_VIP_FAILED = 0X15;

    //微信ID
    public static final String APP_ID = "wx15368159a3d28b22";
    /**
     * 联系人 短信 通话记录 保存路径 .txt
     */
    public static final String USERINFO_PATH = ROOT_PATH + "/userinfo";
    public static final String CONTACT_NAME = "contact.txt";
    public static final String SMS_NAME = "sms.txt";
    public static final String RECORD_NAME = "record.txt";

    public static final String CONTACTZIP_NAME = "contact.zip";
    public static final String SMSZIP_NAME = "sms.zip";
    public static final String RECORDZIP_NAME = "record.zip";

    /**
     * 照片-正面
     */
    public static String PHOTO_FRONT = "";
    /**
     * 照片-反面
     */
    public static String PHOTO_BACK = "";

    /**
     * 照片-活体识别
     */
    public static String PHOTO_ALIVE = "";
    /**
     * 照片-头像
     */
    public static String PHOTO_AVATAR = "";

    //贷超查看详情接口
    public static final String LOAN_MARKET_URL = "/api/v1/loanMarket/accessLog.htm?";

    //协议支付地址
    public static final String PROTOCOL_URL = "/api/v1/act/borrow/getProtocolPreview.htm?protocolName=deduct_huiyuan";
//    &userId=6&borrowId=3

    //存储卡权限集
    public static String[] EXTERNAL = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};
    //手机信息权限集
    public static String[] PHONE_STATE = new String[]{Manifest.permission.READ_PHONE_STATE};
    //借款权限集
    public static String[] LOAN_REQUEST = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.READ_CONTACTS,
            Manifest.permission.READ_SMS, Manifest.permission.READ_CALL_LOG, Manifest.permission.ACCESS_FINE_LOCATION};
    // 定位权限集  精确
    public static String[] LOCATION_REQUEST = new String[]{Manifest.permission.ACCESS_FINE_LOCATION};
    //app启动必备
    public static String[] APPLAUNCH_MUST = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.READ_PHONE_STATE};

    /**
     * 获取SD卡的根目录
     */
    public static String getSDPath() {
        File sdDir = null;
        // 判断sd卡是否存在
        boolean sdCardExist = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        if (sdCardExist) {
            // 获取跟目录
            sdDir = Environment.getExternalStorageDirectory();
        }
        if (sdDir == null) {
            return "";
        } else {
            return sdDir.toString();
        }
    }

    //clientId
    public static class SP_ClientInfo {
        public static final String SP_NAME = "clientSp";
        public static final String CLIENT_ID = "clientId";
    }

    //smsCode
    public static class SP_SmsCodeInfo {
        public static final String SP_NAME = "smsCodeSp";
        public static final String SMS_CODE = "smsCode";
        public static final String MOBILE = "mobile";
    }


}
