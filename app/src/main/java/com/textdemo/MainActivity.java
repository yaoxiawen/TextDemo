package com.textdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv1 = findViewById(R.id.tv1);
        TextView tv2 = findViewById(R.id.tv2);
        tv1.setText(getSpannableStringBuilder("文字中间变换颜色",2,6,"#ff0000"));
        tv2.setText(getSpannableStringBuilder2("文字中间变换大小",2,6,12));
    }

    private SpannableStringBuilder getSpannableStringBuilder(String finalStr, int start, int end,
            String color) {
        SpannableStringBuilder style = new SpannableStringBuilder(finalStr);
        style.setSpan(new ForegroundColorSpan(Color.parseColor(color)), start, end,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return style;
    }

    private SpannableStringBuilder getSpannableStringBuilder2(String finalStr, int start, int end,
            int size) {
        SpannableStringBuilder style = new SpannableStringBuilder(finalStr);
        style.setSpan(new AbsoluteSizeSpan(size, true), start, end,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return style;
    }
}
