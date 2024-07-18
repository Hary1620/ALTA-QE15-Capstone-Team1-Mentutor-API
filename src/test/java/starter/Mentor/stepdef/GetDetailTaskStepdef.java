package starter.Mentor.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Mentor.mentutor.MentorAPI;

public class GetDetailTaskStepdef {
    @Steps
    MentorAPI mentorAPI;

    @Given("Get detail task with valid id {int}")
    public void getDetailTaskWithValidId(int id_task) {
        mentorAPI.getDetailTask(id_task);
    }

    @When("Send request get detail task")
    public void sendRequestGetDetailTask() {
        SerenityRest.when().get(MentorAPI.GET_DETAIL_TASK);
    }

    @Given("Get detail task with valid id {string}")
    public void getDetailTaskWithValidId(String arg0) {
    }
}
