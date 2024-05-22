package steps;

import com.pages.BasePage;
import com.Utilities.DriverManager;
import io.cucumber.java.Scenario;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;

public class Hooks {


    BasePage basePage = new BasePage();
    @Before
    public void initialize() {
        basePage.closeApp();
        basePage.launchApp();
    }

    @After
    public void quit(Scenario scenario) {
        basePage.uninstallApp();
        if (scenario.isFailed()) {
            byte[] screenshot = new DriverManager().getDriver().getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }
}
