package com.rs.demo.demoactivity;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;

import com.rs.demo.R;
import com.rs.demo.basemvp.base.BaseActivity;

/**
 * Created by Rs on 2018/6/14.
 */



public class DemoActivity extends BaseActivity<DemoView, DemoPresenter> implements DemoView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        initData();
    }

    private void initData() {
        findViewById(R.id.startBt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            mPresenter.login(2);
            }
        });
    }

    @Override
    public void updata() {

    }

    @Override
    public void dismiss() {

    }
}
