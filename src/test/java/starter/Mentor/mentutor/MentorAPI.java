package starter.Mentor.mentutor;


import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Login.LoginAPI;
import starter.utils.Constants;

import java.io.File;

public class MentorAPI {

    public static String UPDATE_USERS = Constants.BASE_URL+ "/user";
    public static String ADD_TASK = Constants.BASE_URL+ "/mentors/tasks";
    public static String GET_ALL_TASK = Constants.BASE_URL+ "/mentors/tasks";
    public static String GET_DETAIL_TASK = Constants.BASE_URL+ "/mentors/tasks/{id_task}";
    public static String UPDATE_TASK = Constants.BASE_URL+ "/mentors/tasks/{id_task}";
    public static String DELETE_TASK = Constants.BASE_URL+ "/mentors/tasks/{id_task}";
    public static String POST_SCORE = Constants.BASE_URL+ "/mentors/submission/{id_submission}";
    public static String POST_COMMENT = Constants.BASE_URL+ "/forum/{id_status}";
    

    @Step ("Get all task")
    public void getAllTask(){
        SerenityRest.given()
                .header("Authorization", "Bearer " + LoginAPI.getTokenMentor());
    }

    @Step ("Update user")
    public void updateUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .header("Authorization", "Bearer " + LoginAPI.getTokenMentor());
    }

    @Step ("Add task")
    public void addTask(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)

                .header("Authorization", "Bearer " + LoginAPI.getTokenMentor());

    }

    @Step ("Get detail task")
    public void getDetailTask(int id_task){
        SerenityRest.given()
                .pathParam("id_task", id_task)

                .header("Authorization", "Bearer " + LoginAPI.getTokenMentor());

    }

    @Step ("Update task")
    public void updateTask(int id_task, File json){
        SerenityRest.given()
                .pathParam("id_task", id_task)
                .contentType(ContentType.JSON)
                .body(json)
                .header("Authorization", "Bearer " + LoginAPI.getTokenMentor());
    }

    @Step ("Delete a task")
    public void deleteTask(int id_task){
        SerenityRest.given()
                .pathParam("id_task", id_task)
                .header("Authorization", "Bearer " + LoginAPI.getTokenMentor());
    }

    @Step ("Submit Score")
    public void submitScore (int id_submission, File json){
        SerenityRest.given()
                .pathParam("id_submission", id_submission)
                .contentType(ContentType.JSON)
                .body(json)

                .header("Authorization", "Bearer " + LoginAPI.getTokenMentor());
    }

    @Step ("Comment Status")
    public void commentStatus(int id_status, File json){
        SerenityRest.given()
                .pathParam("id_status", id_status)
                .contentType(ContentType.JSON)
                .body(json)
                .header("Authorization", "Bearer" + LoginAPI.getTokenMentor());
    }

    @Step ("Login mentor")
    public static void loginMentor(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
}
