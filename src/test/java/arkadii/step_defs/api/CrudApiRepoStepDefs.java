package arkadii.step_defs.api;

import arkadii.utils.api.ApiUtil;
import arkadii.utils.common.ConfigReader;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import java.util.Map;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CrudApiRepoStepDefs {

     RequestSpecification givenPart;
     Response response;
     Map<String, Object> requestBody;
     Faker faker = new Faker();
   static String repoName;



    @Given("the user is authenticated for API")
    public void the_user_is_authenticated_for_api() {
       givenPart = given().log().ifValidationFails()
                .accept("application/vnd.github+json")
                .header("Authorization","Bearer "+ConfigReader.getProperty("git_token"))
               .header("X-GitHub-Api-Version","2022-11-28")
               .contentType(ContentType.JSON);


    }

    @When("the user sends a POST request to create a new repository")
    public void the_user_sends_a_post_request_to_create_a_new_repository() {

        requestBody = ApiUtil.getRequestBodyMap();


        response = givenPart.when()
                .body(requestBody)
                .post(ConfigReader.getProperty("git_uri")+"/user/repos");
                //.prettyPeek();

        repoName = requestBody.get("name").toString();
    }

    @Then("the repository should be successfully created")
    public void the_repository_should_be_successfully_created() {

        response.then()
                .statusCode(HttpStatus.SC_CREATED)
                .body("name",is(equalTo(repoName)));

    }

    @When("the user sends a GET request to retrieve repository information")
    public void the_user_sends_a_get_request_to_retrieve_repository_information() {
        givenPart
                .pathParams("owner",ConfigReader.getProperty("git_owner"),"repo",repoName)
                .when()
                .get(ConfigReader.getProperty("git_uri")+"/repos/{owner}/{repo}");

    }

    @Then("the repository information  retrieved successfully")
    public void the_repository_information_retrieved_successfully() {
        givenPart.then()
                .statusCode(HttpStatus.SC_OK);
    }

    @When("the user sends a PUT request to update the repository")
    public void the_user_sends_a_put_request_to_update_the_repository() {
        requestBody = ApiUtil.getRequestBodyMap();


        response = givenPart
                .pathParams("owner",ConfigReader.getProperty("git_owner"),"repo",repoName)
                .when()
                .body(requestBody)
                .patch(ConfigReader.getProperty("git_uri")+"/repos/{owner}/{repo}");

        repoName = requestBody.get("name").toString();
    }


    @Then("the repository should be successfully updated")
    public void the_repository_should_be_successfully_updated() {
        response.then()
                .statusCode(HttpStatus.SC_OK)
                .body("name",equalTo(repoName));
    }

    @Given("there is an existing repository")
    public void there_is_an_existing_repository() {
        givenPart
                .pathParams("owner",ConfigReader.getProperty("git_owner"),"repo",repoName)
                .when()
                .get(ConfigReader.getProperty("git_uri")+"/repos/{owner}/{repo}")
                .then()
                .statusCode(HttpStatus.SC_OK);


    }

    @When("the user sends a DELETE request to delete the repository")
    public void the_user_sends_a_delete_request_to_delete_the_repository() {
        givenPart
                .pathParams("owner",ConfigReader.getProperty("git_owner"),"repo",repoName)
                .when()
                .delete(ConfigReader.getProperty("git_uri")+"/repos/{owner}/{repo}")
                .then()
                .statusCode(HttpStatus.SC_NO_CONTENT);

    }

    @Then("the repository should be successfully deleted")
    public void the_repository_should_be_successfully_deleted() {

        givenPart
                .pathParams("owner",ConfigReader.getProperty("git_owner"),"repo",repoName)
                .when()
                .get(ConfigReader.getProperty("git_uri")+"/repos/{owner}/{repo}")
                .then()
                .statusCode(HttpStatus.SC_NOT_FOUND);

    }


}
