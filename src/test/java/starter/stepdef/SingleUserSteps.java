package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class SingleUserSteps {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Get single user with valid id {int}")
    public void getSingleUserWithValidIdId(int id) {
        reqresAPI.getSingleUser(id);
    }

    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
        SerenityRest.when().get(ReqresAPI.USER_WITH_ID);
    }

    @And("Response body id should be {int}")
    public void responseBodyIdShouldBeId(int id) {

        SerenityRest.and().body(ReqresResponses.ID, Matchers.equalTo(id));
//        restAssuredThat(response -> response
//                .body(ReqresResponses.ID, equalTo(id))
//        );
    }

    @Given("Get single user with unknown id {int}")
    public void getSingleUserWithUnknownIdId(int id) {
        reqresAPI.getSingleUser(id);
    }

    @Given("Get single user with invalid id {string}")
    public void getSingleUserWithInvalidId(String SpecialChara) {
        reqresAPI.getSpecialSingleUser(SpecialChara);
    }

    @And("Response body json should be {string}")
    public void responseBodyJsonShouldBe(String nul) {
        SerenityRest.and().body(equalTo(nul));

    }
}
