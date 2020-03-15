package com.rs.demo.basemvp.base;

import android.util.Log;

import com.rs.demo.basemvp.bean.BaseResult;

import io.reactivex.observers.DisposableObserver;

public abstract  class  BaseObserver<T> extends DisposableObserver<BaseResult<T>> {

    public abstract <T> void onSucc(T value);

    public void onFail(Throwable e){
        Log.e("TAG", "onFail: " );
    }

    @Override
    public void onNext(BaseResult<T> value) {
        onSucc(value.getResult());
    }


    @Override
    public void onError(Throwable e) {
        onFail(e);
    }

    @Override
    public void onComplete() {
        Log.e("TAG", "onFail: " );
    }
}
