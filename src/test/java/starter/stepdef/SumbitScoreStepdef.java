package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.MentutorAPI;
import starter.utils.Constants;

import java.io.File;

public class SumbitScoreStepdef {
    @Steps
    MentutorAPI mentutorAPI;

    @Given("Submit score with valid id submission {int} & valid data {string}")
    public void submitScoreWithValidIdSubmissionValidData(int id_submission, String file) {
        File jsonFile = new File(Constants.JSON_SCHEMA + file);
        mentutorAPI.commentStatus(id_submission, jsonFile);
    }

    @When("Send request submit score")
    public void sendRequestSubmitScore() {
        SerenityRest.when().post(MentutorAPI.POST_SCORE);
    }
}
