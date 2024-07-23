package starter.admin.Stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.admin.Admin;

public class GetProfilUser {
    @Steps
    Admin admin;

    @Given("Get profil user with valid id {int}")
    public void getProfilUserWithValidIdUserID(int UserID) {
        admin.getProfilOtherUser(UserID);

    }

    @When("send request get profil user")
    public void sendRequestGetProfilUser() {
        SerenityRest.when().get(Admin.USERS_WITH_ID);
    }

    @Given("get profil user with invalid id {string}")
    public void getProfilUserWithInvalidId(String UserId) {
        admin.getProfilOtherUserInvalidID(UserId);
    }
}
