package com.prompt.resume.model.talent.ui.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prompt.resume.R;
import com.prompt.resume.common.ui.BaseFragment;
import com.prompt.resume.databinding.FragIntentionBinding;
import com.prompt.resume.model.talent.viewControl.IntentionCtrl;

/**
 * author ：hm
 * date : 2019/9/5 10:49
 * package：com.prompt.resume.model.talent.ui.fragment
 * description :有意向
 */
public class IntentionFrag extends BaseFragment {


    private IntentionCtrl intentionCtrl;

    public static IntentionFrag newInstance() {

        Bundle args = new Bundle();

        IntentionFrag fragment = new IntentionFrag();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragIntentionBinding binding = DataBindingUtil.inflate(inflater, R.layout.frag_intention, null, false);
        intentionCtrl = new IntentionCtrl(binding);
        binding.setViewCtrl(intentionCtrl);
        return binding.getRoot();
    }
}
