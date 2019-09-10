package com.prompt.resume.model.talent.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.prompt.resume.R;
import com.prompt.resume.utils.Util;

import java.util.List;

/**
 * author ：hm
 * date : 2019/9/6 14:26
 * package：com.prompt.resume.model.talent.adapter
 * description :
 */
public class CommonKeyAdapter extends BaseAdapter {
    private Context context;
    private List<String> list;
    private int checkItemPosition = 0;

    public void setCheckItem(int position) {
        checkItemPosition = position;
        notifyDataSetChanged();
    }


    public CommonKeyAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView != null) {
            viewHolder = (ViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_default_drop_down, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        fillValue(position, viewHolder);
        return convertView;
    }

    private void fillValue(int position, ViewHolder viewHolder) {
        viewHolder.mText.setText(list.get(position));
        if (checkItemPosition != -1) {
            if (checkItemPosition == position) {
                viewHolder.mText.setTextColor(context.getResources().getColor(R.color.color_white));
                viewHolder.mText.setBackground(ContextCompat.getDrawable(context, R.drawable.drawable_drop_down_selected));
            } else {
                viewHolder.mText.setTextColor(context.getResources().getColor(R.color.text_gray));
                viewHolder.mText.setBackground(ContextCompat.getDrawable(context, R.drawable.drawable_drop_down_unselected));
            }
        }
    }

    static class ViewHolder {
        TextView mText;

        ViewHolder(View view) {
            mText = view.findViewById(R.id.text);
        }
    }
}
