package com.prompt.resume.model.talent.viewControl;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.StringUtils;
import com.prompt.resume.R;
import com.prompt.resume.database.SearchHosTable;
import com.prompt.resume.database.SearchHosTable_Table;
import com.prompt.resume.databinding.ActSearchBinding;
import com.prompt.resume.model.talent.viewModel.SearchVM;
import com.prompt.resume.utils.Util;
import com.prompt.resume.views.flowlayout.FlowLayout;
import com.prompt.resume.views.flowlayout.TagAdapter;
import com.prompt.resume.views.popupWindow.CommonPopupWindow;
import com.raizlabs.android.dbflow.sql.language.OrderBy;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

/**
 * author ：hm
 * date : 2019/9/5 15:38
 * package：com.prompt.resume.model.talent.viewControl
 * description :
 */
public class SearchCtrl implements View.OnKeyListener, TextWatcher {
    private SearchVM searchVM;
    private ActSearchBinding binding;


    public SearchVM getSearchVM() {
        return searchVM;
    }

    public SearchCtrl(ActSearchBinding binding, int termsCount) {
        this.binding = binding;
        searchVM = new SearchVM();
        List<SearchHosTable> tableList = SQLite.select().from(SearchHosTable.class).where().orderBy(SearchHosTable_Table.timeStamp, false)
                .limit(10).queryList();
        searchVM.setSearchHisCount(tableList.size());
        searchVM.setTermsCount(termsCount);
        if (tableList.size() > 0) {
            fillHistoryData(tableList);
        }
        binding.keyEt.setOnKeyListener(this);
        binding.keyEt.addTextChangedListener(this);
    }


    private void fillHistoryData(List<SearchHosTable> tableList) {
        binding.flowLayout.setAdapter(new TagAdapter<SearchHosTable>(tableList) {
            @Override
            public View getView(FlowLayout parent, int position, SearchHosTable obj) {
                TextView textView = (TextView) LayoutInflater.from(Util.getActivity(binding.getRoot())).inflate(R.layout.item_selected_tv, parent, false);
                textView.setText(obj.getKeyStr());
                return textView;
            }
        });
    }

    public void cancleClick(View view) {
        Util.getActivity(view).finish();
    }

    public void removeAllClick(View view) {
        SQLite.delete().from(SearchHosTable.class).execute();
        searchVM.setTiptitleVis(View.VISIBLE);
        searchVM.setSearchHisVis(View.GONE);
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
            if (!StringUtils.isEmpty(searchVM.getKeyStr())) {
                SearchHosTable table = new SearchHosTable();
                table.setKeyStr(searchVM.getKeyStr());
                table.setTimeStamp(System.currentTimeMillis());
                table.save();
                Util.getActivity(binding.getRoot()).finish();
                return true;
            } else {
                return false;
            }

        }
        return false;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (!TextUtils.isEmpty(s.toString())) {
            searchVM.setCategoryVis(View.VISIBLE);
        } else {
            searchVM.setCategoryVis(View.GONE);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
