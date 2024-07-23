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

    @Given("Add task with valid data json {string} {string} {string} {string} {string}")
    public void addTaskWithValidDataJson(String title, String description, String images, String file, String date) {
        mentorAPI.addTask(title,description,images,file,date);
    }

    @When("Send request add task by mentor")
    public void sendRequestAddTaskByMentor() {
        SerenityRest.when().post(MentorAPI.ADD_TASK);
    }

    @Given("Add task with invalid type data {string}")
    public void addTaskWithInvalidTypeDataJson(String images) {
        mentorAPI.addTaskinvalid(images);
    }

    @Given("Add task with invalid data name {string} {string} {string} {string} {string}")
    public void addTaskWithInvalidDataName(String title, String description, String images, String file, String date) {
        mentorAPI.addTaskinvalidName(title,description,images,file,date);
    }
}
