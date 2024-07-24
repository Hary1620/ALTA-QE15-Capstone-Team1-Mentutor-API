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
    public static String CLASSES_WITH_ID = Constants.BASE_URL + "/admin/classes/{classId}";

@Steps
LoginAPI loginAPI;

    @Step("Get All users")
    public void getAllUsers(){
        SerenityRest.given()
                .header("Authorization", "Bearer " + loginAPI); }

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

    @Step ("Get Profil Other User with invali id")
    public void getProfilOtherUserInvalidID(String userId) {
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

    @Step("Put update user of mentee")
    public void putUpdateUser(int Id, File json) {
        SerenityRest.given().pathParam("userId", Id)
                .contentType(ContentType.JSON).body(json)
                .header("Authorization", "Bearer " + loginAPI.TOKEN_ADMIN);
    }

    @Step("Put update class")
    public void putUpdateClass(int Id, File json) {
        SerenityRest.given().pathParam("classId", Id)
                .contentType(ContentType.JSON).body(json)
                .header("Authorization", "Bearer " + loginAPI.TOKEN_ADMIN);
    }

    @Step("Put update class special character id")
    public void putUpdateClassSpecialID(String Id, File json) {
        SerenityRest.given().pathParam("classId", Id)
                .contentType(ContentType.JSON).body(json)
                .header("Authorization", "Bearer " + loginAPI.TOKEN_ADMIN);
    }

    @Step ("Delete a Class")
    public void DeleteClass(int id){
        SerenityRest.given().pathParam("classId",id)
        .header("Authorization", "Bearer " + loginAPI.TOKEN_ADMIN);
    }

    @Step ("Delete a Class special character id")
    public void DeleteClassSpecialId(String id){
        SerenityRest.given().pathParam("classId",id);
    }

    @Step ("Delete a user of mentee")
    public void DeleteUser(int id){
        SerenityRest.given().pathParam("userId",id)
                .header("Authorization", "Bearer " + loginAPI.TOKEN_ADMIN);
    }

    @Step ("Delete a user of mentee")
    public void DeleteUserSpecialID(String id){
        SerenityRest.given().pathParam("userId",id)
                .header("Authorization", "Bearer " + loginAPI.TOKEN_ADMIN);
    }

    @Step ("Delete a user special character id")
    public void DeleteUserSpecialId(String id){
        SerenityRest.given().pathParam("userId",id);
    }






}
