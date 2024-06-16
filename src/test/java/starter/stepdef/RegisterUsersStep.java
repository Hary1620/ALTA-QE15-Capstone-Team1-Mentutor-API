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

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.matchesPattern;

public class RegisterUsersStep {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Register new user with valid json {string}")
    public void registerNewUserWithValidJson(String FileName) {
        File fileJson = new File(Constants.REQ_BODY+FileName);
        reqresAPI.postRegisterNewUser(fileJson);
    }

    @When("Send request post register user")
    public void sendRequestPostRegisterUser() {
        SerenityRest.when().post(ReqresAPI.REGISTER_USERS);
    }

//    @And("Response body id should be {int} and token should be {string}")
//    public void responseBodyIdShouldBeAndTokenShouldBe(int id, String token) {
//        restAssuredThat(response -> response
//                .body("id", equalTo(id))
//                .body("token", equalTo(token))
//        );
//    }

    @And("Response body should contain a valid ID and token")
    public void responseBodyShouldContainAValidIDAndToken() {
        SerenityRest.then()
                .body("id", notNullValue())
                .body("id", instanceOf(Integer.class))
                .body("token", notNullValue())
                .body("token", matchesPattern("^[a-zA-Z0-9]+$"));

        // Menyimpan ID dan token untuk penggunaan lebih lanjut
        int userId = SerenityRest.then().extract().path("id");
        String token = SerenityRest.then().extract().path("token");

        Serenity.setSessionVariable("userId").to(userId);
        Serenity.setSessionVariable("token").to(token);

    }

    @Given("Register new user with invalid json {string}")
    public void registerNewUserWithInvalidJson(String FileName) {
        File fileJson = new File(Constants.REQ_BODY+FileName);
        reqresAPI.postRegisterNewUser(fileJson);
    }
}
