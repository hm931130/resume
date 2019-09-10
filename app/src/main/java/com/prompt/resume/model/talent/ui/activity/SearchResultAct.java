package com.prompt.resume.model.talent.ui.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.github.mzule.activityrouter.annotation.Router;
import com.prompt.resume.R;
import com.prompt.resume.common.BundleKeys;
import com.prompt.resume.common.RouterUrl;
import com.prompt.resume.common.ui.BaseActivity;
import com.prompt.resume.databinding.ActSearchResultBinding;
import com.prompt.resume.model.talent.viewControl.SearchResultCtrl;

/**
 * author ：hm
 * date : 2019/9/6 10:41
 * package：com.prompt.resume.model.talent.ui.activity
 * description :搜索结果页面
 */
@Router(value = RouterUrl.SEARCH_RESULT)
public class SearchResultAct extends BaseActivity {

    private SearchResultCtrl ctrl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActSearchResultBinding binding = DataBindingUtil.setContentView(this, R.layout.act_search_result);
        ctrl = new SearchResultCtrl(binding);
        binding.setViewCtrl(ctrl);
    }


    @Override
    public void onBackPressedSupport() {
        ctrl.backPressed();
        super.onBackPressedSupport();
    }

}
