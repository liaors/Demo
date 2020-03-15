package com.rs.demo.basemvp.base;

import android.support.annotation.CallSuper;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Rs on 2018/6/14.
 */

public class BasePresenter<V extends BaseVeiw>  {
    protected V mView;
    protected CompositeDisposable compositeDisposable;

    @CallSuper
    public void attachView(V view) {
        mView = view;
    }
    @CallSuper
    public void dettachView() {
        clearDisposables();
        mView = null;
    }

    @CallSuper
    protected <T> void request(Observable<T> observable , DisposableObserver<T> observer){
        if(compositeDisposable == null){
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(observer));
    }

    @CallSuper
    private void clearDisposables(){
        if(compositeDisposable !=null){
            compositeDisposable.clear();
        }
    }
}
