package com.prompt.resume.model.talent.ui.fragment;

import android.os.Bundle;

import com.prompt.resume.common.ui.BaseFragment;

/**
 * author ：hm
 * date : 2019/9/5 10:49
 * package：com.prompt.resume.model.talent.ui.fragment
 * description :意向等待
 */
public class PendingIntentionFrag extends BaseFragment {

    public static PendingIntentionFrag newInstance() {
        
        Bundle args = new Bundle();
        
        PendingIntentionFrag fragment = new PendingIntentionFrag();
        fragment.setArguments(args);
        return fragment;
    }
}
