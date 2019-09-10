package com.prompt.resume.common.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.blankj.utilcode.util.AppUtils;
import com.prompt.resume.common.BundleKeys;
import com.prompt.resume.common.Constant;
import com.prompt.resume.common.RequestResultCode;
import com.prompt.resume.database.SharedInfo;
import com.prompt.resume.databinding.ActWebViewBinding;
import com.prompt.resume.network.utils.UrlUtils;
import com.prompt.resume.utils.ToastUtil;
import com.prompt.resume.utils.Util;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import static com.blankj.utilcode.util.ActivityUtils.startActivity;

/**
 * Created by Administrator on 2019/4/23.
 */

public class WebViewCtrl {
    private ActWebViewBinding binding;

    public WebViewCtrl(ActWebViewBinding binding, WebView webView, String url, String html, String postData, boolean isVipEnter) {
        this.binding = binding;
        if (!TextUtils.isEmpty(url) && !TextUtils.isEmpty(postData)) {
            webView.postUrl(url, postData.getBytes());
        } else {
            String sign = (String) SharedInfo.getInstance().getValue(BundleKeys.SIGN, "");
            if (!TextUtils.isEmpty(sign)) {
                SharedInfo.getInstance().saveValue(BundleKeys.SIGN, "");
                Map map = new HashMap<String, String>();
                map.put(Constant.TOKEN, UrlUtils.getInstance().getToken());
                map.put(Constant.SIGNA, sign);
                webView.loadUrl(url, map);
            } else {
                webView.loadUrl(url);
            }
        }

        WebSettings setting = webView.getSettings();
        // 支持缩放
        setting.setSupportZoom(false);
        // 设置支持缩放 + -
        // setting.setBuiltInZoomControls(false);
        // 关闭 webView 中缓存
        /**/
        /*webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);*/
        setting.setUseWideViewPort(false);
        // 设置WebView属性，能够执行Javascript脚本
        setting.setJavaScriptEnabled(true);
        setting.setSavePassword(false);
        setting.setDomStorageEnabled(true);
        setting.setDefaultTextEncodingName("utf-8");
        setting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        setting.setLoadWithOverviewMode(true);
        webView.addJavascriptInterface(new WebReturn(), "webReturn");

        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            dealJavascriptLeak(webView);
        }*/
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        webView.setWebViewClient(new MyWebViewClient());
        webView.setWebChromeClient(new MyWebChromeClient());

    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void dealJavascriptLeak(WebView webView) {
        webView.removeJavascriptInterface("searchBoxJavaBridge_");
        webView.removeJavascriptInterface("accessibility");
        webView.removeJavascriptInterface("accessibilityTraversal");
    }

    private class WebReturn {


        @JavascriptInterface
        public void immediatelyBorrow(final String url) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            Uri content_url = Uri.parse(url);
            intent.setData(content_url);
            startActivity(intent);
        }


    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public void doUpdateVisitedHistory(WebView view, String url, boolean isReload) {
            Log.e("WebViewCtrl", "doUpdateVisitedHistory - url=" + url);
            if (url.contains("/authorize/success")) {  //认证成功
                ToastUtil.toast("认证完成!");
                Util.getActivity(binding.getRoot()).finish();

            } else if (url.contains("/authorize/failure")) {
                ToastUtil.toast("认证失败!");
                Util.getActivity(binding.getRoot()).finish();
            }
            super.doUpdateVisitedHistory(view, url, isReload);
        }

        public void onReceivedSslError(WebView view,
                                       SslErrorHandler handler, SslError error) {
            Log.e("WebViewCtrl", "onReceivedSslError ");
            // 　　//handler.cancel(); 默认的处理方式，WebView变成空白页
            handler.proceed(); // 接受证书
            // handleMessage(Message msg); 其他处理

        }

        @RequiresApi(api = Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1)
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.e("WebViewCtrl", "shouldOverrideUrlLoading - url=" + url);
            if (url.contains("api/operatorReturnback.htm")) {
                Util.getActivity(binding.getRoot()).setResult(RequestResultCode.RES_PHONE);
                Util.getActivity(binding.getRoot()).finish();
            }
            System.out.println("url==================================" + url);
            if (url.startsWith("tel:")) {
                Intent intent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse(url));
                Util.getActivity(binding.getRoot()).startActivity(intent);
            } else if (url.startsWith("sms:")) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                String[] sms = url.split("\\?");
                intent.setType("vnd.android-dir/mms-sms");
                intent.setData(Uri.parse(sms[0]));
                if (sms.length >= 2) {
                    String[] body = sms[1].split("=");
                    intent.putExtra("sms_body", body[1]);
                }
                Util.getActivity(binding.getRoot()).startActivity(intent);
            } else if (url.startsWith("intent://")) {
                Intent intent;
                try {
                    intent = Intent.parseUri(url, Intent.URI_INTENT_SCHEME);
                    // forbid launching activities without BROWSABLE
                    // category
                    intent.addCategory("android.intent.category.BROWSABLE");
                    // forbid explicit call
                    intent.setComponent(null);
                    // forbid intent with selector intent
                    intent.setSelector(null);
                    // start the activity by the intent
                    Util.getActivity(binding.getRoot()).startActivityIfNeeded(intent, -1);
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
                return true;
            } else if (url != null && (url.startsWith("alipays://") || url.startsWith("weixin://"))) {
                if (url.startsWith("alipays://")) {
                    if (!AppUtils.isAppInstalled(Constant.PACKAGE_ALIPAY)) {
                        ToastUtil.toast("请安装支付宝客户端");
                        return true;
                    }
                }
                if (url.startsWith("weixin://")) {
                    if (!AppUtils.isAppInstalled(Constant.PACKAGE_WEIXIN)) {
                        ToastUtil.toast("请安装微信客户端");
                        return true;
                    }
                }
                view.getContext().startActivity(
                        new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                return true;
            } else {
                System.out.println("url--" + url);
                if (url != null && url.contains("wx.tenpay.com")) {
                    Map<String, String> extraHeader = new HashMap<>();
                    extraHeader.put("Referer", "Https://qy-h5-dev.billbear.cn");
                    view.loadUrl(url, extraHeader);
                } else {
                    view.loadUrl(url);
                }
            }
            return false;
        }

        // 开始加载网页时要做的工作
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        // 加载完成时要做的工作
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }
    }

    private class MyWebChromeClient extends WebChromeClient {


        // JS的提示框
        @Override
        public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
            return true;
        }

        // JS调用和反调用
        @Override
        public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
            if (message.equals("1")) {
                // 解析参数defaultValue
                // 调用java方法并得到结果
            }
            // 返回结果
            result.confirm("result");

            /*
            function showHtmlCallJava() {
                var ret = prompt( "1", "param1;param2" );
                // ret值即为java传回的”result”
                // 根据返回内容作相应处理
            }
            */
            return true;
        }
    }
}
