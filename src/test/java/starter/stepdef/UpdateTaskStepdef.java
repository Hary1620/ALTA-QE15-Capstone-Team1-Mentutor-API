package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.MentutorAPI;
import starter.utils.Constants;

import java.io.File;

public class UpdateTaskStepdef {
    @Steps
    MentutorAPI mentutorAPI;

    @Given("Update task by mentor with valid id {int} & data {string}")
    public void updateTaskByMentorWithValidIdData(int id_task, String file) {
        File jsonFile = new File(Constants.JSON_SCHEMA + file);
        mentutorAPI.updateTask(id_task, jsonFile);
    }

    @When("Send request update task")
    public void sendRequestUpdateTask() {
        SerenityRest.when().put(MentutorAPI.UPDATE_TASK);
    }
}
