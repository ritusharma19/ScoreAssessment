package testRunner;

import com.Utilities.DriverManager;
import com.Utilities.GlobalParams;
import com.Utilities.ServerManager;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"steps"},
        tags = "@FindPlayerTeamLeague",
        plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        })

public class myTestRunner {


        @BeforeClass
        public static void initialize() throws Exception {
                GlobalParams params = new GlobalParams();
                params.initializeGlobalParams();
                new ServerManager().startServer();
                new DriverManager().initializeDriver();
        }

        @AfterClass
        public static void quit(){
                DriverManager driverManager = new DriverManager();
                if(driverManager.getDriver() != null){
                        driverManager.getDriver().quit();
                        driverManager.setDriver(null);
                }
                ServerManager serverManager = new ServerManager();
                if(serverManager.getServer() != null){
                        serverManager.getServer().stop();
                }
        }
}
