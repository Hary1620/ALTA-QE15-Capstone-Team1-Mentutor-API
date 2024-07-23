package starter.admin.Stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.admin.Admin;

public class GetAllUsers {
    @Steps
    Admin admin;

    @Given("get all user with valid json")
    public void getAllUserWithValidJson() {
        admin.getAllUsers();
    }

    @When("send request get all users")
    public void sendRequestGetAllUsers() {
        SerenityRest.when().get(Admin.ALL_USERS);
    }
}
