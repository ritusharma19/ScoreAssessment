package com.pages;

import com.Utilities.DriverManager;
import com.Utilities.GlobalParams;
import io.appium.java_client.*;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static java.time.Duration.*;

public class BasePage {
    AppiumDriver driver;

    public BasePage() {
        this.driver = new DriverManager().getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void waitForVisibility(WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(90));
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public boolean isElementDisplayed(WebElement e) {
        waitForVisibility(e);
        return e.isDisplayed();
    }

    public void clear(WebElement e) {
        waitForVisibility(e);
        e.clear();
    }

    public void click(WebElement e) {
        waitForVisibility(e);
        e.click();
    }


    public void sendKeys(WebElement e, String txt) {
        waitForVisibility(e);
        e.sendKeys(txt);
    }


    public String getAttribute(WebElement e, String attribute) {
        waitForVisibility(e);
        return e.getAttribute(attribute);
    }

    public String getText(WebElement e) {
        String txt;
        switch (new GlobalParams().getPlatformName()) {
            case "Android":
                txt = getAttribute(e, "text");
                break;
            case "iOS":
                txt = getAttribute(e, "label");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + new GlobalParams().getPlatformName());
        }
        return txt;
    }

    public void launchApp() {
        switch (new GlobalParams().getPlatformName()) {
            case "Android":
                ((InteractsWithApps) driver).activateApp(driver.getCapabilities().
                        getCapability("appPackage").toString());
                break;
            case "iOS":
                ((InteractsWithApps) driver).activateApp(driver.getCapabilities().
                        getCapability("bundleId").toString());
        }
    }


    public void closeApp() {
        switch (new GlobalParams().getPlatformName()) {
            case "Android":
                ((InteractsWithApps) driver).terminateApp(driver.getCapabilities().
                        getCapability("appPackage").toString());
                break;
            case "iOS":
                ((InteractsWithApps) driver).terminateApp(driver.getCapabilities().
                        getCapability("bundleId").toString());
        }
    }


    public void uninstallApp() {
        switch (new GlobalParams().getPlatformName()) {
            case "Android":
                ((InteractsWithApps) driver).removeApp(driver.getCapabilities().
                        getCapability("appPackage").toString());
                break;
            case "iOS":
                ((InteractsWithApps) driver).removeApp(driver.getCapabilities().
                        getCapability("bundleId").toString());
        }
    }

}