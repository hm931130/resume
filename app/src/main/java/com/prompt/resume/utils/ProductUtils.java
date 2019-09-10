package com.prompt.resume.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import static com.blankj.utilcode.util.ActivityUtils.startActivity;

/**
 * Created by Administrator on 2019/4/4.
 */

public class ProductUtils {

    public static void launchSysBrowser(Context context, String url) {
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

}
