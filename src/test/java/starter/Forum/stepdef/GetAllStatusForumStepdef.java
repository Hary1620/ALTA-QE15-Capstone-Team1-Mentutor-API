package starter.Forum.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Forum.ForumAPI;
import starter.utils.Constants;

import java.io.File;

public class GetAllStatusForumStepdef {
    @Steps
    ForumAPI forumAPI;

    @Given("Get all status by mentor and mentee")
    public void getAllStatusByMentorAndMentee() {
        forumAPI.getAllStatus();
    }

    @When("Send request get all status")
    public void sendRequestGetAllStatus() {
        SerenityRest.when().get(forumAPI.GET_ALL_STATUS);
    }

    @Given("Add status on forum with data {string}")
    public void addStatusOnForumWithData(String file) {
        File fileJson = new File(Constants.REQ_BODY+file);
        forumAPI.createNewStatus(fileJson);
    }

    @When("Send request add status")
    public void sendRequestAddStatus() {
        SerenityRest.when().get(forumAPI.NEW_STATUS);
    }

    @And("Validate json schema {string}")
    public void validateJsonSchema(String fileName) {
            File jsonFile = new File(Constants.JSON_SCHEMA+fileName);
            SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
        }

}
