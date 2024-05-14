package com.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Homepage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.ImageButton")
    //@iOSXCUITFindBy (id = "com.fivemobile.thescore:id/action_button_text")
    private WebElement profileIcon;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.fivemobile.thescore:id/navigation_bar_item_icon_view\"])[1]")
    private WebElement newsTab;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.fivemobile.thescore:id/navigation_bar_item_icon_view\"])[2]")
    private WebElement scoresTab;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.fivemobile.thescore:id/navigation_bar_item_icon_view\"])[3]")
    private WebElement fvtTab;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.fivemobile.thescore:id/navigation_bar_item_icon_view\"])[4]")
    private WebElement betTab;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.fivemobile.thescore:id/navigation_bar_item_icon_view\"])[5]")
    private WebElement leaguesTab;

    @AndroidFindBy(id = "com.fivemobile.thescore:id/search_bar_text_view")
    private WebElement search;

    @AndroidFindBy(id = "com.fivemobile.thescore:id/search_src_text")
    private WebElement searchTextInput;



    public boolean isHomePageDisplayed() throws InterruptedException {
        Thread.sleep(100000);
        if(driver.findElements(By.xpath("//android.widget.TextView[@text=\"Ok, Got It\"]")).size()>0){
            click(driver.findElement(By.xpath("//android.widget.TextView[@text=\"Ok, Got It\"]")));
        }
        return isElementDisplayed(profileIcon) && isElementDisplayed(newsTab) && isElementDisplayed(scoresTab)
        && isElementDisplayed(fvtTab) && isElementDisplayed(betTab) && isElementDisplayed(leaguesTab);
    }

    public void searchTeam(String teamName) throws InterruptedException {

        Thread.sleep(100000);
        if((driver.findElements(By.id("com.fivemobile.thescore:id/dismiss_modal")).size())!=0){
            click(driver.findElement(By.id("com.fivemobile.thescore:id/dismiss_modal")));
        }

        click(search);
        sendKeys(searchTextInput,teamName);
        click(driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/txt_name\" and @text='"+teamName+"']")));
    }

    public boolean isSearchBarVisible(){
        return isElementDisplayed(searchTextInput);
    }


}
