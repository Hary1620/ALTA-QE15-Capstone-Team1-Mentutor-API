package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.MentutorAPI;
import starter.utils.Constants;

import java.io.File;

public class UpdateProfileStepdef {
    @Steps
    MentutorAPI mentutorAPI;

    @Given("Update profile with valid data {string}")
    public void updateProfileWithValidData(String file) {
        File jsonFile = new File(Constants.JSON_SCHEMA + file);
        mentutorAPI.updateUser(jsonFile);
    }

    @When("Send request update profile mentor")
    public void sendRequestUpdateProfileMentor() {
        SerenityRest.when().put(MentutorAPI.UPDATE_USERS);
    }
}
