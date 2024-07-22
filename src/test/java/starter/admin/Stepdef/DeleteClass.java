package starter.admin.Stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.admin.Admin;

public class DeleteClass {
    @Steps
    Admin admin;

    @Given("Delete class with id {int}")
    public void deleteClassWothId(int id) {
        admin.DeleteClass(id);
    }

    @When("Send request delete class")
    public void sendRequestDeleteClass() {
        SerenityRest.when().delete(Admin.CLASSES_WITH_ID);
    }
}
