package starter.Login;


import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class LoginAPI {
    public static String LOGIN = Constants.BASE_URL +"/login";
    public static String TOKEN_ADMIN = getTokenAdmin();
    public static String TOKEN_MENTOR = getTokenMentor();
    public static String TOKEN_MENTEE = getTokenMentee();

    public static String getTokenAdmin(){
        File jsonFile = new File(Constants.REQ_BODY + "login_admin.json");
        loginAdmin(jsonFile);
        Response response = SerenityRest.when().post(LoginAPI.LOGIN);
        JsonPath jsonPath = response.jsonPath();
        //System.out.println(jsonPath.get("data.token").toString());
        return jsonPath.get("data.token");
    }

    public static String getTokenMentor(){
        File jsonFile = new File(Constants.REQ_BODY + "login_mentor.json");
        loginMentor(jsonFile);
        Response response = SerenityRest.when().post(LoginAPI.LOGIN);
        JsonPath jsonPath = response.jsonPath();
        //System.out.println(jsonPath.get("data.token").toString());
        return jsonPath.get("data.token");
    }

    public static String getTokenMentee(){
        File jsonFile = new File(Constants.REQ_BODY + "login_mentee.json");
        loginMentee(jsonFile);
        Response response = SerenityRest.when().post(LoginAPI.LOGIN);
        JsonPath jsonPath = response.jsonPath();
        //System.out.println(jsonPath.get("data.token").toString());
        return jsonPath.get("data.token");
    }

    @Step ("Login mentor")
    public static void loginMentor(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step ("Login admin")
    public static void loginAdmin(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step ("Login mentee")
    public static void loginMentee(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step ("Login invalid")
    public static void loginInvalid(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
}
