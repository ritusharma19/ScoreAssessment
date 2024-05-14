package com.Utilities;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class ServerManager {
    private static final ThreadLocal<AppiumDriverLocalService> server = new ThreadLocal<>();
    public AppiumDriverLocalService getServer(){
        return server.get();
    }

    public void startServer(){
        System.out.println("starting appium server");
        AppiumDriverLocalService server =  WindowsGetAppiumService();
        server.start();
        if(!server.isRunning()){
            System.out.println("Appium server not started");
            throw new AppiumServerHasNotBeenStartedLocallyException("Appium server not started");
        }
        ServerManager.server.set(server);
        System.out.println("Appium server started");
    }


    public AppiumDriverLocalService WindowsGetAppiumService() {
        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingAnyFreePort()
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE));


    }
}
