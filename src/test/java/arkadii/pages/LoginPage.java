package arkadii.pages;

import arkadii.utils.common.ConfigReader;
import arkadii.utils.common.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends LandingPage{


    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(partialLinkText = "Sign in")
    public WebElement signIn;
    @FindBy(xpath = "//input[@name='login']")
    public WebElement userName;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@value='Sign in']")
    public WebElement signInButton;

    public  void login(){
        signIn.click();
        userName.sendKeys(ConfigReader.getProperty("user_name"));
        password.sendKeys(ConfigReader.getProperty("user_password"));
        signInButton.click();

    }
}
