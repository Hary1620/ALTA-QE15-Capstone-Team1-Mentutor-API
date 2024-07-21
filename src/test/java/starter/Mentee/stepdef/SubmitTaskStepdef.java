package starter.Mentee.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.Mentee.MenteeAPI;
import starter.Mentor.mentutor.MentorAPI;
import starter.utils.Constants;

import java.io.File;

public class SubmitTaskStepdef {
    @Steps
    MenteeAPI menteeAPI;

    @Given("Submit task with valid task id {int} & valid data {string}")
    public void submitTaskWithValidTaskIdValidData(int id, String file) {
        File jsonFile = new File(Constants.REQ_BODY + file);
        menteeAPI.postSubmitTask(id, jsonFile);
    }

    @When("Send request submit task")
    public void sendRequestSubmitTask() {
        SerenityRest.when().post(MenteeAPI.POST_SCORE);
    }

}
