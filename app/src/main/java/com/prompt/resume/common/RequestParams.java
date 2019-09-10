package com.prompt.resume.common;

/**
 * Author: TinhoXu
 * E-mail: xth@erongdu.com
 * Date: 2016/11/16 15:24
 * <p>
 * Description:
 */
public class RequestParams {
    public static final String UUID = "uuid";
    public static final String ID = "id";
    public static final String PWD = "pwd";
    public static final String TRADEPWD = "tradePwd";
    public static final String REFRESH_TOKEN = "refresh_token";
    public static final String INVITER = "inviter";
    public static final String PHONE = "phone";
    public static final String PATH_WAY = "pathWay";
    public static final String PASSWORD = "password";
    public static final String DYNAMIC_VALID_CODE = "dynamicValidCode";
    public static final String CODE = "vcode";
    public static final String __SID = "__sid";
    public static final String VALID_CODE = "validCode";
    public static final String PAGE = "page.page";
    public static final String PAGE_SIZE = "page.pageSize";
    public static final String INVITE_LEVEL = "inviteLevel";
    public static final String CONTENT = "content";
    public static final String MOBILE = "mobile";
    public static final String EMAIL = "email";
    public static final String IDNO = "idNo";
    public static final String REALNAME = "realName";
    public static final String BANK_CODE = "bankCode";
    public static final String CARD_ID = "cardId";
    public static final String IMG_URL = "imgUrl";
    public static final String SECTION_CODE = "sectionCode";
    public static final String TYPE = "type";
    public static final String SIGN = "signMsg";
    public static final String FEEDBACK = "feedback";
    public static final String CLIENTID = "clientid";
    public static final String ONLINE_KEY = "key";
    public static final String QIYUN_KEY = "qiyun_key";
    public static final String BORROW_ID = "borrowId";
    public static final String SCAN_UPLOAD_ID = "uploadId";
    public static final String COUPON_INCOME_ID = "income";
    public static final String BUTTON_FIND_URL = "button_find_url";
    public static final String USE_FACE_VERIFY_WAY = "use_face_verify_way";
    public static final String GROUP = "group";
    public static final String PURCHASEORDERID = "purchaseOrderId";
    public static final String REPAYORDERID = "repayOrderId";
    public static final String COUPONTYPEID = "couponTypeId";
    public static final String INCOME = "income";
    public static final String OBJIDSTR = "objIdStr";
    public static final String COUPONID = "couponId";
    public static final String SMSTYPE = "smsType";
    public static final String SMSCODE = "smsCode";
    public static final String NAME = "name";
    public static final String COMPNAME = "compName";
    public static final String CLIENTTYPE = "clientType";
    public static final String INVITECODE = "inviteCode";
    public static final String NEWPWD = "newPwd";

    public static final String PAGENUM = "pageNum";
    public static final String INTENTSTATE = "intentState";
    public static final String KEYWORDSBYTYPE = "keywordsByType";

    /**
     * 订单号
     */
    public static final String ORDER_NO = "orderNo";
    /**
     * 金额
     */
    public static final String AMOUNT = "amount";
    /**
     * 借款期限
     */
    public static final String TIME_LIMIT = "timeLimit";
    //userId
    public static final String USERID = "userId";
    //productId
    public static final String PRODUCTID = "productId";
    //认证类型
    public static final String AUTHTYPE = "authType";
    //token 认证结果token
    public static final String AUTHTOKEN = "authToken";
    //authId
    public static final String AUTHID = "authId";
    //state
    public static final String STATE = "state";
    //rsp
    public static final String RSP = "rsp";
    //期望借款金额
    public static final String FAKE_AMOUNT = "fakeAmount";
    public static final String FAKE_TERM = "fakeTerm";

    public static final String CURRENT = "current";

    public static final String PAGESIZE = "pageSize";
    public static final String LOGID = "logId";


    //格式化第三方认证请求
    public static final String AUTH_REQUEST_API_FORMAT = "api_key=%1$s&id_card_num=%2$s&phone=%3$s&name=%4$s&user_id=%5$d";
    //格式化借款协议请求HOST
    public static final String PROTOCOL_BORROW_HOST = "/api/v1/act/borrow/protocolPreview.htm?";

    public static final String PROTOCOL_BORROW_FORMAT = "amount=%1$s&timeLimit=%2$s&userId=%3$s&mobileType=%4$s&versionNumber=%5$s";

    //会员开通成功
    public static final String VIP_SUCCESS = "vip_success";
    public static final String VIP_SUCCESS_REMARK = "vip_success_remark";
}
