package starter.Mentee.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.Mentee.MenteeAPI;
import starter.Mentor.mentutor.MentorAPI;
import starter.utils.Constants;

import java.io.File;

public class UpdateMenteeStepdef {
    @Steps
    MenteeAPI menteeAPI;

    @Given("Update profile mentee with valid data {string}")
    public void updateProfileMenteeWithValidData(String file) {
        File jsonFile = new File(Constants.REQ_BODY + file);
        menteeAPI.updateMentee(jsonFile);
    }

    @When("Send request update profile mentee")
    public void sendRequestUpdateProfileMentee() {
        SerenityRest.when().put(MenteeAPI.UPDATE_USERS);
    }

}
