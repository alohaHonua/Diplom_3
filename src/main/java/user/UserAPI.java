package user;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserAPI {

    private final static String CREATE_USER_PATH = "/api/auth/register";
    private final static String LOGIN_USER_PATH = "/api/auth/login";
    private final static String DELETE_USER_PATH = "/api/auth/user";


    private final static String URL = "https://stellarburgers.nomoreparties.site";

    protected void setUrl() {
        RestAssured.baseURI = URL;
    }

    @Step("Send POST request to /api/auth/register")
    public Response createUserRequest(User user) {
        setUrl();
        return given()
                .header("Content-type", "application/json")
                .body(user)
                .when()
                .post(CREATE_USER_PATH);
    }

    @Step("Send POST request to /api/auth/login")
    public Response loginUserRequest(User user) {
        setUrl();
        return given()
                .header("Content-type", "application/json")
                .body(user)
                .when()
                .post(LOGIN_USER_PATH);
    }

    @Step("Send DELETE request to /api/auth/register")
    public void deleteUserRequest(User user) {
        setUrl();
        String accessToken = loginUserRequest(user).then().extract().path("accessToken");
        if (accessToken != null) {
            given()
                    .header("Authorization", accessToken)
                    .delete(DELETE_USER_PATH);
            return;
        }
        given()
                .delete(DELETE_USER_PATH);
    }

}

