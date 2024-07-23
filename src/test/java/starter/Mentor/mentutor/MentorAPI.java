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

    public static String LOGIN_MENTOR = Constants.BASE_URL +"/login";
    public static String UPDATE_USERS = Constants.BASE_URL+ "/users";
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
    public void updateUser(String name, String email, String password, String imageFile){
        SerenityRest.given()
                .multiPart("name", name)
                .multiPart("email", email)
                .multiPart("password", password)
                .multiPart("images", new File(Constants.DIR + "/src/docs/" + imageFile))
                .header("Content-Type", "multipart/form-data")
                .header("Authorization", "Bearer " + TOKEN);
    }

    @Step ("Update user invalid data type file")
    public void updateUserInvalid(String imageFile){
        SerenityRest.given()
                .multiPart("name", new File(Constants.DIR + "/src/docs/" + imageFile))
                .multiPart("email",  new File(Constants.DIR + "/src/docs/" + imageFile))
                .multiPart("password", new File(Constants.DIR + "/src/docs/" + imageFile))
                .multiPart("images", new File(Constants.DIR + "/src/docs/" + imageFile))
                .header("Content-Type", "multipart/form-data")
                .header("Authorization", "Bearer " + TOKEN);
    }

    @Step ("Update user invalid data name")
    public void updateUserInvalidName(String name, String email, String password, String imageFile){
        SerenityRest.given()
                .multiPart("nama", name)
                .multiPart("email", email)
                .multiPart("kata_sandi", password)
                .multiPart("gambar", new File(Constants.DIR + "/src/docs/" + imageFile))
                .header("Content-Type", "multipart/form-data")
                .header("Authorization", "Bearer " + TOKEN);
    }

    @Step ("Add task")
    public void addTask(String title, String description, String images, String file, String date){
        SerenityRest.given()
                .multiPart("title", title)
                .multiPart("description", description)
                .multiPart("images", new File(Constants.DIR + "/src/docs/" + images))
                .multiPart("file", new File(Constants.DIR + "/src/docs/" + file))
                .multiPart("due_date", date)
                .header("Content-Type", "multipart/form-data")
                .header("Authorization", "Bearer " + TOKEN);
    }
    @Step ("Add task invalid data type file")
    public void addTaskinvalid(String images){
        SerenityRest.given()
                .multiPart("title", new File(Constants.DIR + "/src/docs/" + images))
                .multiPart("description", new File(Constants.DIR + "/src/docs/" + images))
                .multiPart("images", new File(Constants.DIR + "/src/docs/" + images))
                .multiPart("file", new File(Constants.DIR + "/src/docs/" + images))
                .multiPart("due_date", new File(Constants.DIR + "/src/docs/" + images))
                .header("Content-Type", "multipart/form-data")
                .header("Authorization", "Bearer " + TOKEN);
    }
    @Step ("Add task invalid data name")
    public void addTaskinvalidName(String title, String description, String images, String file, String date){
        SerenityRest.given()
                .multiPart("judul", title)
                .multiPart("deskripsi", description)
                .multiPart("gambar", new File(Constants.DIR + "/src/docs/" + images))
                .multiPart("file", new File(Constants.DIR + "/src/docs/" + file))
                .multiPart("tanggal", date)
                .header("Content-Type", "multipart/form-data")
                .header("Authorization", "Bearer " + TOKEN);

    }


    @Step ("Get detail task")
    public void getDetailTask(int id_task){
        SerenityRest.given()
                .pathParam("id_task", id_task)
                .header("Authorization", "Bearer " + TOKEN);

    }

    @Step ("Update task")
    public void updateTask(int id_task, File json){
        SerenityRest.given()
                .pathParam("id_task", id_task)
                .contentType(ContentType.JSON)
                .body(json)
                .header("Authorization", "Bearer " + TOKEN);

    }

    @Step ("Delete a task")
    public void deleteTask(int id_task){
        SerenityRest.given()
                .pathParam("id_task", id_task)
                .header("Authorization", "Bearer " + TOKEN);
    }

    @Step ("Delete a task invalid string")
    public void deleteTaskInvalid(String id_task){
        SerenityRest.given()
                .pathParam("id_task", id_task)
                .header("Authorization", "Bearer " + TOKEN);

    }

    @Step ("Submit Score")
    public void submitScore (int id_submission, File json){
        SerenityRest.given()
                .pathParam("id_submission", id_submission)
                .contentType(ContentType.JSON)
                .body(json)
                .header("Authorization", "Bearer " + TOKEN);
    }
    @Step ("Submit Score invalid string")
    public void submitScoreInvalid (String id_submission, File json){
        SerenityRest.given()
                .pathParam("id_submission", id_submission)
                .contentType(ContentType.JSON)
                .body(json)
                .header("Authorization", "Bearer " + TOKEN);
    }

    @Step ("Comment Status")
    public void commentStatus(int id_status, File json){
        SerenityRest.given()
                .pathParam("id_status", id_status)
                .contentType(ContentType.JSON)
                .body(json)
                .header("Authorization", "Bearer " + TOKEN);
    }

    @Step ("Comment Status")
    public void commentStatusInvalid(String id_status, File json){
        SerenityRest.given()
                .pathParam("id_status", id_status)
                .contentType(ContentType.JSON)
                .body(json)
                .header("Authorization", "Bearer " + TOKEN);

    }

    @Step ("validate json schema")
    public void loginMentor(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
}
