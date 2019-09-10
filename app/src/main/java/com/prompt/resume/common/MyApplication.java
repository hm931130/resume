package com.prompt.resume.common;

import android.app.Activity;
import android.app.Application;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;

import com.blankj.utilcode.util.Utils;
import com.prompt.resume.database.SharedInfo;
import com.prompt.resume.utils.ActivityManage;
import com.prompt.resume.utils.Config;
import com.prompt.resume.utils.ContextHolder;
import com.prompt.resume.utils.ExceptionHandler;
import com.raizlabs.android.dbflow.config.FlowManager;


/**
 * Created by Administrator on 2019/4/1.
 */

public class MyApplication extends Application {
    private static final String TAG = "MyApplication";
    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化DBFLOW
        FlowManager.init(this);

        Log.i(TAG, ">>>>>>>>>>>>>>>>>>> Enter <<<<<<<<<<<<<<<<<<<");
        //工具类初始化
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                ActivityManage.push(activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {
                ActivityManage.setTopActivity(activity);
            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                ActivityManage.remove(activity);
            }
        });
        Utils.init(this);
        initExceptionHandler(); //异常捕捉
        iconFontInit();//字体
        ContextHolder.init(this);
        //root路径
        Config.ROOT_PATH.set(BaseParams.ROOT_PATH);
        // 内存共享对象初始化
        SharedInfo.init(BaseParams.SP_NAME);

    }




    public static synchronized MyApplication getInstance() {
        return instance;
    }

    //字体图标
    private Typeface iconTypeFace;

    public Typeface getIconTypeFace() {
        return iconTypeFace;
    }

    /**
     * iconfont 初始化
     */
    private void iconFontInit() {
        instance = this;
        iconTypeFace = Typeface.createFromAsset(getAssets(), "iconfont.ttf");
    }

    private void initExceptionHandler() {
        ExceptionHandler mCustomCrashHandler = ExceptionHandler.getInstance();
        mCustomCrashHandler.setCustomCrashHanler(this);
    }

}
