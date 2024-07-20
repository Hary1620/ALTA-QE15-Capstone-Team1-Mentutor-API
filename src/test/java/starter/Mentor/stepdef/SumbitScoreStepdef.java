package starter.Mentor.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Mentor.mentutor.MentorAPI;
import starter.utils.Constants;

import java.io.File;

public class SumbitScoreStepdef {
    @Steps
    MentorAPI mentorAPI;

    @Given("Submit score with valid id submission {int} & valid data {string}")
    public void submitScoreWithValidIdSubmissionValidData(int id_submission, String file) {
        File jsonFile = new File(Constants.JSON_SCHEMA + file);
        mentorAPI.commentStatus(id_submission, jsonFile);
    }

    @When("Send request submit score")
    public void sendRequestSubmitScore() {
        SerenityRest.when().post(MentorAPI.POST_SCORE);
    }

    @Given("Submit score with not exist id submission {int} & valid data {string}")
    public void submitScoreWithNotExistIdSubmissionValidData(int arg0, String arg1) {
    }

    @Given("Submit score with invalid id submission {string} & valid data {string}")
    public void submitScoreWithInvalidIdSubmissionValidData(String arg0, String arg1) {
    }

    @Given("Submit score with valid id submission {int} & invalid type data {string}")
    public void submitScoreWithValidIdSubmissionInvalidTypeData(int arg0, String arg1) {
    }

    @Given("Submit score with valid id submission {int} & invalid data {string}")
    public void submitScoreWithValidIdSubmissionInvalidData(int arg0, String arg1) {
    }
}
