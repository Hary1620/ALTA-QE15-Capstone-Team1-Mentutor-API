package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.MentutorAPI;

public class DeleteTaskStepdef {
    @Steps
    MentutorAPI mentutorAPI;

    @Given("Delete task with valid id {int}")
    public void deleteTaskWithValidId(int id_task) {
        mentutorAPI.deleteTask(id_task);
    }

    @When("Send request delete task")
    public void sendRequestDeleteTask() {
        SerenityRest.when().delete(MentutorAPI.DELETE_TASK);
    }
}
