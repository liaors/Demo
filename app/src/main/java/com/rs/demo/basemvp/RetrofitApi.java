package com.rs.demo.basemvp;


import com.rs.demo.basemvp.envConfig.EnvConfig;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Rs on 2017/9/12.
 */

public enum RetrofitApi {
    INSTANCE;
    public RequestInterface requestInterface;
    private Retrofit retrofit;

    public RetrofitApi getDefaultRetrofit(){
        retrofit = new Retrofit.Builder()
            .baseUrl(EnvConfig.instance().getWebServiceBaseUrl())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(getHttpClient())
            .build();
        return INSTANCE;
}


    public RequestInterface getRequestInterface() {
        if(requestInterface !=null){
            return requestInterface;
        }
        if(retrofit == null){
            getDefaultRetrofit();
        }
        return requestInterface =  retrofit.create(RequestInterface.class);
    }


    private OkHttpClient getHttpClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        return httpClient.build();
    }


}
