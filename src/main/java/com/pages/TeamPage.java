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

    public boolean teamData(String teamName){
        if(driver.findElements(By.xpath("//android.widget.TextView[contains(text(),'"+teamName+"')]")).size()>0)
            return true;
        else return false;
    }

    public void clickBack(){
        click(back);
    }


}
