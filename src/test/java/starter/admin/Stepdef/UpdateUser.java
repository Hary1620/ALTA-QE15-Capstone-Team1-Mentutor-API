package starter.admin.Stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.admin.Admin;
import starter.utils.Constants;

import java.io.File;

public class UpdateUser {
    @Steps
    Admin admin;

    @Given("Update user with parameter userId {int} and valid json {string}")
    public void updateUserWithParameterIdAndValidJson(int userId, String update) {
        File jsonFile = new File(Constants.REQ_BODY+update);
        admin.putUpdateUser(userId,jsonFile);
    }

    @When("Send Request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(Admin.USERS_WITH_ID);
    }
}
