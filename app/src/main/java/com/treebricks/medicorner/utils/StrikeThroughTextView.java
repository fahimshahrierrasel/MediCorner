package com.treebricks.medicorner.utils;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;

public class StrikeThroughTextView extends android.support.v7.widget.AppCompatTextView {

    public StrikeThroughTextView(Context context) {
        super(context);
        strikeThrough();
    }

    public StrikeThroughTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        strikeThrough();
    }

    public StrikeThroughTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        strikeThrough();
    }

    private void strikeThrough() {
        setPaintFlags(getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }
}
