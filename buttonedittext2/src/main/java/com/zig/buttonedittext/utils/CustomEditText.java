package com.zig.buttonedittext.utils;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;

public class CustomEditText extends AppCompatEditText {


    public CustomEditText(Context context) {
        super(context);
        init(context);


    }

    public CustomEditText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);

    }

    public CustomEditText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);

    }

    void init(Context context) {
        if (!isInEditMode()) {
            try {
                setBackgroundColor(Color.parseColor("#ffffff"));
            } catch (Exception e) {
            }
        }

    }
}
