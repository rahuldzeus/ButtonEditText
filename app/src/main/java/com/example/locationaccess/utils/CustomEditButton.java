package com.example.locationaccess.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

import com.example.locationaccess.R;

import java.util.EventListener;

public class CustomEditButton extends LinearLayout {
    String editTextHint;

    Integer editBackground;
    private OnButtonClickListener mListener;
    private OnValueChangeListener mOnValueChangeListener;
    EditText customEditText;


    public CustomEditButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOrientation(LinearLayout.VERTICAL);
        LayoutInflater.from(context).inflate(R.layout.customview, this, true);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomView, 0, 0);

        try {
            editTextHint = a.getString(R.styleable.CustomView_editTextTitle);
            editBackground = a.getInteger(R.styleable.CustomView_editBackground, Color.RED);
        } finally {
            a.recycle();
        }

        init(editTextHint, editBackground);
    }


    // Setup views
    private void init(String editTextHint, Integer editBackground) {
        customEditText = (EditText) findViewById(R.id.tvCustomEditText);
        final ImageView customButton = (ImageView) findViewById(R.id.btnCustomButton);
        customButton.setClickable(true);
        customEditText.setHint(editTextHint);
        setOnButtonClickListener(mListener);
        setOnValueChangeListener(mOnValueChangeListener);


        customButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonCall(true);
            }
        });

        customEditText.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                callValueListener(customEditText.getText().toString());

            }
        });
        customEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                callValueListener(s.toString());
            }
        });
    }

    private void callListener(View view) {
        if (mListener != null) {
            mListener.onClick(view);
        }
    }

    private void callValueListener(String value) {
        if (mOnValueChangeListener != null) {
            mOnValueChangeListener.onValueChange(value);
        }
    }

    public void setOnButtonClickListener(OnButtonClickListener onClickListener) {
        this.mListener = onClickListener;
    }


    @FunctionalInterface
    public interface OnButtonClickListener {
        void onClick(View view);
    }

    public void setButtonCall(boolean notifyListener) {

        if (notifyListener) {
            callListener(this);
        }
    }

    public interface OnValueChangeListener {
        void onValueChange(String value);
    }

    public void setOnValueChangeListener(OnValueChangeListener onValueChangeListener) {
        mOnValueChangeListener = onValueChangeListener;
    }


}
