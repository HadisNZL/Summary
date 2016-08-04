package com.example.hadis.summary.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * @author hadis on 16.4.28.
 */
public class MyRecyclerView extends RecyclerView {

    public MyRecyclerView(android.content.Context context) {
        super(context);
    }

    public MyRecyclerView(android.content.Context context, android.util.AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        /**
         * 设置不滚动
         */
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);

        super.onMeasure(widthSpec, expandSpec);
    }
}
