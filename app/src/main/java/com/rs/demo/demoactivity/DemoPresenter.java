package com.rs.demo.demoactivity;

import android.util.Log;

import com.rs.demo.basemvp.Api;
import com.rs.demo.basemvp.base.BaseObserver;
import com.rs.demo.basemvp.base.BasePresenter;
import com.rs.demo.basemvp.bean.LoginBean;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class DemoPresenter extends BasePresenter<DemoView> {

    public void login(int type) {
        Map<String, Object> params = new HashMap<>();
        params.put("loginName", "18018747581");
        params.put("password", "123456");
        request(Api.INSTANCE.getServiceInterface().login(2, params), new BaseObserver<LoginBean>() {
            @Override
            public <LoginBean> void onSucc(LoginBean loginBean) {
                Log.e("TAG", "onSucc: " );
            }
        });
    }
}
