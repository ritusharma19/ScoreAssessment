package com.Utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.io.IOException;

public class DriverManager {
    private static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    public AppiumDriver getDriver(){
        return driver.get();
    }

    public void setDriver(AppiumDriver driver2){
        driver.set(driver2);
    }

    public void initializeDriver() throws Exception {
        AppiumDriver driver = null;
        GlobalParams params = new GlobalParams();

        try{
            System.out.println("Initializing Appium driver");
            switch(params.getPlatformName()){
                case "Android":
                    driver = new AndroidDriver(new ServerManager().getServer().getUrl(), new CapabilitiesManager().getCaps());
                    break;
                case "iOS":
                    driver = new IOSDriver(new ServerManager().getServer().getUrl(), new CapabilitiesManager().getCaps());
                    break;
            }
            if(driver == null){
                throw new Exception("Driver is null");
            }
            System.out.println("Driver is initialized");
            DriverManager.driver.set(driver);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Driver initialization failed" + e);
            throw e;
        }

    }

}
