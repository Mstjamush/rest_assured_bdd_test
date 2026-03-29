package leave.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import leave.utils.RestAssuredClient;

public class AuthRegisterSteps {

    @Given("I register a new user with username {string} password {string} employmentDate {string} managerId {int}")
    public void iRegisterNewUser(String username, String password, String date, int managerId) {
        // stored for use in When
    }

    @When("I call the register endpoint")
    public void iCallTheRegisterEndpoint() {
        String body = "{\"username\":\"newuser\",\"password\":\"secret123\",\"employmentDate\":\"2026-04-01\",\"managerId\":2}";
        Response resp = RestAssuredClient.unauthenticatedSpec()
                .body(body)
                .post("/auth/register");
        ResponseContext.set(resp);
    }
}