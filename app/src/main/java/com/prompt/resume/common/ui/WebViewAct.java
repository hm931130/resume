package com.prompt.resume.common.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;

import com.github.mzule.activityrouter.annotation.Router;
import com.prompt.resume.R;
import com.prompt.resume.common.BundleKeys;
import com.prompt.resume.common.RouterUrl;
import com.prompt.resume.database.SharedInfo;
import com.prompt.resume.databinding.ActWebViewBinding;
import com.prompt.resume.utils.NavigationBarUtil;

/**
 * Created by Administrator on 2019/4/23.
 */
@Router(value = RouterUrl.AppCommon_IWebView, stringParams = {BundleKeys.TITLE, BundleKeys.URL, BundleKeys.POST_DATA})
public class WebViewAct extends BaseActivity {
    private ActWebViewBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String title = intent.getStringExtra(BundleKeys.TITLE);
        String url = intent.getStringExtra(BundleKeys.URL);
        String postData = intent.getStringExtra(BundleKeys.POST_DATA);
        boolean isVipEnter = intent.getBooleanExtra(BundleKeys.ISVIP_ENTER, false);
        String html = intent.getStringExtra("html");
        binding = DataBindingUtil.setContentView(this, R.layout.act_web_view);
        String urlTemp = (String) SharedInfo.getInstance().getValue(BundleKeys.URL, "");
        if (!TextUtils.isEmpty(urlTemp)) {
            url = urlTemp;
            SharedInfo.getInstance().saveValue(BundleKeys.URL, "");
        }
        binding.toolBar.setTitle(title);
        binding.setViewCtrl(new WebViewCtrl(binding, binding.webView, url, html, postData, isVipEnter));
        AndroidBug5497Workaround.assistActivity(this);
        if (NavigationBarUtil.hasNavigationBar(this)) {
            NavigationBarUtil.initActivity(findViewById(android.R.id.content));
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && binding.webView.canGoBack()) {
            binding.webView.goBack();// 返回前一个页面
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressedSupport() {
        super.onBackPressedSupport();
    }

}
