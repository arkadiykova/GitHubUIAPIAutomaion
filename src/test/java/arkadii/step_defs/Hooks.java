package arkadii.step_defs;


import arkadii.utils.common.ConfigReader;
import arkadii.utils.common.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import java.time.Duration;

public class Hooks {

    @Before("ui")
    public void sutup(){
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @After("ui")
    public void teardown(Scenario scenario){
        if(scenario.isFailed()){
            byte[] screeshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screeshot,"image/png",scenario.getName());
        }


        Driver.closeDriver();
    }

}
