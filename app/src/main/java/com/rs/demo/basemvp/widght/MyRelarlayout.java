package com.rs.demo.basemvp.widght;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Created by Rs on 2018/7/23.
 */

public class MyRelarlayout extends RelativeLayout {
 public static final String TAG = "TAG";
    public MyRelarlayout(Context context) {
        super(context, null);
    }

    public MyRelarlayout(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public MyRelarlayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "dispatchTouchEvent: "+ "myrelativelayout_ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "dispatchTouchEvent: "+ "myrelativelayout_ACTION_UP");
                break;
        }
    return super.dispatchTouchEvent(ev);
  // return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "onInterceptTouchEvent: "+ "myrelativelayout_ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "onInterceptTouchEvent: "+ "myrelativelayout_ACTION_UP");
                break;
        }
     //return super.onInterceptTouchEvent(ev);
     return true;

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "onTouchEvent: "+ "myrelativelayout_ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "onTouchEvent: "+ "myrelativelayout_ACTION_UP");
                break;
        }
        return super.onTouchEvent(event);
    }
}
