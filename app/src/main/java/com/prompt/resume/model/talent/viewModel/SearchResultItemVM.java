package com.prompt.resume.model.talent.viewModel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.prompt.resume.BR;

/**
 * author ：hm
 * date : 2019/9/9 15:03
 * package：com.prompt.resume.model.talent.viewModel
 * description :
 */
public class SearchResultItemVM extends BaseObservable {


    private String name;
    private String sex;
    private String area;
    private int age;
    private String degree;
    private String workYear;
    private String job;

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
        notifyPropertyChanged(BR.sex);
    }

    @Bindable
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
        notifyPropertyChanged(BR.area);
    }

    @Bindable
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }

    @Bindable
    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
        notifyPropertyChanged(BR.degree);
    }

    @Bindable
    public String getWorkYear() {
        return workYear;
    }

    public void setWorkYear(String workYear) {
        this.workYear = workYear;
        notifyPropertyChanged(BR.workYear);
    }

    @Bindable
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
        notifyPropertyChanged(BR.job);
    }
}
