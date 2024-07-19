package starter.Mentor.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Mentor.mentutor.MentorAPI;
import starter.Mentor.mentutor.MentutorResponses;

import static org.hamcrest.Matchers.equalTo;

public class GetAllTaskStepdef {
    @Steps
    MentorAPI mentorAPI;

    @Given("Get all task with valid parameter")
    public void getAllTaskWithValidParameter() {
        mentorAPI.getAllTask();
    }

    @When("Send request get all task")
    public void sendRequestGetAllTask() {
        SerenityRest.when().get(MentorAPI.GET_ALL_TASK + "ssd");
    }

    @And("Response body message should be {string}")
    public void responseBodyMessageShouldBe(String message) {
        SerenityRest.and().body(MentutorResponses.MESSAGE,equalTo(message));
    }

    @Given("Get all task with invalid parameter")
    public void getAllTaskWithInvalidParameter() {
        mentorAPI.getAllTask();
    }
}
