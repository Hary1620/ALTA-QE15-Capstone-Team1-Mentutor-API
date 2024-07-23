package starter.admin.Stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.admin.Admin;
import starter.utils.Constants;

import java.io.File;

public class RegisterNewClass {
    @Steps
    Admin admin;

    @Given("register new class with valid json {string}")
    public void registerNewClassWithValidJson(String FileName) {
        File fileJson = new File(Constants.REQ_BODY+FileName);
        admin.postRegisterNewClass(fileJson);
    }

    @When("send request post register new class")
    public void sendRequestPostRegisterNewClass() {
        SerenityRest.when().post(Admin.ALL_CLASSES);
    }
}
