package arkadii.step_defs;

import arkadii.pages.DashboardPage;
import arkadii.pages.LoginPage;
import arkadii.utils.common.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginStepDefs {

    private WebDriverWait wait;
    private LoginPage loginPage;
    private DashboardPage dashboard;

    public LoginStepDefs(){
        this.wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        this.loginPage = new LoginPage();
        this.dashboard = new DashboardPage();
    }


    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        wait.until(ExpectedConditions.titleContains("GitHub"));
    }


    @Given("the user logged in")
    public void the_user_logged_in() {

        loginPage.login();
    }


    @Then("user is able to access the home page")
    public void user_is_able_to_access_the_home_page() {
        wait.until(ExpectedConditions.titleContains("GitHub"));
        assertTrue(dashboard.dashboard.isDisplayed());
    }

}
