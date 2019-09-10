package com.prompt.resume.model.talent.viewModel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import com.prompt.resume.BR;

/**
 * author ：hm
 * date : 2019/9/5 16:38
 * package：com.prompt.resume.model.talent.viewModel
 * description :
 */
public class SearchVM extends BaseObservable {


    private String hintTips;

    private String titleTips;

    private int termsCount;

    private int searchHisVis;

    private int searchHisCount;

    private int tiptitleVis;

    private int categoryVis = View.GONE;
    private String keyStr;

    @Bindable
    public int getCategoryVis() {
        return categoryVis;
    }

    public void setCategoryVis(int categoryVis) {
        this.categoryVis = categoryVis;
        notifyPropertyChanged(BR.categoryVis);
    }

    @Bindable
    public int getTiptitleVis() {
        return tiptitleVis;
    }

    public void setTiptitleVis(int tiptitleVis) {
        this.tiptitleVis = tiptitleVis;
        notifyPropertyChanged(BR.tiptitleVis);
    }

    @Bindable
    public String getKeyStr() {
        return keyStr;
    }

    public void setKeyStr(String keyStr) {
        this.keyStr = keyStr;
        notifyPropertyChanged(BR.keyStr);
    }

    @Bindable
    public int getSearchHisVis() {
        return searchHisVis;
    }

    public void setSearchHisVis(int searchHisVis) {
        this.searchHisVis = searchHisVis;
        notifyPropertyChanged(BR.searchHisVis);
    }

    public int getSearchHisCount() {
        return searchHisCount;
    }

    public void setSearchHisCount(int searchHisCount) {
        this.searchHisCount = searchHisCount;
    }

    public void setTermsCount(int termsCount) {
        this.termsCount = termsCount;
        if (termsCount > 0) {
            setHintTips("继续增加条件在结果中搜索");
            setTitleTips("增加搜索条件，获取更精准的搜索结果");
            setSearchHisVis(View.GONE);
            setTiptitleVis(View.VISIBLE);
        } else {
            setHintTips("通过关键字快速搜索人才");
            setTitleTips("输入搜索条件，解锁更多人才吧");
            if (getSearchHisCount() > 0) {
                setSearchHisVis(View.VISIBLE);
                setTiptitleVis(View.GONE);
            } else {
                setSearchHisVis(View.GONE);
                setTiptitleVis(View.VISIBLE);
            }
        }
    }

    @Bindable
    public String getHintTips() {
        return hintTips;
    }

    public void setHintTips(String hintTips) {
        this.hintTips = hintTips;
        notifyPropertyChanged(BR.hintTips);
    }

    @Bindable
    public String getTitleTips() {
        return titleTips;
    }

    public void setTitleTips(String titleTips) {
        this.titleTips = titleTips;
        notifyPropertyChanged(BR.titleTips);
    }
}
