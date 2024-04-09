package arkadii.pages;

import arkadii.utils.common.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class LandingPage {

public LandingPage(){PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(xpath = "//div[@class='position-relative mr-lg-3 d-lg-inline-block']")
    public WebElement signIn;




}
