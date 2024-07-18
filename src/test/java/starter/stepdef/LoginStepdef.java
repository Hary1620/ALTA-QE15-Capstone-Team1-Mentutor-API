package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.mentutor.MentutorAPI;
import starter.mentutor.MentutorResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class LoginStepdef {
    @Steps
    MentutorAPI mentutorAPI;

    @Given("Login mentor with valid account {string}")
    public void loginMentorWithValidAccount(String file) {
        File jsonFile = new File(Constants.REQ_BODY + file);
        mentutorAPI.loginMentor(jsonFile);
    }

    @When("Send request login mentor")
    public void sendRequestLoginMentor() {
        SerenityRest.when().post(MentutorAPI.LOGIN_MENTOR);
    }

    @And("Response body name should be {string}")
    public void responseBodyDataShouldBeToken(String name) {
        SerenityRest.and().body("data.name",equalTo(name));
    }
}
