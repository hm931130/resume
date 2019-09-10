package com.prompt.resume;

import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.github.mzule.activityrouter.annotation.Router;
import com.prompt.resume.common.BundleKeys;
import com.prompt.resume.common.RouterUrl;
import com.prompt.resume.common.ui.BaseActivity;
import com.prompt.resume.common.ui.BaseRecyclerViewCtrl;
import com.prompt.resume.model.talent.ui.fragment.MineFrag;
import com.prompt.resume.model.talent.ui.fragment.OfficeFrag;
import com.prompt.resume.model.talent.ui.fragment.TalentFrag;
import com.prompt.resume.utils.ActivityManage;

import me.yokeyword.fragmentation.SupportFragment;


@Router(value = RouterUrl.AppCommon_Main, intParams = BundleKeys.TYPE)
public class MainActivity extends BaseActivity {
    private BottomNavigationView navigationView;
    public static final int FIRST = 0;  //主页 找人才
    public static final int SECOND = 1; // 职位
    public static final int THIRD = 2;  //我的

    //tab Index
    private static final int TAB_MENU_TALENT = R.id.menu_item_talent;
    private static final int TAB_MENU_OFFICE = R.id.menu_item_office;
    private static final int TAB_MENU_MINE = R.id.menu_item_me;
    private SupportFragment[] mFragments = new SupportFragment[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = (BottomNavigationView) findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        adjustNavigationIcoSize(navigationView);

        initFragments();

    }

    private void initFragments() {


        SupportFragment firstFragment = findFragment(TalentFrag.class);
        if (firstFragment == null) {
            mFragments[FIRST] = TalentFrag.newInstance();
            mFragments[SECOND] = OfficeFrag.newInstance();
            mFragments[THIRD] = MineFrag.newInstance();
            loadMultipleRootFragment(R.id.fl_container, FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND],
                    mFragments[THIRD]
            );
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题
            // 这里我们需要拿到mFragments的引用
            mFragments[FIRST] = firstFragment;
            mFragments[SECOND] = findFragment(OfficeFrag.class);
            mFragments[THIRD] = findFragment(MineFrag.class);
        }
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case TAB_MENU_TALENT:
                        showHideFragment(mFragments[FIRST]);
                        break;
                    case TAB_MENU_OFFICE:
                        showHideFragment(mFragments[SECOND]);
                        break;
                    case TAB_MENU_MINE:
                        showHideFragment(mFragments[THIRD]);
                        break;
                    default:
                        showHideFragment(mFragments[FIRST]);
                        break;
                }
                return true;
            }
        });

    }

    private void adjustNavigationIcoSize(BottomNavigationView navigation) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) navigation.getChildAt(0);
        for (int i = 0; i < menuView.getChildCount(); i++) {
            final View iconView = menuView.getChildAt(i).findViewById(android.support.design.R.id.icon);

            final ViewGroup.LayoutParams layoutParams = iconView.getLayoutParams();
            final DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            layoutParams.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 23, displayMetrics);
            layoutParams.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 23, displayMetrics);
            iconView.setLayoutParams(layoutParams);
        }
    }

    @Override
    public void onBackPressedSupport() {
        if (getFragmentManager().getBackStackEntryCount() > 1) {
            pop();
        } else {
            ActivityManage.onExit();
        }
    }
}
