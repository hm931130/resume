package com.prompt.resume.model.talent.ui.fragment;

import android.os.Bundle;

import com.prompt.resume.common.ui.BaseFragment;

/**
 * author ：hm
 * date : 2019/9/5 10:49
 * package：com.prompt.resume.model.talent.ui.fragment
 * description :无意向
 */
public class NoIntentionFrag extends BaseFragment {
    public static NoIntentionFrag newInstance() {
        
        Bundle args = new Bundle();
        
        NoIntentionFrag fragment = new NoIntentionFrag();
        fragment.setArguments(args);
        return fragment;
    }
}
