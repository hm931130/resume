package com.prompt.resume.model.talent.ui.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.github.mzule.activityrouter.annotation.Router;
import com.prompt.resume.R;
import com.prompt.resume.common.BundleKeys;
import com.prompt.resume.common.RouterUrl;
import com.prompt.resume.common.ui.BaseActivity;
import com.prompt.resume.databinding.ActSearchBinding;
import com.prompt.resume.model.talent.viewControl.SearchCtrl;

/**
 * author ：hm
 * date : 2019/9/5 15:38
 * package：com.prompt.resume.model.talent.ui.activity
 * description : 搜索页
 */
@Router(value = RouterUrl.SEARCH_KEY,intParams = {BundleKeys.TERMSCOUNT})
public class SearchAct extends BaseActivity {

    private SearchCtrl searchCtrl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActSearchBinding binding = DataBindingUtil.setContentView(this, R.layout.act_search);
        searchCtrl = new SearchCtrl(binding,getIntent().getIntExtra(BundleKeys.TERMSCOUNT,0));
        binding.setViewCtrl(searchCtrl);
    }
}
