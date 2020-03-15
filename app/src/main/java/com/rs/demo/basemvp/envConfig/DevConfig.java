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


}
