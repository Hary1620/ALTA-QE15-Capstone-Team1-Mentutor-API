package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class LoginUsersStep {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Login user with valid json {string}")
    public void registerNewUserWithValidJson(String FileName) {
        File fileJson = new File(Constants.REQ_BODY+FileName);
        reqresAPI.postLoginUser(fileJson);
    }

    @When("Send request post login user")
    public void sendRequestPostLoginUser() {
        SerenityRest.when().post(ReqresAPI.LOGIN_USERS);
    }

    @And("Response body token should be {string}")
    public void responseBodyTokenShouldBe(String token) {
        SerenityRest.and().body(ReqresResponses.TOKEN, equalTo(token));
    }
}
