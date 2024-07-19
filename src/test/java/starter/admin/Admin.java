package starter.admin;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.Login.LoginAPI;
import starter.utils.Constants;

import java.io.File;


public class Admin {
    public static String ALL_USERS = Constants.BASE_URL + "/admin/users";
    public static String ALL_CLASSES = Constants.BASE_URL + "/admin/classes";
    public static String USERS_WITH_ID = Constants.BASE_URL + "/admin/users/{userId}";

@Steps
LoginAPI loginAPI;

    @Step("Get All users")
    public void getAllUsers(){
        SerenityRest.given()
                .header("Authorization", "Bearer " + loginAPI.TOKEN_ADMIN); }

    @Step("Get All Class")
    public void getAllClass(){
        SerenityRest.given()
                .header("Authorization", "Bearer " + loginAPI.TOKEN_ADMIN); }

    @Step ("Get Profil Other User")
        public void getProfilOtherUser(int userId) {
            SerenityRest.given()
                    .pathParam("userId", userId)
                    .header("Authorization", "Bearer " + loginAPI.TOKEN_ADMIN);
        }

    @Step("Register New User of Mentee")
    public void postRegisterNewUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON).body(json)
                .header("Authorization", "Bearer " + loginAPI.TOKEN_ADMIN);
    }

    @Step("Register New Class ")
    public void postRegisterNewClass(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON).body(json)
                .header("Authorization", "Bearer " + loginAPI.TOKEN_ADMIN);
    }




}
