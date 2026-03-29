package leave.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import leave.utils.RestAssuredClient;

import static org.hamcrest.Matchers.*;

public class CommonSteps {

    @Given("I am logged in as {word}")
    public void iAmLoggedInAs(String role) {
        switch (role.toUpperCase()) {
            case "ADMIN" -> RestAssuredClient.login("admin", "admin123");
            case "MANAGER" -> RestAssuredClient.login("manager", "manager123");
            case "USER" -> RestAssuredClient.login("user", "user123");
            default -> throw new IllegalArgumentException("Unknown role: " + role);
        }
    }

    @Given("I am not logged in")
    public void iAmNotLoggedIn() {
        // token deliberately not set
    }

    @Then("the response status should be {int}")
    public void theResponseStatusShouldBe(int status) {
        ResponseContext.get().then().statusCode(status);
    }

    @Then("the response body should contain {string}")
    public void theResponseBodyShouldContain(String text) {
        ResponseContext.get().then().body(containsString(text));
    }

    @Then("the response should contain field {string} with value {string}")
    public void theResponseShouldContainFieldWithValue(String field, String value) {
        ResponseContext.get().then().body(field, equalTo(value));
    }

    @Then("the response should be a list with at least {int} item(s)")
    public void theResponseShouldBeAListWithAtLeast(int min) {
        ResponseContext.get().then().body("size()", greaterThanOrEqualTo(min));
    }

    @After
    public void cleanup() {
        ResponseContext.clear();
    }
}