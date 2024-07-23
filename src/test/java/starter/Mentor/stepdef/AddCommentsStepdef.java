package starter.Mentor.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Mentor.mentutor.MentorAPI;
import starter.utils.Constants;

import java.io.File;

public class AddCommentsStepdef {
    @Steps
    MentorAPI mentorAPI;

    @Given("Add comment on forum with valid id {int} status & valid data {string}")
    public void addCommentOnForumWithValidIdStatusValidData(int id_status, String file) {
        File jsonFile = new File(Constants.REQ_BODY + file);
        mentorAPI.commentStatus(id_status, jsonFile);
    }

    @When("Send request add comment")
    public void sendRequestAddComment() {
        SerenityRest.when().post(MentorAPI.POST_COMMENT);
    }

    @Given("Add comment on forum with not exist id {int} status & valid data {string}")
    public void addCommentOnForumWithNotExistIdStatusValidData(int id_status, String file) {
        File jsonFile = new File(Constants.REQ_BODY + file);
        mentorAPI.commentStatus(id_status, jsonFile);
    }

    @Given("Add comment on forum with invalid id {string} status & valid data {string}")
    public void addCommentOnForumWithInvalidIdStatusValidData(String id_status, String file) {
        File jsonFile = new File(Constants.REQ_BODY + file);
        mentorAPI.commentStatusInvalid(id_status, jsonFile);
    }

    @Given("Add comment on forum with valid id {int} status & invalid data {string}")
    public void addCommentOnForumWithValidIdStatusInvalidData(int id_status, String file) {
        File jsonFile = new File(Constants.REQ_BODY + file);
        mentorAPI.commentStatus(id_status, jsonFile);
    }
}
