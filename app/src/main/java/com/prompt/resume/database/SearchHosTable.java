package com.prompt.resume.database;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * author ：hm
 * date : 2019/9/5 17:03
 * package：com.prompt.resume.database
 * description :
 */
@Table(database =AppDataBase.class)
public class SearchHosTable extends BaseModel {


    @PrimaryKey(autoincrement = true)
    public int id;

    @Column
    public String keyStr;

    @Column
    public long timeStamp;


    public String getKeyStr() {
        return keyStr;
    }

    public void setKeyStr(String keyStr) {
        this.keyStr = keyStr;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "SearchHosTable{" +
                "keyStr='" + keyStr + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
