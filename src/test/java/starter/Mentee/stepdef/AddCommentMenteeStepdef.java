package starter.Mentee.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Mentee.MenteeAPI;
import starter.utils.Constants;

import java.io.File;

public class AddCommentMenteeStepdef {
    @Steps
    MenteeAPI menteeAPI;

    @Given("Add mentee comment on forum with valid id {int} status & valid data {string}")
    public void addMenteeCommentOnForumWithValidIdStatusValidData(int id_status, String file) {
        File jsonFile = new File(Constants.REQ_BODY + file);
        menteeAPI.postAddComment(id_status, jsonFile);
    }

    @When("Send request add mentee comment")
    public void sendRequestAddMenteeComment() {
        SerenityRest.when().post(menteeAPI.POST_COMMENT);
    }
}
