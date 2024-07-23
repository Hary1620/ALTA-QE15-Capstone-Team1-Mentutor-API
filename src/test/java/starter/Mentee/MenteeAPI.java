package starter.Mentee;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.Login.LoginAPI;
import starter.utils.Constants;

import java.io.File;

public class MenteeAPI {
    public static String UPDATE_USERS = Constants.BASE_URL+ "/users";
    public static String ADD_TASK = Constants.BASE_URL+ "/mentees/tasks";
    public static String GET_ALL_TASK = Constants.BASE_URL+ "/mentees/tasks";
    public static String GET_DETAIL_TASK = Constants.BASE_URL+ "/mentees/tasks/{id_task}";
    public static String UPDATE_TASK = Constants.BASE_URL+ "/mentees/tasks/{id_task}";
    public static String DELETE_TASK = Constants.BASE_URL+ "/mentees/tasks/{id_task}";
    public static String POST_SCORE = Constants.BASE_URL+ "/mentees/submission/{id_submission}";
    public static String POST_COMMENT = Constants.BASE_URL+ "/forum/{id_status}";

    @Steps
    LoginAPI loginAPI;

    @Step("Update user")
    public void updateMentee(File json){
        SerenityRest.given()
                .header("Authorization", "Bearer " + loginAPI.TOKEN_MENTEE)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Get task mentee")
    public void getTaskMentee(){
        SerenityRest.given()
                .header("Authorization", "Bearer " + loginAPI.TOKEN_MENTEE)
                .when()
                .get(MenteeAPI.GET_ALL_TASK);
    }

    @Step("post submit task")
    public void postSubmitTask(int id, File json){
        SerenityRest.given()
                .pathParam("id_submission", id)
                .header("Authorization", "Bearer " + loginAPI.TOKEN_MENTEE)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("post add comment")
    public void postAddComment(int id, File json){
        SerenityRest.given()
                .pathParam("id_status", id)
                .header("Authorization", "Bearer " + loginAPI.TOKEN_MENTEE)
                .contentType(ContentType.JSON)
                .body(json);
    }

}
