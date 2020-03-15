package com.rs.demo.basemvp.envConfig;

/**
 * 环境配置
 *
 */
public abstract class EnvConfig {
    private static Stage stage = Stage.PROD;
    public static EnvConfig instance() {
        switch (stage) {
            case DEV:
                //测试环境
                return new DevConfig();
            case PROD:
                //生产环境
                return new ProdConfig();
            case PRE:
                //预发布
                return new PreConfig();
            default:
                return null;
        }
    }

    public abstract String getWebServiceBaseUrl();

    public abstract String getWebSocketBaseUrl();

    public abstract String getEnvName();
    public abstract String getShopMailBaseUrl();

    public  abstract String getWyPayUrl();
    public abstract String getMlhBaseUrl();

    public enum Stage {
        DEV, PROD, SHIJINJIN, PRE ,YUNJIN
}
}
