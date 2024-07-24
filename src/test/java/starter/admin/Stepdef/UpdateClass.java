package starter.admin.Stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.admin.Admin;
import starter.utils.Constants;

import java.io.File;

public class UpdateClass {
    @Steps
    Admin admin;

    @Given("Update class with parameter class id {int} and valid json {string}")
    public void updateClassWithParameterClassIdAndValidJson(int classID, String FileName) {
        File jsonFile = new File(Constants.REQ_BODY+FileName);
        admin.putUpdateClass(classID,jsonFile);

    }

    @When("Send Request put update class")
    public void sendRequestPutUpdateClass() {
        SerenityRest.when().put(Admin.CLASSES_WITH_ID);
    }

    @Given("Update class with parameter class id {string} and valid json {string}")
    public void updateClassWithParameterClassIdAndValidJson(String Id, String file) {
        File jsonFile = new File(Constants.REQ_BODY+file);
        admin.putUpdateClassSpecialID(Id,jsonFile);
    }
}
