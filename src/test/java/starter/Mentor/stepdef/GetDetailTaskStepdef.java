package starter.Mentor.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Login.LoginAPI;
import starter.Mentor.mentutor.MentorAPI;
import starter.Mentor.mentutor.MentutorResponses;

import static org.hamcrest.Matchers.equalTo;

public class GetDetailTaskStepdef {
    @Steps
    MentorAPI mentorAPI;

    @Given("Get detail task with valid id {int}")
    public void getDetailTaskWithValidId(int id_task) {
        mentorAPI.getDetailTask(id_task);
    }

    @When("Send request get detail task")
    public void sendRequestGetDetailTask() {
        SerenityRest.when().get(MentorAPI.GET_DETAIL_TASK);
    }

    @And("Response body message error should be {string}")
    public void responseBodyMessageErrorShouldBe(String message) {
        SerenityRest.and().body("message error", equalTo(message));
    }

    @Given("Get detail task with invalid id {string}")
    public void getDetailTaskWithInvalidId(String satu) {
        SerenityRest.given()
                .pathParam("id_task", satu)
                .header("Authorization", "Bearer " + LoginAPI.getTokenMentor());
    }
}
