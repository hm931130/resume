package com.prompt.resume.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.provider.MediaStore;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import static android.content.Context.WIFI_SERVICE;

/**
 * Created by chenming
 * Created Date 17/4/19 10:20
 * mail:cm1@erongdu.com
 * Describe:  获取Android设备信息的工具类
 */
public class DeviceUtil {
    /**
     * dp 转化为 px
     *
     * @param context
     * @param dpValue
     *
     * @return
     */
    public static int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * px 转化为 dp
     *
     * @param context
     * @param pxValue
     *
     * @return
     */
    public static int px2dp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 获取设备宽度（px）
     *
     * @param context
     *
     * @return
     */
    public static int deviceWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * 获取设备高度（px）
     *
     * @param context
     *
     * @return
     */
    public static int deviceHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    /**
     * SD卡判断
     *
     * @return
     */
    public static boolean isSDCardAvailable() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    /**
     * 是否有网
     *
     * @param context
     *
     * @return
     */
    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager
                    .getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    /**
     * 返回版本名字
     * 对应build.gradle中的versionName
     *
     * @param context
     *
     * @return
     */
    public static String getVersionName(Context context) {
        String versionName = "1.0";
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo    packInfo       = packageManager.getPackageInfo(context.getPackageName(), 0);
            versionName = packInfo.versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return versionName;
    }

    /**
     * 返回版本号
     * 对应build.gradle中的versionCode
     *
     * @param context
     *
     * @return
     */
    public static String getVersionCode(Context context) {
        String versionCode = "1";
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo    packInfo       = packageManager.getPackageInfo(context.getPackageName(), 0);
            versionCode = String.valueOf(packInfo.versionCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return versionCode;
    }

    /**
     * 获取设备的唯一标识，deviceId
     *
     * @param context
     *
     * @return
     */
    public static String getDeviceId(Context context) {
        TelephonyManager tm       = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String           deviceId = tm.getDeviceId();
        if (deviceId == null) {
            return "-1";
        } else {
            return deviceId;
        }
    }

    /**
     * 获取wifi name
     *
     * @return
     */
    public static String getWifiName(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService(WIFI_SERVICE);
        WifiInfo    wifiInfo    = wifiManager.getConnectionInfo();
        return wifiInfo.getSSID();
    }

    /**
     * 获取手机品牌
     *
     * @return
     */
    public static String getPhoneBrand() {
        return android.os.Build.BRAND;
    }

    /**
     * 获取手机型号
     *
     * @return
     */
    public static String getPhoneModel() {
        return android.os.Build.MODEL;
    }

    /**
     * 获取手机Android API等级（22、23 ...）
     *
     * @return
     */
    public static int getBuildLevel() {
        return android.os.Build.VERSION.SDK_INT;
    }

    /**
     * 获取手机Android 版本（4.4、5.0、5.1 ...）
     *
     * @return
     */
    public static String getBuildVersion() {
        return android.os.Build.VERSION.RELEASE;
    }

    /**
     * 获取当前App进程的id
     *
     * @return
     */
    public static int getAppProcessId() {
        return android.os.Process.myPid();
    }

    /**
     * 获取当前App进程的Name
     *
     * @param context
     * @param processId
     *
     * @return
     */
    public static String getAppProcessName(Context context, int processId) {
        String          processName = null;
        ActivityManager am          = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        // 获取所有运行App的进程集合
        List           l  = am.getRunningAppProcesses();
        Iterator       i  = l.iterator();
        PackageManager pm = context.getPackageManager();
        while (i.hasNext()) {
            ActivityManager.RunningAppProcessInfo info = (ActivityManager.RunningAppProcessInfo) (i.next());
            try {
                if (info.pid == processId) {
                    CharSequence c = pm.getApplicationLabel(pm.getApplicationInfo(info.processName, PackageManager.GET_META_DATA));

                    processName = info.processName;
                    return processName;
                }
            } catch (Exception e) {
                Log.e(DeviceUtil.class.getName(), e.getMessage(), e);
            }
        }
        return processName;
    }

    /**
     * 创建App文件夹
     *
     * @param appName
     * @param application
     *
     * @return
     */
    public static String createAPPFolder(String appName, Application application) {
        return createAPPFolder(appName, application, null);
    }

    /**
     * 创建App文件夹
     *
     * @param appName
     * @param application
     * @param folderName
     *
     * @return
     */
    public static String createAPPFolder(String appName, Application application, String folderName) {
        File root = Environment.getExternalStorageDirectory();
        File folder;
        /**
         * 如果存在SD卡
         */
        if (DeviceUtil.isSDCardAvailable() && root != null) {
            folder = new File(root, appName);
            if (!folder.exists()) {
                folder.mkdirs();
            }
        } else {
            /**
             * 不存在SD卡，就放到缓存文件夹内
             */
            root = application.getCacheDir();
            folder = new File(root, appName);
            if (!folder.exists()) {
                folder.mkdirs();
            }
        }
        if (folderName != null) {
            folder = new File(folder, folderName);
            if (!folder.exists()) {
                folder.mkdirs();
            }
        }
        return folder.getAbsolutePath();
    }

    /**
     * 通过Uri找到File
     *
     * @param context
     * @param uri
     *
     * @return
     */
    public static File uri2File(Activity context, Uri uri) {
        File     file;
        String[] project           = {MediaStore.Images.Media.DATA};
        Cursor   actualImageCursor = context.getContentResolver().query(uri, project, null, null, null);
        if (actualImageCursor != null) {
            int actual_image_column_index = actualImageCursor
                    .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            actualImageCursor.moveToFirst();
            String img_path = actualImageCursor
                    .getString(actual_image_column_index);
            file = new File(img_path);
        } else {
            file = new File(uri.getPath());
        }
        if (actualImageCursor != null)
            actualImageCursor.close();
        return file;
    }

    /**
     * 获取AndroidManifest.xml里 的值
     *
     * @param context
     * @param name
     *
     * @return
     */
    public static String getMetaData(Context context, String name) {
        if (context == null || TextUtils.isEmpty(name)) {
            return null;
        }
        String resultData = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
                if (applicationInfo != null) {
                    if (applicationInfo.metaData != null) {
                        resultData = applicationInfo.metaData.getString(name);
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return resultData;
    }

    /** 获取应用安装时间 */
    public static String getInstallTime(Context context) {
        String installTime = null;
        try {
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            PackageInfo    packageInfo    = packageManager.getPackageInfo(context.getPackageName(), 0);
            //应用装时间
            long firstInstallTime = packageInfo.firstInstallTime;
            //应用最后一次更新时间
            long lastUpdateTime = packageInfo.lastUpdateTime;
            //Log.d("first install time : " + firstInstallTime + " last update time :" + lastUpdateTime);
            //SimpleDateFormat
            installTime = DateUtil.formatter(DateUtil.Format.DATE, firstInstallTime);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return installTime;
    }

    // 有兴趣的朋友可以看下NetworkInterface在Android FrameWork中怎么实现的
    public static String macAddress() {
        String address = "";
        // 把当前机器上的访问网络接口的存入 Enumeration集合中
        Enumeration<NetworkInterface> interfaces = null;
        try {
            interfaces = NetworkInterface.getNetworkInterfaces();

            while (interfaces.hasMoreElements()) {
                NetworkInterface netWork = interfaces.nextElement();
                // 如果存在硬件地址并可以使用给定的当前权限访问，则返回该硬件地址（通常是 MAC）。
                byte[] by = netWork.getHardwareAddress();
                if (by == null || by.length == 0) {
                    continue;
                }
                StringBuilder builder = new StringBuilder();
                for (byte b : by) {
                    builder.append(String.format("%02X:", b));
                }
                if (builder.length() > 0) {
                    builder.deleteCharAt(builder.length() - 1);
                }
                String mac = builder.toString();
                Log.d("mac", "interfaceName=" + netWork.getName() + ", mac=" + mac);
                // 从路由器上在线设备的MAC地址列表，可以印证设备Wifi的 name 是 wlan0
                if (netWork.getName().equals("wlan0")) {
                    Log.d("mac", " interfaceName =" + netWork.getName() + ", mac=" + mac);
                    address = mac;
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return address;
    }

    /** 获得可用的内存 */
    public static long getmem_UNUSED(Context mContext) {
        long MEM_UNUSED;
        // 得到ActivityManager
        ActivityManager am = (ActivityManager) mContext.getSystemService(Context.ACTIVITY_SERVICE);
        // 创建ActivityManager.MemoryInfo对象

        ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
        am.getMemoryInfo(mi);

        // 取得剩余的内存空间

        MEM_UNUSED = mi.availMem / 1024;
        return MEM_UNUSED;
    }

    /**
     * 获得总内存
     */
    public static long getmem_TOLAL() {
        long mTotal;
        // /proc/meminfo读出的内核信息进行解释
        String         path    = "/proc/meminfo";
        String         content = null;
        BufferedReader br      = null;
        try {
            br = new BufferedReader(new FileReader(path), 8);
            String line;
            if ((line = br.readLine()) != null) {
                content = line;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // beginIndex
        int begin = content.indexOf(':');
        // endIndex
        int end = content.indexOf('k');
        // 截取字符串信息

        content = content.substring(begin + 1, end).trim();
        mTotal = Integer.parseInt(content);
        return mTotal;
    }

    /**  */
    public static String getSimMsg(Context context){
        TelephonyManager tm = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        String imsi = tm.getSubscriberId();
        return imsi;
    }

    // 获取指定Activity的截屏，保存到png文件
    public static Bitmap takeScreenShot(Activity activity) {
        // View是你需要截图的View
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap b1 = view.getDrawingCache();

        // 获取状态栏高度
        Rect frame = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;
        Log.i("TAG", "" + statusBarHeight);

        // 获取屏幕长和高
        int width = activity.getWindowManager().getDefaultDisplay().getWidth();
        int height = activity.getWindowManager().getDefaultDisplay()
                .getHeight();
        // 去掉标题栏
        // Bitmap b = Bitmap.createBitmap(b1, 0, 25, 320, 455);
        Bitmap b = Bitmap.createBitmap(b1, 0, statusBarHeight, width, height
                - statusBarHeight);
        view.destroyDrawingCache();
        return b;
    }

}
