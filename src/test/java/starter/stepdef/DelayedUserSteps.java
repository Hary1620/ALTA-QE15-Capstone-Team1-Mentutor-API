package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

public class DelayedUserSteps {
    @Steps
    ReqresAPI reqresAPI;


    @Given("Get dellayed responsed of time {int}")
    public void getDellayedResponsedOfTime(int time) {
        reqresAPI.getDelayedUser(time);
    }

    @And("I send a request to the delayed API")
    public void iSendARequestToTheDelayedAPI() {
        SerenityRest.when().get(ReqresAPI.DELAYED_RESPONSE);
    }



    @When("I wait for the response")
    public void iWaitForTheResponse() {
    }


    @And("The response should be received after a delay")
    public void theResponseShouldBeReceivedAfterADelay() {
        long responseTime = SerenityRest.then().extract().time();
        assertThat("Response time should be greater than or equal to 1000 milliseconds", responseTime, greaterThanOrEqualTo(1000L));

    }



}
