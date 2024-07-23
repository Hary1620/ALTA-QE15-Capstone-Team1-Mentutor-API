package starter.admin.Stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.admin.Admin;

public class GetAllClass {
    @Steps
    Admin admin;

    @Given("get all class with valid json")
    public void getAllClassWithValidJson() {
        admin.getAllClass();
    }

    @When("send request get all class")
    public void sendRequestGetAllClass() {
        SerenityRest.when().get(Admin.ALL_CLASSES);
    }
}
