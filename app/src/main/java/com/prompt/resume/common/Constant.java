package com.prompt.resume.common;

/**
 * Created by Administrator on 2019/4/1.
 */

public class Constant {

    /**
     * number
     */
    public static final int NUMBER__2 = -2;
    public static final int NUMBER__1 = -1;
    public static final int NUMBER_0 = 0;
    public static final int NUMBER_1 = 1;
    public static final int NUMBER_2 = 2;
    public static final int NUMBER_3 = 3;
    public static final int NUMBER_4 = 4;
    public static final int NUMBER_5 = 5;
    public static final int NUMBER_6 = 6;
    public static final int NUMBER_7 = 7;
    public static final int NUMBER_8 = 8;
    public static final int NUMBER_9 = 9;
    public static final int NUMBER_10 = 10;
    public static final int NUMBER_20 = 20;
    public static final int NUMBER_30 = 30;
    /**
     * status
     */
    public static final String STATUS__2 = "-2";
    public static final String STATUS__1 = "-1";
    public static final String STATUS_0 = "0";
    public static final String STATUS_1 = "1";
    public static final String STATUS_2 = "2";
    public static final String STATUS_3 = "3";
    public static final String STATUS_4 = "4";
    public static final String STATUS_5 = "5";
    public static final String STATUS_6 = "6";
    public static final String STATUS_7 = "7";
    public static final String STATUS_8 = "8";
    public static final String STATUS_9 = "9";
    public static final String STATUS_10 = "10";
    public static final String STATUS_20 = "20";
    public static final String STATUS_21 = "21";
    public static final String STATUS_22 = "22";
    public static final String STATUS_23 = "23";
    public static final String STATUS_24 = "24";
    public static final String STATUS_25 = "25";
    public static final String STATUS_26 = "26";
    public static final String STATUS_27 = "27";
    public static final String STATUS_28 = "28";
    public static final String STATUS_29 = "29";
    public static final String STATUS_30 = "30";
    public static final String STATUS_31 = "31";
    public static final String STATUS_40 = "40";
    public static final String STATUS_50 = "50";
    public static final String STATUS_60 = "60";
    public static final String STATUS_70 = "70";
    public static final String STATUS_80 = "80";
    public static final String STATUS_90 = "90";
    public static final String STATUS_91 = "91";
    public static final String STATUS_92 = "92";
    public static final String STATUS_93 = "93";
    public static final String STATUS_291 = "291";
    public static final String STATUS_292 = "292";
    public static final String STATUS_293 = "293";
    public static final String STATUS_294 = "294";
    public static final String STATUS_295 = "295";


    /**
     * network params
     */
    // 公共参数
    public static final String MOBILE_TYPE = "mobileType";
    public static final String VERSION_NUMBER = "versionNumber";
    public static final String SIGNA = "signMsg";
    public static final String LOGINCLIENT = "loginClient";
    // 登录参数
    public static final String TOKEN = "token";
    public static final String USER_ID = "userId";
    public static final String SESSIONID = "sessionId";

    // SP 字段
    public static final String IS_LAND = "isLand";
    public static final String IS_FIRST_IN = "isFirstIn";
    //三方App包名
    public static final String PACKAGE_ALIPAY = "com.eg.android.AlipayGphone";//支付宝
    public static final String PACKAGE_WEIXIN = "com.tencent.mm";//微信


    /**
     * 抓取用户信息  (联系人、短信记录、通话记录)
     */
    public static final int CONTACTS_TYPE = 0X110;
    public static final int SMS_TYPE = 0X111;
    public static final int RECORD_TYPE = 0X112;
    public static final int GRAB_ERROR = 0x101010;
    public static final int GRAB_NONEED = 0x101011;


    //用户信息三要素 标识
    public static final String CONTACTS = "contacts";
    public static final String SMS_LOGS = "sms_logs";
    public static final String CALL_LOGS = "call_logs";

    //贷超获取数据表示
    public static final String DAMIDAICHAOHOT = "damiDaichaoHot"; //热
    public static final String DAMIDAICHAONEW = "damiDaichaoNew";//新
    public static final String DAMIDAICHAOINDEX = "damiDaichaoIndex";//主页Index


    public static class UMENGEVENT {
        public static final String INPUT_NUMBER_SUBMIT = "input_number_submit";
        public static final String INPUT_CODE_SUBMIT = "input_code_submit";
        public static final String INPUT_CODE_REGISTER = "input_code_register";
        public static final String INPUT_PWD_SUBMIT = "input_pwd_submit";
        public static final String INPUT_PWD_REGISTER = "input_pwd_register";


        public static final String MINE_CENTER = "mine_center";
        public static final String MINE_BANK = "mine_bank";
        public static final String MINE_SETTING = "mine_setting";
        public static final String MINE_HELPCENTER = "mine_helpcenter";
        public static final String MINE_SERVICE = "mine_service";
        public static final String MINE_COUPON = "mine_coupon";
        public static final String MINE_METTING = "mine_metting";
        public static final String MINE_FOLLOWWECHAT = "mine_followwechat";
        public static final String MINE_BORROWREPAY_RECORD = "mine_borrowrepay_record";

        public static final String SETTING_UPDATE_PWD = "setting_update_pwd";
        public static final String SETTING_ABOUTUS = "setting_abousus";
        public static final String SETTING_LAWPROTOCOL = "setting_lawprotocol";
        public static final String SETTING_VERSION = "setting_version";
        public static final String SETTING_LOGICOUT = "setting_logicout";


        public static final String UPDATE_PWD_SUBMIT = "update_pwd_submit";
        public static final String FORGET_PWD = "forget_pwd";
        public static final String PWD_CODE_SUBMIT = "forget_code_submit";
        public static final String NEW_PWD_SUBMIT = "new_pwd_submit";


        public static final String MAIN_LOAN = "main_loan";
        public static final String MAIN_MEMBER = "main_member";
        public static final String MAIN_METTING = "main_metting";
        public static final String MAIN_MINE = "main_mine";
        public static final String MAIN_SERVER = "main_server";
        public static final String MAIN_CALL = "main_call";
        public static final String MAIN_FAKE_DRAW = "main_fake_draw";
        public static final String MAIN_START_LOAN = "main_start_loan";
        public static final String MAIN_PROGRESS_INQUIRE = "main_progress_inquire";
        public static final String MAIN_WIRHDRAW = "main_withdraw";
        public static final String MAIN_REPAY = "main_repay";
        public static final String MAIN_OVERDUE_REPAY = "main_overdue_repay";
        public static final String MAIN_REVIEW_WITHDRAW = "main_review_withdraw";
        public static final String MAIN_CANCEL_LOAN = "main_cancel_loan";
        public static final String MAIN_ADD_CALENDAR = "main_add_calendar";
        public static final String MAIN_BORROW_DETAIL = "main_borrow_detail";


        public static final String WITHDRAW_MONTHREPAY = "withdraw_monthrepay";
        public static final String WITHDRAW_BANKCARD = "withdraw_bankcard";
        public static final String OPEN_VIP = "open_vip";
        public static final String RENEW_VIP = "renew_vip";
        public static final String WITHDRAW_SUCCESS = "withdraw_success";
        public static final String WITHDRAW_failed = "withdraw_falied";
        public static final String VIP_DETAIL = "vip_detail";
        public static final String VIP_OPEN_REFUSE = "vip_open_refuse";
        public static final String VIP_OPEN_THINK = "vip_open_think";
        public static final String VIP_PURCHASE = "vip_purchase";
        public static final String VIP_RENEW_PURCHASE = "vip_renew_purchase";
        public static final String VIP_EQUITY = "vip_equity";
        public static final String VIP_PERSON_REPORT = "vip_person_report";
        public static final String VIP_PHONE_REPORT = "vip_phone_report";
        public static final String VIP_GO_RENWE = "vip_go_renew";


        public static final String REPAY_BY_BANK = "repay_by_bank";
        public static final String REPAY_BY_ALIPAY = "repay_by_alipay";
        public static final String REPAY_BY_WECHAT = "repay_by_wechat";


        public static final String GO_MARKET = "go_market";
        public static final String MARKET_DETAIL = "market_detail";
        public static final String MARKET_GO_BORROW = "market_go_borrow";


    }
}
