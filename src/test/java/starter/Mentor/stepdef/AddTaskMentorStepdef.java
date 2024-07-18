package starter.Mentor.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Mentor.mentutor.MentorAPI;
import starter.utils.Constants;

import java.io.File;

public class AddTaskMentorStepdef {
    @Steps
    MentorAPI mentorAPI;

    @Given("Add task with valid data json {string}")
    public void addTaskWithValidDataJson(String file) {
        File jsonFile = new File(Constants.JSON_SCHEMA + file);
        mentorAPI.addTask(jsonFile);
    }

    @When("Send request add task by mentor")
    public void sendRequestAddTaskByMentor() {
        SerenityRest.when().post(MentorAPI.ADD_TASK);
    }

    @Given("Add task with invalid type data json {string}")
    public void addTaskWithInvalidTypeDataJson(String arg0) {
    }
}
