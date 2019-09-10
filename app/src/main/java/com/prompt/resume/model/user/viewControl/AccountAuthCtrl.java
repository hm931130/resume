package com.prompt.resume.model.user.viewControl;

import android.view.View;

import com.github.mzule.activityrouter.router.Routers;
import com.prompt.resume.common.RouterUrl;
import com.prompt.resume.databinding.ActAccountAuthBinding;
import com.prompt.resume.utils.Util;

/**
 * author ：hm
 * date : 2019/9/3 19:20
 * package：com.prompt.resume.model.user.viewControl
 * description :
 */
public class AccountAuthCtrl {
    public AccountAuthCtrl(ActAccountAuthBinding binding) {
    }


    /**
     * 邀请码认证
     */
    public void invitationClick(View view) {
        Routers.open(Util.getActivity(view), RouterUrl.getRouterUrl(RouterUrl.INVITATION_AUTH));
    }

    /**
     * 企业认证
     */
    public void enterpriseClick(View view) {
        Routers.open(Util.getActivity(view), RouterUrl.getRouterUrl(RouterUrl.COMPANY_AUTH));
    }
}
