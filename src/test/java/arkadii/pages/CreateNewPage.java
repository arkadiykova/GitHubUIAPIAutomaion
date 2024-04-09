package arkadii.pages;

import arkadii.utils.common.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewPage {

    public CreateNewPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='Box-sc-g0xbh4-0 lhFvfi']//input")
    public WebElement newFileName;

    @FindBy(xpath = "//div[@class='Box-sc-g0xbh4-0 cpPHtE']//div[@tabindex='0']//div[@class='cm-content']")
    public WebElement newFileBody;

    @FindBy (xpath = "//div[@class='Box-sc-g0xbh4-0 cnECWi']//button")
    public WebElement commitChangesNewFile;

    @FindBy(xpath = "//div[@class='Box-sc-g0xbh4-0 hMoAGa']//button[2]")
    public WebElement getCommitChangesNewFileConfirm;

    @FindBy(xpath = "(//div[@class='Box-sc-g0xbh4-0 yfPnm']//a)[2]")
    public WebElement newlyCreatedFile;


}
