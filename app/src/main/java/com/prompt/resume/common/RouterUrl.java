package com.prompt.resume.common;

/**
 * Author: TinhoXu
 * E-mail: xth@erongdu.com
 * Date: 2016/12/6 18:06
 * <p>
 * Description: 路由表
 */
@SuppressWarnings("unused")
public class RouterUrl {
    private static final String URI_SCHEME = "wolverine:/";

    /**
     * 获得请求URI
     */
    public static String getRouterUrl(String host) {
        return URI_SCHEME + host;
    }

    /****************************************************************************************************************/
    /******************************************* appCommon router url ***********************************************/
    /****************************************************************************************************************/

    // 主界面 - 声明
    public static final String AppCommon_IMain = "appCommon/main";
    // 主界面 - 调用(参数：type：0 - 首页，1 - 理财，2 - 资产，3 - 我)
    public static final String AppCommon_Main = AppCommon_IMain + "?type=%1$s";
    // 启动页
    public static final String AppCommon_Splash = "appCommon/splash";
    // WebView 页面 - 声明
    public static final String AppCommon_IWebView = "appCommon/webView";
    // WebView 页面 - 调用(参数：title - 标题，url - 请求地址，)
    public static final String AppCommon_WebView = AppCommon_IWebView + "?title=%1$s&url=%2$s&postData=%3$s";

    public static final String REGIS_CODE = "regis/code" + "?mobile=%1$s";
    public static final String REGIS_FORGET_PWD = "regis/forget/pwd";
    public static final String LOGIN_PWD = "login/pwd";
    public static final String ACCOUNT_AUTH = "account/auth";
    public static final String INVITATION_AUTH = "invitation/auth";
    public static final String COMPANY_AUTH = "company/auth";
    public static final String WAIT_AUTH = "wait/auth";
    public static final String SEARCH_KEY = "search/key" + "?termsCount=%1$d";
    public static final String SEARCH_RESULT = "search/result";

}
