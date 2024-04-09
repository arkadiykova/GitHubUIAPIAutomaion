package arkadii.pages;

import arkadii.utils.common.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    public DashboardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[@class='AppHeader-context-item-label  ']")
    public WebElement dashboard;

    @FindBy(xpath = "//a[@data-hydro-click-hmac='83ec38dcdff5268b8446a9225e659b41424641c5a2aaaa0a755b0232598531c6']")
    public WebElement addNewRepo;

    @FindBy(id = "settings-tab")
    public WebElement settings;

    @FindBy(id = "repositories-tab")
    public WebElement repositories;


 
    

}
