package leave.utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import leave.config.Config;

public class RestAssuredClient {

    private static String authToken;

    public static void login(String username, String password) {
        Response resp = RestAssured.given()
                .baseUri(Config.get("api.base.url"))
                .contentType(ContentType.JSON)
                .body(String.format("{\"username\":\"%s\",\"password\":\"%s\"}", username, password))
                .post("/auth/login");

        authToken = resp.jsonPath().getString("token");
        if (authToken == null || authToken.trim().isEmpty()) {
            authToken = resp.asString(); // fallback
        }
    }

    public static RequestSpecification authenticatedSpec() {
        if (authToken == null || authToken.trim().isEmpty()) {
            throw new IllegalStateException("No auth token – call login() first");
        }
        return RestAssured.given()
                .baseUri(Config.get("api.base.url"))
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + authToken);
    }

    public static RequestSpecification unauthenticatedSpec() {
        return RestAssured.given()
                .baseUri(Config.get("api.base.url"))
                .contentType(ContentType.JSON);
    }
}