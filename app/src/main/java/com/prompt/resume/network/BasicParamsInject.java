package com.prompt.resume.network;


import com.blankj.utilcode.util.AppUtils;
import com.prompt.resume.common.BaseParams;
import com.prompt.resume.common.Constant;
import com.prompt.resume.network.interceptor.BasicParamsInterceptor;
import com.prompt.resume.network.interceptor.IBasicDynamic;
import com.prompt.resume.network.utils.UrlUtils;

import java.util.Map;
import java.util.TreeMap;

import okhttp3.Interceptor;

/**
 * Author: TinhoXu
 * E-mail: xth@erongdu.com
 * Date: 2016/4/5 17:59
 * <p/>
 * Description: 拦截器 - 用于添加签名参数
 */
class BasicParamsInject {
    private BasicParamsInterceptor interceptor;

    BasicParamsInject() {
        // 设置静态参数
        interceptor = new BasicParamsInterceptor.Builder()
                //.addBodyParam(Constant.APP_KEY, BaseParams.APP_KEY)
                .addBodyParam(Constant.MOBILE_TYPE, BaseParams.MOBILE_TYPE)
                .addBodyParam(Constant.VERSION_NUMBER, AppUtils.getAppVersionName())
                .build();
        // 设置动态参数
        interceptor.setIBasicDynamic(new IBasicDynamic() {
            @Override
            public String signParams(String postBodyString) {
                //post提交动态添加参数
                return UrlUtils.getInstance().dynamicParams(postBodyString);
            }

            @Override
            public Map signParams(Map map) {
                //get提交动态添加参数
                TreeMap temp = new TreeMap(map);
                return UrlUtils.getInstance().dynamicParams(temp);
            }

            @Override
            public Map signHeadParams(Map headMap) {
                return UrlUtils.getInstance().signParams(headMap);
            }
        });
    }

    Interceptor getInterceptor() {
        return interceptor;
    }
}
