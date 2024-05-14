package com.Utilities;

import java.util.Properties;

public class GlobalParams {

    private static final ThreadLocal<String> platformName = new ThreadLocal<String>();
    private static final ThreadLocal<String> udid = new ThreadLocal<String>();
    private static final ThreadLocal<String> deviceName = new ThreadLocal<String>();

    public void setPlatformName(String platformName1){
        platformName.set(platformName1);
    }

    public String getPlatformName(){
        return platformName.get();
    }

    public String getUDID() {
        return udid.get();
    }

    public void setUDID(String udid2) {
        udid.set(udid2);
    }

    public String getDeviceName() {
        return deviceName.get();
    }

    public void setDeviceName(String deviceName2) {
        deviceName.set(deviceName2);
    }


    public void initializeGlobalParams(){
        GlobalParams params = new GlobalParams();
        Properties props = new ConfigReader().initializeProp();
        params.setPlatformName(props.getProperty("platformName"));
        params.setUDID(props.getProperty("udid"));
        params.setDeviceName(props.getProperty("deviceName"));

    }
}
