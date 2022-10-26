package seamlesslyS3.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import seamlesslyS3.utility.Driver;

import java.util.concurrent.TimeUnit;

import static seamlesslyS3.utility.Driver.driver;

public class Hooks {

    @Before
    public void setup(){
        driver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver().manage().window().maximize();
    }

    @After
    public void teardownScenario(Scenario scenario){


        //scenario.isFailed() --> if scenario fails this method will return TRUE boolean value


        if (scenario.isFailed()){

        byte [] screenshot = ((TakesScreenshot)driver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());

        }


        // BrowserUtils.sleep(3);
        Driver.closeDriver(2);

        //System.out.println("====Closing browser using cucumber @After");
        //System.out.println("====Scenario ended/ Take screenshot if failed!");
    }

}
