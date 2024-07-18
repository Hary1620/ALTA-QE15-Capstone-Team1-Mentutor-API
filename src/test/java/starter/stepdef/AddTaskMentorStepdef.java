package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.MentutorAPI;
import starter.utils.Constants;

import java.io.File;

public class AddTaskMentorStepdef {
    @Steps
    MentutorAPI mentutorAPI;

    @Given("Add task with valid data json {string}")
    public void addTaskWithValidDataJson(String file) {
        File jsonFile = new File(Constants.JSON_SCHEMA + file);
        mentutorAPI.addTask(jsonFile);
    }

    @When("Send request add task by mentor")
    public void sendRequestAddTaskByMentor() {
        SerenityRest.when().post(MentutorAPI.ADD_TASK);
    }
}
