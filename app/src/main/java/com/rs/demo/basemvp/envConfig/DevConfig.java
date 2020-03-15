package com.rs.demo.basemvp.envConfig;

/**
 * Created by Rs on 2017/4/28.
 */

public class DevConfig extends EnvConfig {

    @Override
    public String getWebServiceBaseUrl() {
        return "http://172.29.9.52:8888/";
    }

    @Override
    public String getWebSocketBaseUrl() {
        return "ws://172.29.9.52:8888/";
    }

    @Override
    public String getEnvName() {
        return "dev";
    }
    /*http://172.29.100.9/embedIndex?*/
  /*  http://serve.maoye.cn/embedIndex?*/
    @Override
    public String getShopMailBaseUrl() {
        return "http://172.29.100.9/embedIndex?";
    }

    @Override
    public String getWyPayUrl() {
        return "http://172.29.100.9/home/Wypay/wyLogin?shop_id=248";
    }

    @Override
    public String getMlhBaseUrl() {
        return "http://172.29.100.9/";
    }


}
