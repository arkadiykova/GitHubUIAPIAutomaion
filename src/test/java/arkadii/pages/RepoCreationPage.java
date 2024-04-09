package arkadii.pages;

import arkadii.utils.common.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RepoCreationPage {
 

    
    public RepoCreationPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



    @FindBy(id = ":r1:")
    public List<WebElement> chooseOwner;


    @FindBy(id=":rq:--label")
    public WebElement ownerMe;

    @FindBy(id=":r3:")
    public WebElement repoName;

    @FindBy(id = ":r4:")
    public WebElement repoDescription;

    @FindBy(id = ":r19:")
    public WebElement privateRepo;
    @FindBy(id = ":r6:")
    public WebElement publicRepo;

    @FindBy(xpath = "//button[@class='types__StyledButton-sc-ws60qy-0 gariCr']")
    public WebElement createRepo;



}
