package leave.stepdefinitions;

import io.cucumber.java.en.When;
import io.restassured.response.Response;
import leave.utils.RestAssuredClient;

public class UserSteps {

    @When("I create user with username {string} password {string} employmentDate {string} managerId {int}")
    public void iCreateUser(String username, String password, String date, int managerId) {
        String body = String.format("{\"username\":\"%s\",\"password\":\"%s\",\"employmentDate\":\"%s\",\"managerId\":%d}", username, password, date, managerId);
        Response resp = RestAssuredClient.authenticatedSpec().body(body).post("/users/createUser");
        ResponseContext.set(resp);
    }

    @When("I get all users with page {int} and size {int}")
    public void iGetAllUsers(int page, int size) {
        Response resp = RestAssuredClient.authenticatedSpec()
                .queryParam("page", page)
                .queryParam("size", size)
                .get("/users/getAllUsers");
        ResponseContext.set(resp);
    }

    @When("I get my user details")
    public void iGetMyUserDetails() {
        Response resp = RestAssuredClient.authenticatedSpec().get("/users/getUser/me");
        ResponseContext.set(resp);
    }

    @When("I delete user with userId {int}")
    public void iDeleteUser(int userId) {
        Response resp = RestAssuredClient.authenticatedSpec().delete("/users/deleteUser/" + userId);
        ResponseContext.set(resp);
    }
}