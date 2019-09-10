package com.prompt.resume.model.talent.ui.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prompt.resume.R;
import com.prompt.resume.common.ui.BaseFragment;
import com.prompt.resume.databinding.FragTalentBinding;
import com.prompt.resume.model.talent.viewControl.TalentCtrl;

/**
 * author ：hm
 * date : 2019/9/4 18:24
 * package：com.prompt.resume.model.talent.ui.fragment
 * description :查找人才
 */
public class TalentFrag extends BaseFragment {


    private TalentCtrl talentCtrl;

    public static TalentFrag newInstance() {
        
        Bundle args = new Bundle();
        
        TalentFrag fragment = new TalentFrag();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragTalentBinding binding = DataBindingUtil.inflate(inflater, R.layout.frag_talent, null, false);
        talentCtrl = new TalentCtrl(binding,getChildFragmentManager());
        binding.setViewCtrl(talentCtrl);
        return binding.getRoot();

    }
}
