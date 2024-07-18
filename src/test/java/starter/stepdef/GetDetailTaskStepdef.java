package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.MentutorAPI;

public class GetDetailTaskStepdef {
    @Steps
    MentutorAPI mentutorAPI;

    @Given("Get detail task with valid id {int}")
    public void getDetailTaskWithValidId(int id_task) {
        mentutorAPI.getDetailTask(id_task);
    }

    @When("Send request get detail task")
    public void sendRequestGetDetailTask() {
        SerenityRest.when().get(MentutorAPI.GET_DETAIL_TASK);
    }
}
