package com.prompt.resume.model.talent.viewModel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.prompt.resume.BR;

/**
 * author ：hm
 * date : 2019/9/9 10:59
 * package：com.prompt.resume.model.talent.viewModel
 * description :
 */
public class CommonIntentVM extends BaseObservable {

    private String name;
    private int age;
    private String degree;
    private String graduatedSchool;
    private int workYear;
    private String lastPosition;
    private String lastCompany;
    private String resumeNo;
    private String sex;
    private int outstandingState;
    private int intentState;

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
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
    public String getGraduatedSchool() {
        return graduatedSchool;
    }

    public void setGraduatedSchool(String graduatedSchool) {
        this.graduatedSchool = graduatedSchool;
        notifyPropertyChanged(BR.graduatedSchool);
    }

    @Bindable
    public int getWorkYear() {
        return workYear;
    }

    public void setWorkYear(int workYear) {
        this.workYear = workYear;
        notifyPropertyChanged(BR.workYear);
    }

    @Bindable
    public String getLastPosition() {
        return lastPosition;
    }

    public void setLastPosition(String lastPosition) {
        this.lastPosition = lastPosition;
        notifyPropertyChanged(BR.workYear);
    }

    @Bindable
    public String getLastCompany() {
        return lastCompany;
    }

    public void setLastCompany(String lastCompany) {
        this.lastCompany = lastCompany;
        notifyPropertyChanged(BR.lastCompany);
    }

    @Bindable
    public String getResumeNo() {
        return resumeNo;
    }

    public void setResumeNo(String resumeNo) {
        this.resumeNo = resumeNo;
        notifyPropertyChanged(BR.resumeNo);
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
    public int getOutstandingState() {
        return outstandingState;
    }

    public void setOutstandingState(int outstandingState) {
        this.outstandingState = outstandingState;
        notifyPropertyChanged(BR.outstandingState);
    }

    @Bindable
    public int getIntentState() {
        return intentState;
    }

    public void setIntentState(int intentState) {
        this.intentState = intentState;
        notifyPropertyChanged(BR.intentState);
    }
}
