package com.textdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv1 = findViewById(R.id.tv1);
        TextView tv2 = findViewById(R.id.tv2);
        tv1.setText(getSpannableStringBuilder("文字中间变换颜色", 2, 6, "#ff0000"));
        tv2.setText(getSpannableStringBuilder2("文字中间变换大小", 2, 6, 12));
        //自适应长度
        autofit();
        //使用autofitTextView
        autofitTextView();
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

    private void autofit() {
        TextView tv3 = findViewById(R.id.tv3);
        TextView tv4 = findViewById(R.id.tv4);
        //15sp文字大小
        SpannableStringBuilder stringBuilder = getSpannableStringBuilder2("自适应测试自适应测试", 5, 10, 12);
        tv3.setText(stringBuilder);
        int spec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        tv3.measure(spec, spec);
        int textWidth = tv3.getMeasuredWidth();
        //自适应到100dp长度
        if (textWidth < dp2px(100)) {
            tv4.setText(stringBuilder);
        } else {
            float radio = dp2px(100) * 1.0f / textWidth;
            int bigSize = (int) (15 * radio);
            int smallSize = (int) (12 * radio);
            tv4.setTextSize(bigSize);
            tv4.setText(getSpannableStringBuilder2("自适应测试自适应测试", 5, 10, smallSize));
        }
    }

    private void autofitTextView() {
        //autofitTextView不适用于文案内有多种字体大小的
        TextView tv5 = findViewById(R.id.tv5);
        tv5.setText("AutofitTextView自适应测试");
    }

    public static int dp2px(float dpValue) {
        return (int) (0.5f + dpValue * Resources.getSystem().getDisplayMetrics().density);
    }
}
