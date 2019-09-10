package com.prompt.resume.model.talent.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.prompt.resume.R;

import java.util.List;

/**
 * author ：hm
 * date : 2019/9/6 10:59
 * package：com.prompt.resume.model.talent.adapter
 * description :
 */
public class KeyTermAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public KeyTermAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.key_text, item);
    }
}
