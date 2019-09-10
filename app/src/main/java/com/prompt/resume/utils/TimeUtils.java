package com.prompt.resume.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2018/7/17.
 */

public class TimeUtils {

    /**
     * 获取从今天开始三个月前的时间戳
     */
    public static String getThrMonthTime() {
        Calendar calendar = Calendar.getInstance();//得到Calendar实例
        calendar.add(Calendar.MONTH, -3);//把月份减三个月
        Date starDate = calendar.getTime();
        return String.valueOf(starDate.getTime());
    }

    public static String get180DaysTime() {
        Calendar calendar = Calendar.getInstance();//得到Calendar实例
        calendar.add(Calendar.MONTH, -6);//把月份减6个月
        Date starDate = calendar.getTime();
        return String.valueOf(starDate.getTime());
    }
}
