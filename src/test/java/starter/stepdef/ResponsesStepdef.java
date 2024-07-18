package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.mentutor.MentutorAPI;
import starter.utils.Constants;

import java.io.File;

public class ResponsesStepdef {
    @Steps
    MentutorAPI mentutorAPI;

    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }
    @And("Validate json schema should be {string}")
    public void validateJsonSchemaShouldBe(String json) {
        File jsonFile = new File(Constants.JSON_SCHEMA + json);
        mentutorAPI.addTask(jsonFile);
    }
}
