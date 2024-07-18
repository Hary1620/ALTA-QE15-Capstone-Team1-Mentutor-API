package starter.Mentor.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Mentor.mentutor.MentorAPI;

public class DeleteTaskStepdef {
    @Steps
    MentorAPI mentorAPI;

    @Given("Delete task with valid id {int}")
    public void deleteTaskWithValidId(int id_task) {
        mentorAPI.deleteTask(id_task);
    }

    @When("Send request delete task")
    public void sendRequestDeleteTask() {
        SerenityRest.when().delete(MentorAPI.DELETE_TASK);
    }

    @Given("Delete task with valid id {string}")
    public void deleteTaskWithValidId(String arg0) {

    }
}
