package starter.reqres;


import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class ReqresAPI {
    public static String LIST_USERS = Constants.BASE_URL+ "/api/users?page={page}";

    public static String CREATE_USER = Constants.BASE_URL+ "/api/users";


    @Step ("Get List users")
    public void getlistUsers(int page){
        SerenityRest.given().pathParam("page",page);

    }

    @Step ("Create new user")
    public void postCreateNewUser(File json) {
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
}
