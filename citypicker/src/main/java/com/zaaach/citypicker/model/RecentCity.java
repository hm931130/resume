package com.zaaach.citypicker.model;

/**
 * author ：hm
 * date : 2019/9/6 20:20
 * package：com.zaaach.citypicker.model
 * description :
 */
public class RecentCity extends City {
    public RecentCity(String name, String province, String code) {
        super(name, province, "最近访问", code);
    }
}
