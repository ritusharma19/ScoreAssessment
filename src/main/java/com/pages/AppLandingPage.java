package com.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;


public class AppLandingPage extends BasePage {

    @AndroidFindBy(id = "com.fivemobile.thescore:id/icon_welcome")
    private WebElement welcomeIcon;

    @AndroidFindBy(id = "com.fivemobile.thescore:id/action_button_text")
    private WebElement getStartedBtn;

    @AndroidFindBy(id = "com.fivemobile.thescore:id/action_button_text")
    private WebElement continueBtn;

    @AndroidFindBy(id = "com.fivemobile.thescore:id/btn_disallow")
    private WebElement denyLocationBtn;

    @AndroidFindBy(id = "com.fivemobile.thescore:id/action_button_text")
    private WebElement continueBtnOnFvtTeams;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/txt_name\" and @text=\"Toronto Maple Leafs\"]")
    private WebElement selectFvtTeams;

    @AndroidFindBy(id = "com.fivemobile.thescore:id/btn_primary")
    private WebElement continueBtnOnNotifications;

    @AndroidFindBy(id = "com.fivemobile.thescore:id/btn_secondary")
    private WebElement signUpMayBeLater;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    private WebElement denyNotificationsPopup;


    public boolean checkWelcomeIcon() {
        return isElementDisplayed(welcomeIcon);
    }

    public void clickGetStartedBtn() {
        click(getStartedBtn);
    }

    public void clickContinueBtn() {
        click(continueBtn);
    }

    public void clickDenyLocationBtn() {
        click(denyLocationBtn);
    }

    public void selectTeamAndContinue() {
        click(selectFvtTeams);
        click(continueBtnOnFvtTeams);
    }

    public void clickContinueBtnOnNotifications() {
        click(continueBtnOnNotifications);
    }

    public void clickSignUpMayBeLater() {
        click(signUpMayBeLater);
    }

    public void clickDenyNotificationsPopUp() {
        click(denyNotificationsPopup);
    }


}

