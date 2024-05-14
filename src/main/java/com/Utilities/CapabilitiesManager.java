package com.Utilities;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class CapabilitiesManager {

    public DesiredCapabilities getCaps() throws IOException {
        GlobalParams params = new GlobalParams();
        Properties props = new ConfigReader().initializeProp();

        try{
            System.out.println("getting capabilities");
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, params.getPlatformName());
            caps.setCapability(MobileCapabilityType.UDID, params.getUDID());
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, params.getDeviceName());
            caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,120);

            switch(params.getPlatformName()){
                case "Android":
                    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("androidAutomationName"));
                    caps.setCapability("appPackage", props.getProperty("androidAppPackage"));
                    caps.setCapability("appActivity", props.getProperty("androidAppActivity"));
                    String androidAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                  + File.separator + "resources" +  File.separator + "theScore.apk";
                    System.out.println("appUrl is : " + androidAppUrl);
                    caps.setCapability("app", androidAppUrl);
                    break;
                case "iOS":
                    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("iOSAutomationName"));
                    String iOSAppUrl = getClass().getResource(props.getProperty("iOSAppLocation")).getFile();
                    System.out.println("appUrl is" + iOSAppUrl);
                    caps.setCapability("bundleId", props.getProperty("iOSBundleId"));
                    caps.setCapability("app", iOSAppUrl);
                    break;
            }
            return caps;
        } catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}
