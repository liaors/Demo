package com.rs.demo.basemvp.envConfig;

/**
 * 预发布
 */

public class PreConfig extends EnvConfig {


    @Override
    public String getWebServiceBaseUrl() {
        return "http://172.29.10.64:9090/";
    }



    @Override
    public String getWebSocketBaseUrl() {
        return "ws://172.29.10.64:9090/";
    }


    @Override
    public String getEnvName() {
        return "pre";
    }

}
