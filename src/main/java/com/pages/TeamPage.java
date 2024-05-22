package com.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TeamPage extends BasePage {

    @AndroidFindBy(id = "com.fivemobile.thescore:id/team_logo")
    //@iOSXCUITFindBy (id = "com.fivemobile.thescore:id/action_button_text")
    private WebElement teamIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/team_name\"]")
    private WebElement teamName;

    @AndroidFindBy(accessibility = "Roster")
    private WebElement rosterTab;

    @AndroidFindBy(id = "com.fivemobile.thescore:id/cta")
    private WebElement teamPayrollBtn;

    @AndroidFindBy(accessibility = "Navigate up")
    private WebElement back;

//    @AndroidFindBy(xpath = "//android.widget.TextView[contains(text(),\"Toronto Raptors\")]")
//    private WebElement teamData;

    @AndroidFindBy(xpath = "android.widget.TextView[@text=\"Toronto Raptors 2024-25 Financial Summary\"]")
    private WebElement teamData;
//    @AndroidFindBy(xpath = "//*[text()[contains(.,'Toronto Raptors')]]")
//    private WebElement teamData;


    public boolean isTeamIconDisplayed(){
        return isElementDisplayed(teamIcon);
    }

    public String getTeamName(){
        return getText(teamName);
    }

    public void selectSubTab(){
        click(rosterTab);
    }

    public void clickPayroll(){
        click(teamPayrollBtn);
    }

    public boolean teamData(String teamName) throws InterruptedException {
       // Thread.sleep(50000);
        //android.widget.TextView[@text="Toronto Raptors 2024-25 Financial Summary"]
        if (isElementDisplayed(teamData))
      //  if(driver.findElements(By.xpath("//android.widget.TextView[contains(text(),'"+teamName+"')]")).size()>0)
            return true;
        else return false;
    }

    public void clickBack(){
        click(back);
    }


}
