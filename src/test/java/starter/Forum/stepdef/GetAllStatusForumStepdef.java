package starter.Forum.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Forum.ForumAPI;

public class GetAllStatusForumStepdef {
    @Steps
    ForumAPI forumAPI;

    @Given("Get all status by mentor and mentee")
    public void getAllStatusByMentorAndMentee() {
        forumAPI.getAllStatus();
    }

    @When("Send request get all status")
    public void sendRequestGetAllStatus() {
        SerenityRest.when().get(ForumAPI.GET_ALL_STATUS);
    }

}
