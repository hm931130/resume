package com.prompt.resume.common.binding;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.blankj.utilcode.util.AppUtils;
import com.bumptech.glide.Glide;
import com.prompt.resume.R;
import com.prompt.resume.common.Constant;
import com.prompt.resume.common.SwipeListener;
import com.prompt.resume.utils.ConverterUtil;
import com.prompt.resume.utils.PlaceholderHelper;
import com.prompt.resume.utils.RegularUtil;
import com.prompt.resume.utils.Util;
import com.prompt.resume.views.DividerLine;
import com.prompt.resume.views.PlaceholderLayout;
import com.prompt.resume.views.appbar.ToolBar;

import java.io.File;

/**
 * Created by Administrator on 2019/4/3.
 */

public class BindingAdapters {


    /**
     * 为RecyclerView添加分割线
     *
     * @param type 水平 - HORIZONTAL = 0;
     *             垂直 - VERTICAL = 1;
     *             十字 - CROSS = 9;
     */
    @BindingAdapter({"addItemDecoration"})
    public static void addItemDecoration(RecyclerView view, int type) {
        DividerLine dividerLine;
        switch (type) {
            case DividerLine.HORIZONTAL:
                dividerLine = new DividerLine(DividerLine.HORIZONTAL);
                dividerLine.setMarginStart(20);
                view.addItemDecoration(dividerLine);
                break;

            case DividerLine.VERTICAL:
                dividerLine = new DividerLine(DividerLine.VERTICAL);
                view.addItemDecoration(dividerLine);
                break;

            case DividerLine.CROSS:
                dividerLine = new DividerLine(DividerLine.CROSS);
                view.addItemDecoration(dividerLine);
                break;

            case Constant.NUMBER_2:
                dividerLine = new DividerLine(DividerLine.HORIZONTAL);
                view.addItemDecoration(dividerLine);
                break;

            case DividerLine.DEFAULT:
            default:
                break;
        }
    }

    @BindingAdapter(value = "url")
    public static void setUrl(ImageView imageView, String url) {
        if (!TextUtils.isEmpty(url)) {
            Glide.with(Util.getActivity(imageView)).load(url)
                    .centerCrop().dontAnimate().into(imageView);
        }
    }


    /**
     * 配置下拉刷新事件
     */
    @BindingAdapter(value = {"listener"})
    public static void listener(final SwipeToLoadLayout layout, SwipeListener listener) {
        if (listener != null) {
            LayoutInflater mInflater = (LayoutInflater) layout.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // 设置头部、底部加载刷新控件
            layout.setRefreshHeaderView(mInflater.inflate(R.layout.swipe_twitter_header, layout, false));
            layout.setLoadMoreFooterView(mInflater.inflate(R.layout.swipe_twitter_footer, layout, false));
            layout.setSwipeStyle(SwipeToLoadLayout.STYLE.CLASSIC);
            layout.setLoadMoreEnabled(true);
            layout.post(new Runnable() {
                @Override
                public void run() {
                    layout.setRefreshing(true);
                }
            });

            if (layout.getChildCount() >= 2) {
                for (int i = 0; i < layout.getChildCount(); i++) {
                    View tClass = layout.getChildAt(i);
                    if (tClass instanceof RecyclerView) {// 判断滑动布局是否为recyclerView，添加自动加载事件
                        ((RecyclerView) tClass).setOnScrollListener(new RecyclerView.OnScrollListener() {
                            @Override
                            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                                    if (!ViewCompat.canScrollVertically(recyclerView, 2)) {
                                        layout.setLoadingMore(true);
                                    }
                                }
                            }
                        });
                        break;
                    } else if (tClass instanceof ListView) {// 判断滑动布局是否为ListView，添加自动加载事件
                        ((ListView) tClass).setOnScrollListener(new AbsListView.OnScrollListener() {
                            @Override
                            public void onScrollStateChanged(AbsListView view, int scrollState) {
                                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                                    if (view.getLastVisiblePosition() == view.getCount() - 1 && !ViewCompat.canScrollVertically(view, 1)) {
                                        layout.setLoadingMore(true);
                                    }
                                }
                            }

                            @Override
                            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                            }
                        });
                        break;
                    } else if (tClass instanceof ScrollView) {// 判断滑动布局是否为ScrollView，添加自动加载事件
                        final ScrollView scrollView = ((ScrollView) tClass);
                        layout.setLoadMoreEnabled(false);
                        scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
                            @Override
                            public void onScrollChanged() {
                                if (scrollView.getChildAt(0).getHeight() < scrollView.getScrollY() + scrollView.getHeight() && !ViewCompat
                                        .canScrollVertically(scrollView, 1)) {
                                    layout.setLoadingMore(true);
                                }
                            }
                        });
                        break;
                    }
                }
            }

            // 添加响应事件方法
            layout.setOnLoadMoreListener(listener);
            layout.setOnRefreshListener(listener);
            // 初始化刷新方法类
            listener.swipeInit(layout);
        }
    }

    /**
     * 为RecyclerView设置adapter
     */
    @BindingAdapter({"recyclerAdapter"})
    public static void recyclerViewAdapter(RecyclerView view, RecyclerView.Adapter adapter) {
        if (null == view.getAdapter()) {
            view.setAdapter(adapter);
        } else {
            view.swapAdapter(adapter, true);
        }
    }

    /**
     * 空态图
     */
    @BindingAdapter(value = {"placeholderState", "placeholderListener"}, requireAll = false)
    public static void placeholderConfig(PlaceholderLayout layout, int state, PlaceholderLayout.OnReloadListener listener) {
        PlaceholderHelper.getInstance().setStatus(layout, state);
        if (null != listener) {
            layout.setOnReloadListener(listener);
        }
    }

    /**
     * 设置view是否显示
     */
    @BindingAdapter({"visibility"})
    public static void viewVisibility(View view, boolean visible) {
        if (visible) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
        }
    }

    /**
     * 为ImageView设置图片
     *
     * @param imageView    imageView
     * @param path         路径
     * @param defaultImage 默认图片
     * @param errorImage   加载失败图片
     */
    @BindingAdapter(value = {"src", "defaultImage", "errorImage"}, requireAll = false)
    public static void setImage(final ImageView imageView, String path, Drawable defaultImage, Drawable errorImage) {
        Context context = imageView.getRootView().getContext();
        try {
            System.gc();
            if (null == errorImage) {
                errorImage = ContextCompat.getDrawable(context, R.drawable.place_holder);
            }
            if (TextUtils.isEmpty(path)) {
                if (defaultImage != null) {
                    imageView.setImageDrawable(defaultImage);
                } else {
                    imageView.setImageDrawable(errorImage);
                }
            } else {
                if (RegularUtil.isNumeric(path)) {
                    if (null == defaultImage) {
                        Glide.with(context).load(ConverterUtil.getInteger(path)).thumbnail(0.1f).error(errorImage).into(imageView);
                    } else {
                        Glide.with(context).load(ConverterUtil.getInteger(path)).thumbnail(0.1f).placeholder(defaultImage).error(errorImage).into(imageView);
                    }
                } else {
                    if (null == defaultImage) {
                        Glide.with(context).load(path).thumbnail(0.1f).error(errorImage).into(imageView);
                    } else {
                        Glide.with(context).load(path).thumbnail(0.1f).placeholder(defaultImage).error(errorImage).into(imageView);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @BindingAdapter(value = "imgPath")
    public static void setImgPath(ImageView imageView, String path) {
        File file = new File(path);
        Context context = imageView.getContext();
        Glide.with(context).load(file).into(imageView);
    }

    @BindingAdapter(value = "apkName")
    public static void setApkName(ImageView imageView, String apkName) {
        AppUtils.AppInfo appInfo = AppUtils.getAppInfo(apkName);
        imageView.setImageDrawable(appInfo.getIcon());
    }

    @BindingAdapter({"bg"})
    public static void setBgImage(ImageView imageView, int bgSource) {
        imageView.setBackgroundResource(bgSource);
    }

    @BindingAdapter({"titleText"})
    public static void titleText(ToolBar toolBar, String title) {
        if (null == title) {
            title = "";
        }
        toolBar.setTitle(title);
    }

    @BindingAdapter("userLimit")
    public static void couponUserLimit(TextView textView, String desc) {
        textView.setText(Html.fromHtml(desc));
    }

    @BindingAdapter("textFlag")
    public static void textFlag(TextView textView, String str) {
        textView.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
    }
}
