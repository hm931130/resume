package com.prompt.resume.model.talent.ui.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prompt.resume.R;
import com.prompt.resume.common.ui.BaseFragment;
import com.prompt.resume.databinding.FragOfficeBinding;
import com.prompt.resume.model.talent.viewControl.OfficeCtrl;

/**
 * author ：hm
 * date : 2019/9/4 18:25
 * package：com.prompt.resume.model.talent.ui.fragment
 * description :职位
 */
public class OfficeFrag extends BaseFragment {

    private OfficeCtrl officeCtrl;

    public static OfficeFrag newInstance() {

        Bundle args = new Bundle();

        OfficeFrag fragment = new OfficeFrag();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragOfficeBinding binding = DataBindingUtil.inflate(inflater, R.layout.frag_office, null, false);
        officeCtrl = new OfficeCtrl(binding);
        binding.setViewCtrl(officeCtrl);
        return binding.getRoot();

    }
}
