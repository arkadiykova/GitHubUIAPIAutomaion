package arkadii.pages;

import arkadii.utils.common.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewRepoPage {

    public NewRepoPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }




    @FindBy(xpath = "//strong//a")
    public WebElement newRepoName;

    @FindBy(xpath = "//input[@id='empty-setup-clone-url']")
    public WebElement repoLink;

    @FindBy(xpath = "//p[@class='mb-0']//a[1]")
    public WebElement createNewFile;


}
