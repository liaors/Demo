package com.rs.demo.basemvp.envConfig;

/**
 * 生产
 */

public class ProdConfig extends EnvConfig {

    @Override
    public String getWebServiceBaseUrl() {
        return "https://uke.maoye.cn/";
    }

    @Override
    public String getWebSocketBaseUrl() {
        return "ws://uke.maoye.cn/";
    }

    @Override
    public String getEnvName() {
        return "pro";
    }

    @Override
    public String getShopMailBaseUrl() {
        return "http://itao.maoye.cn/embedIndex?";
    }

    @Override
    public String getWyPayUrl() {
        return "http://itao.maoye.cn/home/Wypay/WyEntrance?shop_id=240";
    }

    @Override
    public String getMlhBaseUrl() {
        return "http://itao.maoye.cn/";
    }
}
