package starter.Login.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Login.LoginAPI;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class LoginStepdef {
    @Steps
    LoginAPI loginAPI;

    @Given("Login mentor with valid account {string}")
    public void loginMentorWithValidAccount(String file) {
        File jsonFile = new File(Constants.REQ_BODY + file);
        loginAPI.loginMentor(jsonFile);
    }

    @Given("Login admin with valid account {string}")
    public void loginAdminWithValidAccount(String file) {
        File jsonFile = new File(Constants.REQ_BODY + file);
        loginAPI.loginAdmin(jsonFile);
    }

    @Given("Login mentee with valid account {string}")
    public void loginMenteeWithValidAccount(String file) {
        File jsonFile = new File(Constants.REQ_BODY + file);
        loginAPI.loginMentee(jsonFile);
    }

    @Given("Login with invalid account {string}")
    public void loginWithInvalidAccount(String file) {
        File jsonFile = new File(Constants.REQ_BODY + file);
        loginAPI.loginInvalid(jsonFile);
    }

    @When("Send request login mentor")
    public void sendRequestLoginMentor() {
        Response response = SerenityRest.when().post(LoginAPI.LOGIN);
        JsonPath jsonPath = response.jsonPath();
        String TOKEN = jsonPath.get("data.token");
        //System.out.println(TOKEN);
        LoginAPI.TOKEN_MENTOR = TOKEN;
    }

    @When("Send request login admin")
    public void sendRequestLoginAdmin() {
        Response response = SerenityRest.when().post(LoginAPI.LOGIN);
        JsonPath jsonPath = response.jsonPath();
        String TOKEN = jsonPath.get("data.token");
        LoginAPI.TOKEN_ADMIN = TOKEN;
    }

    @When("Send request login mentee")
    public void sendRequestLoginMentee() {
        Response response = SerenityRest.when().post(LoginAPI.LOGIN);
        JsonPath jsonPath = response.jsonPath();
        String TOKEN = jsonPath.get("data.token");
        LoginAPI.TOKEN_MENTEE = TOKEN;
    }

    @When("Send request login invalid")
    public void sendRequestLoginInvalid() {
        SerenityRest.when().post(LoginAPI.LOGIN);
    }

    @And("Response body name should be {string}")
    public void responseBodyDataShouldBeToken(String name) {
        SerenityRest.and().body("message",equalTo(name));
    }

    @And("Response body name login should be {string}")
    public void responseBodyNameAdminShouldBe(String name) {
        SerenityRest.and().body("data.name",equalTo(name));
    }


}
