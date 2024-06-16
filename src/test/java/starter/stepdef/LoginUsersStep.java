package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.matchesPattern;

public class LoginUsersStep {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Login user with valid json {string}")
    public void loginUserWithValidJson(String FileName) {
        File fileJson = new File(Constants.REQ_BODY+FileName);
        reqresAPI.postLoginUser(fileJson);
    }

    @When("Send request post login user")
    public void sendRequestPostLoginUser() {
        SerenityRest.when().post(ReqresAPI.LOGIN_USERS);
    }

//    @And("Response body token should be {string}")
//    public void responseBodyTokenShouldBe(String token) {
////        SerenityRest.and().body(ReqresResponses.TOKEN, equalTo(token));
//
//    }

    @And("Response body token should be a valid token")
    public void responseBodyTokenShouldBeAValidToken() {
        SerenityRest.then().body("token", notNullValue())
                .body("token", matchesPattern("^[a-zA-Z0-9]+$"));
        String token = SerenityRest.then().extract().path("token");
        Serenity.setSessionVariable("token").to(token);
    }


    //Negatif TestCase Login with unregistered account

    @Given("Login user with invalid json {string}")
    public void loginUserWithInvalidJson(String fileName) {
        File fileJson = new File(Constants.REQ_BODY+fileName);
        reqresAPI.postLoginUser(fileJson);

    }

    @And("Response body should be {string}")
    public void responseBodyShouldBe(String error) {
        SerenityRest.and().body(ReqresResponses.ERROR, equalTo(error));
//        SerenityRest.then().body(equalTo(error));
    }


}
