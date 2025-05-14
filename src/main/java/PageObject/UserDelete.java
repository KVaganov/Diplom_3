package PageObject;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserDelete {
    private static final String BASE_URI = "https://stellarburgers.nomoreparties.site";
    private static final String LOGIN_USER = "/api/auth/login";
    private static final String DELETE_USER = "/api/auth/user";

    @Step("Логин юзера в системе")
    public ValidatableResponse loginUser(User user){
        return given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .body(user)
                .when()
                .post(LOGIN_USER)
                .then();
    }

    @Step("Удаление юзера")
    public void deleteUser(String accessToken){
        given()
                .baseUri(BASE_URI)
                .header("Authorization", accessToken)
                .contentType(ContentType.JSON)
                .when()
                .delete(DELETE_USER)
                .then();
    }

}
