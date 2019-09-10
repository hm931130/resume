package com.prompt.resume.views;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;

/**
 * author ：hm
 * date : 2019/9/3 14:19
 * package：com.prompt.resume.views
 * description :
 */
public class HightlightEditTextView extends AppCompatEditText implements TextWatcher {
    public HightlightEditTextView(Context context) {
        this(context, null);
    }

    public HightlightEditTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HightlightEditTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        addTextChangedListener(this);
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
