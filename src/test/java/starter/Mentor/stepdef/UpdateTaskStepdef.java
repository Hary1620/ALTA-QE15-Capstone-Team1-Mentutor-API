package starter.Mentor.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Mentor.mentutor.MentorAPI;
import starter.utils.Constants;

import java.io.File;

public class UpdateTaskStepdef {
    @Steps
    MentorAPI mentorAPI;

    @Given("Update task by mentor with valid id {int} & data {string}")
    public void updateTaskByMentorWithValidIdData(int id_task, String file) {
        File jsonFile = new File(Constants.REQ_BODY + file);
        mentorAPI.updateTask(id_task, jsonFile);
    }

    @When("Send request update task")
    public void sendRequestUpdateTask() {
        SerenityRest.when().put(MentorAPI.UPDATE_TASK);
    }

    @Given("Update task by mentor with not exist id {int} & data {string}")
    public void updateTaskByMentorWithNotExistIdData(int id_task, String file) {
        File jsonFile = new File(Constants.REQ_BODY + file);
        mentorAPI.updateTask(id_task, jsonFile);
    }

    @Given("Update task by mentor with invalid id {int} & data {string}")
    public void updateTaskByMentorWithInvalidIdData(int arg0, String arg1) {
    }
}
