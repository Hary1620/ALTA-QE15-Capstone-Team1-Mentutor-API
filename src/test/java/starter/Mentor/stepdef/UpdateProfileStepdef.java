package starter.Mentor.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Mentor.mentutor.MentorAPI;
import starter.utils.Constants;

import java.io.File;

public class UpdateProfileStepdef {
    @Steps
    MentorAPI mentorAPI;

    @Given("Update profile with valid data {string}")
    public void updateProfileWithValidData(String file) {
        File jsonFile = new File(Constants.JSON_SCHEMA + file);
        mentorAPI.updateUser(jsonFile);
    }

    @When("Send request update profile mentor")
    public void sendRequestUpdateProfileMentor() {
        SerenityRest.when().put(MentorAPI.UPDATE_USERS);
    }

    @Given("Update profile with invalid type data {string}")
    public void updateProfileWithInvalidTypeData(String arg0) {
    }

    @Given("Update profile with invalid input data {string}")
    public void updateProfileWithInvalidInputData(String arg0) {
    }
}
