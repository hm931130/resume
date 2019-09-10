package com.prompt.resume.model.talent.ui.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prompt.resume.R;
import com.prompt.resume.common.ui.BaseFragment;
import com.prompt.resume.databinding.FragMineBinding;
import com.prompt.resume.model.talent.viewControl.MineCtrl;

/**
 * author ：hm
 * date : 2019/9/4 18:25
 * package：com.prompt.resume.model.talent.ui.fragment
 * description :我的
 */
public class MineFrag extends BaseFragment {

    private MineCtrl mineCtrl;

    public static MineFrag newInstance() {
        
        Bundle args = new Bundle();
        
        MineFrag fragment = new MineFrag();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragMineBinding binding = DataBindingUtil.inflate(inflater, R.layout.frag_mine, null, false);
        mineCtrl = new MineCtrl(binding);
        binding.setViewCtrl(mineCtrl);
        return binding.getRoot();
    }
}
