package starter.admin.Stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.admin.Admin;
import starter.utils.Constants;

import java.io.File;

public class RegisterNewUser {
    @Steps
    Admin admin;

    @Given("register new user with valid json {string}")
    public void registerNewUserWithValidJson(String fileName) {
        File fileJson = new File(Constants.REQ_BODY+fileName);
        admin.postRegisterNewUser(fileJson);
    }

    @When("send request post register new user")
    public void sendRequestPostRegisterNewUser() {
        SerenityRest.when().post(Admin.ALL_USERS);
    }

    @Given("register new user with invalid json {string}")
    public void registerNewUserWithInvalidJson(String file) {
        File fileJson = new File(Constants.REQ_BODY+file);
        admin.postRegisterNewUser(fileJson);
    }
}
