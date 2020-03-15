package com.rs.demo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Rs on 2018/6/25.
 */

public class ChartView extends View {
    private int bgColor;
    private int xylinecolor;
    private int xytextcolor;
    private int linecolor;
    private int bgcolor;
    private int xylinewidth;
    private int xytextsize;
    private int interval;
    private boolean isScroll = false;
    private Paint xyPaint, xyTextPaint, linePaint;
    private int width, height, xori, yori;
    private double textwidth;

    public ChartView(Context context) {
        super(context);
    }

    public ChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
        initPaint();
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.chartView, defStyleAttr, 0);
        int count = typedArray.getIndexCount();
        xylinecolor = typedArray.getColor(R.styleable.chartView_linecolor, Color.GRAY);
        xylinewidth = typedArray.getInt(R.styleable.chartView_xylinewidth, 5);
        xytextcolor = typedArray.getColor(R.styleable.chartView_xytextcolor, Color.BLACK);
        xytextsize = typedArray.getLayoutDimension(R.styleable.chartView_xytextsize, 20);
        linecolor = typedArray.getColor(R.styleable.chartView_linecolor, Color.GRAY);
        interval = typedArray.getLayoutDimension(R.styleable.chartView_interval, 100);
        bgColor = typedArray.getColor(R.styleable.chartView_bgcolor, Color.WHITE);
        typedArray.recycle();
        // x_coords=new ArrayList<String>();
        // x_coord_values=new ArrayList<String>();
    }


    /**
     * 初始化畫筆
     */
    private void initPaint() {
        xyPaint = new Paint();
        xyPaint.setAntiAlias(true);
        xyPaint.setStrokeWidth(xylinewidth);
        xyPaint.setStrokeCap(Paint.Cap.ROUND);
        xyPaint.setColor(xylinecolor);

        xyTextPaint = new Paint();
        xyTextPaint.setAntiAlias(true);
        xyTextPaint.setTextSize(xytextsize);
        xyTextPaint.setStrokeCap(Paint.Cap.ROUND);
        xyTextPaint.setColor(xytextcolor);
        xyTextPaint.setStyle(Paint.Style.STROKE);

        linePaint = new Paint();
        linePaint.setAntiAlias(true);
        linePaint.setStrokeWidth(xylinewidth);
        linePaint.setStrokeCap(Paint.Cap.ROUND);
        linePaint.setColor(linecolor);
        linePaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (changed) {
            width = getWidth();
            height = getHeight();
            Paint paint = new Paint();
            paint.setTextSize(xytextsize);
            textwidth = paint.measureText("A");
            xori = (int) (textwidth + 6 + 2 * xylinewidth);//6 为与y轴的间隔
            yori = height - xytextsize - 2 * xylinewidth - 3;//3为x轴的间隔
            int xinit = interval / 2 + xori;
            setBackgroundColor(bgColor);
        }
        super.onLayout(changed, left, top, right, bottom);
    }
}
