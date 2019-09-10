package com.prompt.resume.model.talent.viewModel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.prompt.resume.BR;

/**
 * author ：hm
 * date : 2019/9/5 15:24
 * package：com.prompt.resume.model.talent.viewModel
 * description :
 */
public class IntentionVM extends BaseObservable {



    private int nodataShow;


    @Bindable
    public int getNodataShow() {
        return nodataShow;
    }

    public void setNodataShow(int nodataShow) {
        this.nodataShow = nodataShow;
        notifyPropertyChanged(BR.nodataShow);
    }
}
