package starter.reqres;


import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class MentutorAPI {
    public static String UPDATE_USERS = Constants.BASE_URL+ "/user";
    public static String ADD_TASK = Constants.BASE_URL+ "/mentor/tasks";
    public static String GET_ALL_TASK = Constants.BASE_URL+ "/mentor/tasks";
    public static String GET_DETAIL_TASK = Constants.BASE_URL+ "/mentor/tasks/{id_task}";
    public static String UPDATE_TASK = Constants.BASE_URL+ "/mentor/tasks/{id_task}";
    public static String DELETE_TASK = Constants.BASE_URL+ "/mentor/tasks/{id_task}";
    public static String POST_SCORE = Constants.BASE_URL+ "/mentor/submission/{id_submission}";
    public static String POST_COMMENT = Constants.BASE_URL+ "/forum/{id_status}";

    @Step ("Get all task")
    public void getAllTask(){
        SerenityRest.given()
                .header("Authorization", "Bearer");
    }

    @Step ("Update user")
    public void updateUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .header("Authorization", "Bearer");
    }

    @Step ("Add task")
    public void addTask(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .header("Authorization", "Bearer");
    }

    @Step ("Get detail task")
    public void getDetailTask(int id_task){
        SerenityRest.given()
                .pathParam("id_task", id_task)
                .header("Authorization", "Bearer");
    }

    @Step ("Update task")
    public void updateTask(int id_task, File json){
        SerenityRest.given()
                .pathParam("id_task", id_task)
                .contentType(ContentType.JSON)
                .body(json)
                .header("Authorization", "Bearer");
    }

    @Step ("Delete a task")
    public void deleteTask(int id_task){
        SerenityRest.given()
                .pathParam("id_task", id_task)
                .header("Authorization", "Bearer");
    }

    @Step ("Submit Score")
    public void submitScore (int id_submission, File json){
        SerenityRest.given()
                .pathParam("id_submission", id_submission)
                .contentType(ContentType.JSON)
                .body(json)
                .header("Authorization", "Bearer");
    }

    @Step ("Comment Status")
    public void commentStatus(int id_status, File json){
        SerenityRest.given()
                .pathParam("id_status", id_status)
                .contentType(ContentType.JSON)
                .body(json)
                .header("Authorization", "Bearer");
    }
}
