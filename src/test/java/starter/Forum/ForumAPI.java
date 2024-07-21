package starter.Forum;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.Login.LoginAPI;
import starter.utils.Constants;

public class ForumAPI {

    public static String GET_ALL_STATUS = Constants.BASE_URL+ "/forum";

    @Steps
    LoginAPI loginAPI;

    @Step("Get all status")
    public void getAllStatus(){
        SerenityRest.given()
                .header("Authorization", "Bearer " + loginAPI.TOKEN_MENTEE);
    }
}
