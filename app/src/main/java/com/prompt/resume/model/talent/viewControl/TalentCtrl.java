package com.prompt.resume.model.talent.viewControl;

import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mzule.activityrouter.router.Routers;
import com.prompt.resume.R;
import com.prompt.resume.common.BaseViewPagerFAdapter;
import com.prompt.resume.common.RouterUrl;
import com.prompt.resume.common.ui.BaseFragment;
import com.prompt.resume.databinding.FragTalentBinding;
import com.prompt.resume.model.talent.ui.fragment.IntentionFrag;
import com.prompt.resume.model.talent.ui.fragment.NoIntentionFrag;
import com.prompt.resume.model.talent.ui.fragment.PendingIntentionFrag;
import com.prompt.resume.utils.Util;
import com.prompt.resume.views.appbar.TitleBar;

import java.util.ArrayList;
import java.util.List;

/**
 * author ：hm
 * date : 2019/9/5 9:45
 * package：com.prompt.resume.model.talent.viewControl
 * description :
 */
public class TalentCtrl implements TabLayout.OnTabSelectedListener {

    private FragTalentBinding binding;

    private BaseViewPagerFAdapter baseViewPagerFAdapter;
    private List<Fragment> fragmentList = new ArrayList<>(3);
    private FragmentManager fragmentManager;

    public TalentCtrl(FragTalentBinding binding, FragmentManager fragmentManager) {
        this.binding = binding;
        this.fragmentManager = fragmentManager;
        binding.toolBar.addAction(new TitleBar.ImageAction(R.drawable.nav_search_large) {
            @Override
            public void performAction(View view) {
                Routers.open(Util.getActivity(view), String.format(RouterUrl.getRouterUrl(RouterUrl.SEARCH_KEY), 0));
            }
        });

        fragmentList.add(IntentionFrag.newInstance());
        fragmentList.add(PendingIntentionFrag.newInstance());
        fragmentList.add(NoIntentionFrag.newInstance());
        baseViewPagerFAdapter = new BaseViewPagerFAdapter(fragmentManager, fragmentList);
        baseViewPagerFAdapter.setPageTitles(new BaseViewPagerFAdapter.PageTitles() {
            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return "有意向";
                    case 1:
                        return "意向等待";
                    case 2:
                        return "无意向";
                    default:
                        return "有意向";
                }
            }
        });
        binding.viewpager.setAdapter(baseViewPagerFAdapter);
        binding.viewpager.setOffscreenPageLimit(fragmentList.size());
        binding.tabs.setupWithViewPager(binding.viewpager);
        binding.tabs.addOnTabSelectedListener(this);
        TextView title = (TextView) (((LinearLayout) ((LinearLayout) binding.tabs.getChildAt(0)).getChildAt(0)).getChildAt(1));
        title.setTextAppearance(Util.getActivity(binding.getRoot()), R.style.TabLayoutTextStyleBold);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        binding.viewpager.setCurrentItem(tab.getPosition());
        TextView title = (TextView) (((LinearLayout) ((LinearLayout) binding.tabs.getChildAt(0)).getChildAt(tab.getPosition())).getChildAt(1));
        title.setTextAppearance(Util.getActivity(binding.getRoot()), R.style.TabLayoutTextStyleBold);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        TextView title = (TextView) (((LinearLayout) ((LinearLayout) binding.tabs.getChildAt(0)).getChildAt(tab.getPosition())).getChildAt(1));
        title.setTextAppearance(Util.getActivity(binding.getRoot()), R.style.TabLayoutTextStyleNormal);
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
