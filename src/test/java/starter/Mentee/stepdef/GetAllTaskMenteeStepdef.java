package starter.Mentee.stepdef;

import io.cucumber.java.da.Men;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Mentee.MenteeAPI;

public class GetAllTaskMenteeStepdef {
    @Steps
    MenteeAPI menteeAPI;

    @Given("Get all task from mentee")
    public void getAllTaskFromMentee() {
        menteeAPI.getTaskMentee();
    }

    @When("Send request get all mentee task")
    public void sendRequestGetAllMenteeTask() {
        SerenityRest.when().get(menteeAPI.GET_ALL_TASK);
    }
}
