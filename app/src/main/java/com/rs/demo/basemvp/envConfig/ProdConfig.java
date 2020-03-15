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

}
