package arkadii.step_defs.ui;

import arkadii.pages.*;
import arkadii.utils.ui.BrowserUtils;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class CrudUiRepoStepDefs {

    private DashboardPage dashboard;
    private RepoCreationPage repoCreationPage;
    private NewRepoPage newRepoPage;
    private SettingsPage settingsPage;
    private CreateNewPage createNewPage;
    private RepositoriesPage repositoriesPage;
    private Faker faker;
    private String repoName;
    private String description;
    private String newFileBodyText;
    private String expectedErrorMessageNoRepoYet;

    public CrudUiRepoStepDefs(){
        this.dashboard = new DashboardPage();
        this.repoCreationPage = new RepoCreationPage();
        this.newRepoPage = new NewRepoPage();
        this.settingsPage = new SettingsPage();
        this.createNewPage = new CreateNewPage();
        this.repositoriesPage = new RepositoriesPage();
        this.faker = new Faker();
        this.repoName = faker.name().firstName();
        this.description = faker.chuckNorris().fact();
        this.newFileBodyText = faker.gameOfThrones().character();
        this.expectedErrorMessageNoRepoYet = "ak1sdet doesn’t have any public repositories yet.";
    }



    @When("the user creates a new repository")
    public void the_user_creates_a_new_repository() {

//TODO create a method for this form page
        
        dashboard.addNewRepo.click();
        repoCreationPage.repoName.sendKeys(repoName);
        repoCreationPage.repoDescription.sendKeys(description);
        repoCreationPage.chooseOwner.get(0).click();
        repoCreationPage.publicRepo.click();
        BrowserUtils.scrollToElement(repoCreationPage.createRepo);
        repoCreationPage.createRepo.click();

    }

    @Then("the repository should be created successfully")
    public void the_repository_should_be_created_successfully() {

        assertTrue(repoCreationPage.repoName.isDisplayed());

    }

    @When("the user gets information about the repository")
    public void the_user_gets_information_about_the_repository() {

        assertTrue(newRepoPage.newRepoName.getText().contains(repoName));

    }

    @Then("the repository information should be retrieved successfully")
    public void the_repository_information_should_be_retrieved_successfully() {

        System.out.println("newRepoPage.repoLink.getAttribute(\"value\").toString() = " + newRepoPage.repoLink.getAttribute("value").toString());

    }

    @When("the user updates the repository")
    public void the_user_updates_the_repository() {

        newRepoPage.createNewFile.click();
        createNewPage.newFileName.sendKeys(repoName);
        createNewPage.newFileBody.click();
        createNewPage.newFileBody.sendKeys(newFileBodyText);
        createNewPage.commitChangesNewFile.click();
        createNewPage.getCommitChangesNewFileConfirm.click();
    }

    @Then("the repository should be updated successfully")
    public void the_repository_should_be_updated_successfully() {
        assertTrue(createNewPage.newlyCreatedFile.getText().equals(repoName));
    }

    @When("the user deletes the repository")
    public void the_user_deletes_the_repository() {

        BrowserUtils.waitForVisibility(dashboard.settings,5);
        dashboard.settings.click();
        BrowserUtils.scrollToElement(settingsPage.deleteThisRepo);
        settingsPage.deleteThisRepo.click();
        settingsPage.deleteConfirmation1.click();
        settingsPage.getDeleteConfirmation2.click();
        settingsPage.confirmMessage.click();
        settingsPage.confirmMessage.sendKeys("ak1sdet/"+repoName);
        settingsPage.submitDeletion.click();

    }

    @Then("the repository should be deleted successfully")
    public void the_repository_should_be_deleted_successfully() {

        dashboard.repositories.click();
        assertTrue(repositoriesPage.deletedRepo.getText().equals(expectedErrorMessageNoRepoYet));

    }

}
