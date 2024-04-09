package arkadii.pages;

import arkadii.utils.common.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage {

    public SettingsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



    @FindBy(xpath = "//span[.='Delete this repository']")
    public WebElement deleteThisRepo;

    @FindBy(id = "repo-delete-proceed-button-container")
    public WebElement deleteConfirmation1;

    @FindBy(xpath = "//span[.='I have read and understand these effects']")
    public WebElement getDeleteConfirmation2;

    @FindBy(id = "verification_field")
    public WebElement confirmMessage;

    @FindBy(id = "repo-delete-proceed-button")
    public WebElement submitDeletion;

}
