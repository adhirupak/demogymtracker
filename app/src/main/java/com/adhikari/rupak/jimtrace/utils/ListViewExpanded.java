package com.adhikari.rupak.jimtrace.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by {Rupak Adhikari} on 10/7/2015.
 */
public class ListViewExpanded extends ListView
{
    public ListViewExpanded(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        setDividerHeight(0);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        super.onMeasure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST));
    }
}