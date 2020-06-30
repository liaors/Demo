package com.rs.demo.basemvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.lang.reflect.ParameterizedType;

/**
 * Created by Rs on 2018/6/14.
 */
public abstract class BaseActivity<V extends BaseView,P extends BasePresenter> extends AppCompatActivity implements BaseView {
 protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter(this,1);
        mPresenter.attachView(this);

    }


    public P createPresenter(BaseActivity<V, P> vtBaseActivity, int i) {
      ParameterizedType type = (ParameterizedType) vtBaseActivity.getClass().getGenericSuperclass();//获取泛型的父类（含泛型参数）
      Class<P> tClass = (Class<P>) type.getActualTypeArguments()[i];//获取第i个泛型类的真实类型
        try {
            return tClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       mPresenter.dettachView();
    }

    @Override
    public void dismiss() {

    }
}
