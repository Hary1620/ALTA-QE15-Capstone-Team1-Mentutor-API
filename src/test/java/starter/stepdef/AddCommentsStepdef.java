package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.MentutorAPI;
import starter.utils.Constants;

import java.io.File;

public class AddCommentsStepdef {
    @Steps
    MentutorAPI mentutorAPI;

    @Given("Add comment on forum with valid id {int} status & valid data {string}")
    public void addCommentOnForumWithValidIdStatusValidData(int id_status, String file) {
        File jsonFile = new File(Constants.JSON_SCHEMA + file);
        mentutorAPI.commentStatus(id_status, jsonFile);
    }

    @When("Send request add comment")
    public void sendRequestAddComment() {
        SerenityRest.when().post(MentutorAPI.POST_COMMENT);
    }
}
