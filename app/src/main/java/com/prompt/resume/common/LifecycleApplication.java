package com.prompt.resume.common;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.prompt.resume.utils.ActivityManage;


/**
 * Created by Administrator on 2019/4/1.
 */

public class LifecycleApplication  {
    protected static final String TAG   = "LifecycleApplication";
    /** 当前活动的Activity数量 */
    private                int    count = 0;

//    @Override
    public void onCreate() {
//        registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
//            @Override
//            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
//                ActivityManage.push(activity);
//            }
//
//            @Override
//            public void onActivityStarted(Activity activity) {
//                ActivityManage.setTopActivity(activity);
//            }
//
//            @Override
//            public void onActivityResumed(Activity activity) {
//
//            }
//
//            @Override
//            public void onActivityPaused(Activity activity) {
//
//            }
//
//            @Override
//            public void onActivityStopped(Activity activity) {
//
//            }
//
//            @Override
//            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
//
//            }
//
//            @Override
//            public void onActivityDestroyed(Activity activity) {
//                ActivityManage.remove(activity);
//            }
//        });
    }
}
