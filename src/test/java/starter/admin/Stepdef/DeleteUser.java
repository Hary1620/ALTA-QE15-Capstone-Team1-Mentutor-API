package starter.admin.Stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.admin.Admin;

public class DeleteUser {
    @Steps
    Admin admin;

    @Given("Delete user with id {int}")
    public void deleteUserWithId(int id) {
        admin.DeleteUser(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(Admin.USERS_WITH_ID);
    }

    @Given("Delete user with Special id {string}")
    public void deleteUserWithSpecialId(String id) {
        admin.DeleteUserSpecialID(id);
    }
}
