package starter.reqres;


import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class ReqresAPI {
    public static String LIST_USERS = Constants.BASE_URL+ "/api/users?page={page}";

    public static String CREATE_USER = Constants.BASE_URL+ "/api/users";

    public static String USER_WITH_ID = Constants.BASE_URL+ "/api/users/{idUser}";


    @Step ("Get List users")
    public void getlistUsers(int page){
        SerenityRest.given().pathParam("page",page);

    }

    @Step ("Create new user")
    public void postCreateNewUser(File json) {
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    @Step ("Update User")
    public void putUpdateUser (int id, File json){
        SerenityRest.given().pathParam("idUser",id)
                .contentType(ContentType.JSON).body(json);
    }

    @Step ("Delete a user")
    public void DeleteUser(int id){
        SerenityRest.given().pathParam("idUser",id);
    }


}
