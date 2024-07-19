package starter.Mentor.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Mentor.mentutor.MentorAPI;
import starter.utils.Constants;

import java.io.File;

public class UpdateProfileStepdef {
    @Steps
    MentorAPI mentorAPI;

    @Given("Update profile with valid data {string} {string} {string} {string}")
    public void updateProfileWithValidData(String name, String email, String password, String images) {
        mentorAPI.updateUser(name,email, password, images);
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
