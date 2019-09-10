package com.prompt.resume.utils;

import android.content.Context;

import com.prompt.resume.R;
import com.prompt.resume.views.PlaceholderLayout;


/**
 * Author: TinhoXu
 * E-mail: xth@erongdu.com
 * Date: 2017/1/6 14:16
 * <p/>
 * Description: placeholder 工具类
 */
public class PlaceholderHelper {
    /**
     * 空页 - 暂无消息
     */
    public final static int EMPTY_WISHLIST = 0x103;
    /**
     * 空页 - 暂无公告
     */
    public final static int EMPTY_NOTICE = 0x104;
    /**
     * 空页 - 暂无记录
     */
    public final static int EMPTY_RECORD = 0x106;
    /**
     * 空页 - 暂无银行卡
     */
    public final static int EMPTY_CARD = 0x107;
    /**
     * 空页 - 暂无邀请记录
     */
    public final static int EMPTY_INVITE_RECORD = 0x108;
    /**
     * 普通用户优惠券空白页
     */
    public static final int EMPTY_COUPON = 0x109;
    /**
     * Vip用户优惠券空白页
     */
    public static final int EMPTY_COUPON_VIP = 0x110;

    /**
     * 上下文
     */
    private Context context;

    private PlaceholderHelper() {
        context = ContextHolder.getContext();
    }

    public static PlaceholderHelper getInstance() {
        return PlaceholderHelperInstance.instance;
    }

    private static class PlaceholderHelperInstance {
        static PlaceholderHelper instance = new PlaceholderHelper();
    }

    public void setStatus(PlaceholderLayout layout, int status) {
        switch (status) {
            case PlaceholderLayout.SUCCESS:
            case PlaceholderLayout.ERROR:
            case PlaceholderLayout.NO_NETWORK:
            case PlaceholderLayout.LOADING:
                layout.setStatus(status);
                return;
//
//            case EMPTY_COUPON_VIP:
//                layout.setEmptyText(context.getString(R.string.placeholder_empty_coupon));
//                layout.setEmptyImage(R.drawable.no_wish_large);
//                break;
            case PlaceholderLayout.EMPTY:
            default:
                layout.setEmptyText(context.getString(R.string.placeholder_empty));
                layout.setEmptyImage(R.drawable.placeholder_empty);
                break;
        }
        layout.setStatus(PlaceholderLayout.EMPTY);
    }
}
