package starter.Login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Mentor.mentutor.MentorAPI;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class LoginStepdef {
    @Steps
    MentorAPI mentorAPI;

    @Given("Login mentor with valid account {string}")
    public void loginMentorWithValidAccount(String file) {
        File jsonFile = new File(Constants.REQ_BODY + file);
        mentorAPI.loginMentor(jsonFile);

    }

    @When("Send request login mentor")
    public void sendRequestLoginMentor() {
        Response response = SerenityRest.when().post(MentorAPI.LOGIN_MENTOR);
        JsonPath jsonPath = response.jsonPath();
        String TOKEN = jsonPath.get("data.token");
        System.out.println(TOKEN);
        MentorAPI.TOKEN = TOKEN;
    }

    @And("Response body name should be {string}")
    public void responseBodyDataShouldBeToken(String name) {
        SerenityRest.and().body("data.name",equalTo(name));
    }
}
