package com.prompt.resume.model.talent.viewControl;

import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.prompt.resume.BR;
import com.prompt.resume.MainActivity;
import com.prompt.resume.R;
import com.prompt.resume.common.MyApplication;
import com.prompt.resume.common.SwipeListener;
import com.prompt.resume.common.ui.BaseRecyclerViewCtrl;
import com.prompt.resume.common.ui.BaseRecyclerViewVM;
import com.prompt.resume.databinding.ActSearchResultBinding;
import com.prompt.resume.databinding.LayoutSearchResultBinding;
import com.prompt.resume.model.talent.adapter.CommonKeyAdapter;
import com.prompt.resume.model.talent.adapter.KeyTermAdapter;
import com.prompt.resume.model.talent.viewModel.SearchResultItemVM;
import com.prompt.resume.utils.ToastUtil;
import com.prompt.resume.utils.Util;
import com.prompt.resume.views.DividerLine;
import com.prompt.resume.views.DropDownMenu;
import com.prompt.resume.views.PlaceholderLayout;
import com.zaaach.citypicker.CityPicker;
import com.zaaach.citypicker.adapter.OnPickListener;
import com.zaaach.citypicker.model.City;
import com.zaaach.citypicker.model.HotCity;
import com.zaaach.citypicker.model.LocateState;
import com.zaaach.citypicker.model.LocatedCity;
import com.zaaach.citypicker.model.RecentCity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.tatarka.bindingcollectionadapter.ItemView;

/**
 * author ：hm
 * date : 2019/9/6 10:41
 * package：com.prompt.resume.model.talent.viewControl
 * description :
 */
public class SearchResultCtrl extends BaseRecyclerViewCtrl implements DropDownMenu.OnTabClickListener {

    private ActSearchResultBinding binding;
    private KeyTermAdapter keyTermAdapter;
    private String headers[] = {"城市", "工作经验", "学历要求"};
    private String yearsLimit[] = {"不限", "1年以下", "1-3年", "3-5年", "5-10年", "10年以上"};
    private String educations[] = {"不限", "高中及以上", "专科及以上", "本科及以上", "硕士及以上"};
    private List<View> popupViews = new ArrayList<>();

    private CommonKeyAdapter yearsAdapter;
    private CommonKeyAdapter educationAdapter;

    private List<HotCity> hotCities;
    private List<RecentCity> recentCities;


    //声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient = null;
    //声明定位回调监听器
    public AMapLocationListener mLocationListener = new LocationChangeListener();


    public SearchResultCtrl(ActSearchResultBinding binding) {
        this.binding = binding;

        hotCities = new ArrayList<>();
        hotCities.add(new HotCity("北京", "北京", "101010100"));
        hotCities.add(new HotCity("上海", "上海", "101020100"));
        hotCities.add(new HotCity("深圳", "广东", "101280601"));
        hotCities.add(new HotCity("广州", "广东", "101280101"));
        hotCities.add(new HotCity("杭州", "浙江", "101210101"));
        hotCities.add(new HotCity("南京", "江苏", "101210101"));
        hotCities.add(new HotCity("苏州", "江苏", "101210101"));
        hotCities.add(new HotCity("天津", "天津", "101210101"));
        hotCities.add(new HotCity("重庆", "重庆", "101210101"));
        hotCities.add(new HotCity("武汉", "湖北", "101210101"));

        recentCities = new ArrayList<>();
        recentCities.add(new RecentCity("北京", "北京", "101010100"));
        recentCities.add(new RecentCity("上海", "上海", "101020100"));
        recentCities.add(new RecentCity("深圳", "广东", "101280601"));
        initLocation();

        keyTermAdapter = new KeyTermAdapter(R.layout.item_key_term, Arrays.asList("我", "我是谁", "我是你的", "艾弗森所所所"));
        binding.keyListView.setLayoutManager(new LinearLayoutManager(Util.getActivity(binding.getRoot()), LinearLayoutManager.HORIZONTAL, false));
        binding.keyListView.setAdapter(keyTermAdapter);

        binding.dropDownMenu.setOnTabClickListener(this);


        viewModel.set(new BaseRecyclerViewVM<SearchResultItemVM>() {
            @Override
            protected void selectView(ItemView itemView, int position, SearchResultItemVM item) {
                itemView.set(BR.item, R.layout.item_list_search_result);
            }
        });

        viewModel.get().type = DividerLine.DEFAULT;
        placeholderListener = new PlaceholderLayout.OnReloadListener() {
            @Override
            public void onReload(View v) {

            }
        };

        listener.set(new SwipeListener() {
            @Override
            public void swipeInit(SwipeToLoadLayout swipeLayout) {
                setSwipeLayout(swipeLayout);
            }

            @Override
            public void refresh() {

            }

            @Override
            public void loadMore() {

            }
        });
        initGridViews();
    }

    private void initLocation() {

        //初始化定位
        mLocationClient = new AMapLocationClient(MyApplication.getInstance());

        //设置定位回调监听
        mLocationClient.setLocationListener(mLocationListener);

        //初始化AMapLocationClientOption对象
        AMapLocationClientOption option = new AMapLocationClientOption();
        /**
         * 设置定位场景，目前支持三种场景（签到、出行、运动，默认无场景）
         */
        option.setLocationPurpose(AMapLocationClientOption.AMapLocationPurpose.SignIn);
        //设置定位模式为AMapLocationMode.Hight_Accuracy，高精度模式。
        option.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
//        //设置定位模式为AMapLocationMode.Battery_Saving，低功耗模式。
//        option.setLocationMode(AMapLocationClientOption.AMapLocationMode.Battery_Saving);
//        //设置定位模式为AMapLocationMode.Device_Sensors，仅设备模式。
//        option.setLocationMode(AMapLocationClientOption.AMapLocationMode.Device_Sensors);
        //获取一次定位结果：
        //该方法默认为false。
        option.setOnceLocation(true);

        //获取最近3s内精度最高的一次定位结果：
        //设置setOnceLocationLatest(boolean b)接口为true，启动定位时SDK会返回最近3s内精度最高的一次定位结果。如果设置其为true，setOnceLocation(boolean b)接口也会被设置为true，反之不会，默认为false。
        option.setOnceLocationLatest(true);
        //设置定位间隔,单位毫秒,默认为2000ms，最低1000ms。
        option.setInterval(1000);
        //设置是否返回地址信息（默认返回地址信息）
        option.setNeedAddress(true);
        //设置是否允许模拟位置,默认为true，允许模拟位置
        option.setMockEnable(true);
        //单位是毫秒，默认30000毫秒，建议超时时间不要低于8000毫秒。
        option.setHttpTimeOut(20000);
        //关闭缓存机制
        option.setLocationCacheEnable(false);
        if (null != mLocationClient) {
            mLocationClient.setLocationOption(option);
            //设置场景模式后最好调用一次stop，再调用start以保证场景模式生效
            mLocationClient.stopLocation();
//            mLocationClient.startLocation();
        }
    }

    private void initGridViews() {

        //工作经验
        final View yearsView = Util.getActivity(binding.getRoot()).getLayoutInflater().inflate(R.layout.custom_gridview, null);
        GridView yearsGridView = yearsView.findViewById(R.id.gridView);
        yearsAdapter = new CommonKeyAdapter(Util.getActivity(binding.getRoot()), Arrays.asList(yearsLimit));
        yearsGridView.setAdapter(yearsAdapter);
        yearsGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                yearsAdapter.setCheckItem(position);
                binding.dropDownMenu.setTabText(position == 0 ? headers[1] : yearsLimit[position]);
                binding.dropDownMenu.closeMenu();
            }
        });


        //教育水平
        final View educationView = Util.getActivity(binding.getRoot()).getLayoutInflater().inflate(R.layout.custom_gridview, null);
        GridView educationGridView = educationView.findViewById(R.id.gridView);
        educationAdapter = new CommonKeyAdapter(Util.getActivity(binding.getRoot()), Arrays.asList(educations));
        educationGridView.setNumColumns(3);
        educationGridView.setAdapter(educationAdapter);
        educationGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                educationAdapter.setCheckItem(position);
                binding.dropDownMenu.setTabText(position == 0 ? headers[2] : educations[position]);
                binding.dropDownMenu.closeMenu();
            }
        });


        View view = new View(Util.getActivity(binding.getRoot()));
        popupViews.add(view);
        popupViews.add(yearsView);
        popupViews.add(educationView);

        //init context view

        LayoutSearchResultBinding listBinding = DataBindingUtil.inflate(LayoutInflater.from(Util.getActivity(binding.getRoot())), R.layout.layout_search_result, null, false);
        listBinding.setViewCtrl(this);
//        View contentView = LayoutInflater.from(Util.getActivity(binding.getRoot())).inflate(R.layout.layout_search_result, null);
        //init dropdownview
        binding.dropDownMenu.setDropDownMenu(Arrays.asList(headers), popupViews, listBinding.getRoot());
    }

    public void backPressed() {
        if (binding.dropDownMenu.isShowing()) {
            binding.dropDownMenu.closeMenu();
            return;
        }
    }

    public void cancleClick(View view) {
        backPressed();
    }

    public class LocationChangeListener implements AMapLocationListener {

        @Override
        public void onLocationChanged(AMapLocation amapLocation) {
            if (amapLocation != null) {
                if (amapLocation.getErrorCode() == 0) {
                    //可在其中解析amapLocation获取相应内容。
//                    Log.e("AmapError", "city=" + amapLocation.getCity());
//                    ToastUtil.toast(amapLocation.getCity());

                    CityPicker.from((FragmentActivity) Util.getActivity(binding.getRoot())).locateComplete(new LocatedCity(amapLocation.getCity(), amapLocation.getProvince(), amapLocation.getCityCode()), LocateState.SUCCESS);

                } else {
                    //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                    Log.e("AmapError", "location Error, ErrCode:"
                            + amapLocation.getErrorCode() + ", errInfo:"
                            + amapLocation.getErrorInfo());
                }
            }
        }
    }

    @Override
    public void tabClick(int position) {
        if (position == 0) {
            if (null != mLocationClient) {
                mLocationClient.startLocation();
            }

            CityPicker.from((FragmentActivity) Util.getActivity(binding.getRoot()))
                    .enableAnimation(true)
                    .setAnimationStyle(R.style.DefaultCityPickerAnimation)
                    .setLocatedCity(null)
                    .setHotCities(hotCities)
                    .setRecentCities(recentCities)
                    .setOnPickListener(new OnPickListener() {
                        @Override
                        public void onPick(int position, City data) {
//                            currentTV.setText(String.format("当前城市：%s，%s", data.getName(), data.getCode()));
//                            Toast.makeText(
//                                    getApplicationContext(),
//                                    String.format("点击的数据：%s，%s", data.getName(), data.getCode()),
//                                    Toast.LENGTH_SHORT)
//                                    .show();
                            ToastUtil.toast(data.getName());
                            backPressed();
                        }

                        @Override
                        public void onCancel() {
                            backPressed();
                            ToastUtil.toast("取消选择");
                        }

                        @Override
                        public void onLocate() {
                            //开始定位，这里模拟一下定位
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
//                                    CityPicker.from((FragmentActivity) Util.getActivity(binding.getRoot())).locateComplete(new LocatedCity("深圳", "广东", "101280601"), LocateState.SUCCESS);
                                }
                            }, 3000);
                        }
                    })
                    .show();
        }
    }
}

