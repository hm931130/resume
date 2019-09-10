package com.prompt.resume.database;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * author ：hm
 * date : 2019/9/5 16:59
 * package：com.prompt.resume.database
 * description :
 */
@Database(name = AppDataBase.NAME,version = AppDataBase.VERSION)
public class AppDataBase {

    public static final String NAME="AppDataBase";
    public static final int VERSION=1;
}
