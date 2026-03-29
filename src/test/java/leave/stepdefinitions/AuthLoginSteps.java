package leave.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import leave.utils.RestAssuredClient;

public class AuthLoginSteps {

    @Given("I login with username {string} and password {string}")
    public void iLoginWithUsernameAndPassword(String username, String password) {
        RestAssuredClient.login(username, password);
    }

    @When("I call the login endpoint")
    public void iCallTheLoginEndpoint() {
        Response resp = RestAssuredClient.unauthenticatedSpec()
                .body("{\"username\":\"alice\",\"password\":\"secret123\"}") // dummy body – token already set
                .post("/auth/login");
        ResponseContext.set(resp);
    }
}