package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.mentutor.MentutorAPI;
import starter.mentutor.MentutorResponses;

import static org.hamcrest.Matchers.equalTo;

public class GetAllTaskStepdef {
    @Steps
    MentutorAPI mentutorAPI;

    @Given("Get all task with valid parameter")
    public void getAllTaskWithValidParameter() {
        mentutorAPI.getAllTask();
    }

    @When("Send request get all task")
    public void sendRequestGetAllTask() {
        SerenityRest.when().get(MentutorAPI.GET_ALL_TASK);
    }

    @And("Response body message should be {string}")
    public void responseBodyMessageShouldBe(String message) {
        SerenityRest.and().body(MentutorResponses.MESSAGE,equalTo(message));
    }

}
