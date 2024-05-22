package steps;

import com.pages.AppLandingPage;
import com.pages.Homepage;
import com.pages.TeamPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import testRunner.myTestRunner;

public class ApplicationSteps {

    AppLandingPage appLandingPage=new AppLandingPage();
    Homepage homepage = new Homepage();
    TeamPage teamPage = new TeamPage();

    @Given("theScore Application is installed and the user navigated till Homepage")
    public void the_score_application_is_installed_and_open() {
        Assert.assertTrue(appLandingPage.checkWelcomeIcon());
        appLandingPage.clickGetStartedBtn();
        appLandingPage.clickContinueBtn();
        appLandingPage.clickDenyLocationBtn();
        appLandingPage.selectTeamAndContinue();
        appLandingPage.clickContinueBtnOnNotifications();
        appLandingPage.clickSignUpMayBeLater();
        appLandingPage.clickDenyNotificationsPopUp();

    }
    @When("The user is on HomeScreen")
    public void the_user_is_on_home_screen() throws InterruptedException {
        Assert.assertTrue(homepage.isHomePageDisplayed());

    }
    @When("The user searches for {string}")
    public void the_user_searches_for(String team) throws InterruptedException {
        homepage.searchTeam(team);

    }
    @Then("Verify expected page opens correctly for {string}")
    public void verify_expected_page_opens_correctly(String team) {
        Assert.assertTrue(teamPage.isTeamIconDisplayed());
        Assert.assertEquals(teamPage.getTeamName(),team);

    }

    @When("The user selects subTab and Verify Correct data for {string} is displayed")
    public void theUserSelectsSubTabAndVerifyCorrectDataForIsDisplayed(String teamName) throws InterruptedException {
        teamPage.selectSubTab();
        teamPage.clickPayroll();
        Assert.assertTrue(teamPage.teamData(teamName));

    }


    @And("The user navigates back to Team Page")
    public void theUserNavigatesBackToTeamPage() throws InterruptedException {
        teamPage.clickBack();
        Assert.assertTrue(teamPage.isTeamIconDisplayed());
        teamPage.clickBack();
        Assert.assertTrue(homepage.isSearchBarVisible());
        teamPage.clickBack();
        Assert.assertTrue(homepage.isHomePageDisplayed());
    }
}
