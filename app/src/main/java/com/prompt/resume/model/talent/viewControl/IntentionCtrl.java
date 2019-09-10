package com.prompt.resume.model.talent.viewControl;

import android.view.View;

import com.github.mzule.activityrouter.router.Routers;
import com.prompt.resume.common.RouterUrl;
import com.prompt.resume.databinding.FragIntentionBinding;
import com.prompt.resume.model.talent.viewModel.IntentionVM;
import com.prompt.resume.utils.Util;

/**
 * author ：hm
 * date : 2019/9/5 15:06
 * package：com.prompt.resume.model.talent.viewControl
 * description :
 */
public class IntentionCtrl  {
    private IntentionVM intentionVM;

    public IntentionVM getIntentionVM() {
        return intentionVM;
    }

    public IntentionCtrl(FragIntentionBinding binding) {
        intentionVM = new IntentionVM();
        intentionVM.setNodataShow(View.VISIBLE);
    }

    public void toSearchClick(View view) {
        Routers.open(Util.getActivity(view), String.format(RouterUrl.getRouterUrl(RouterUrl.SEARCH_RESULT), 1));
    }
}
