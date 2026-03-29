package leave.stepdefinitions;

import io.cucumber.java.en.When;
import io.restassured.response.Response;
import leave.utils.RestAssuredClient;

public class LeaveApplySteps {

    @When("I apply for leave from {string} to {string} with reason {string}")
    public void iApplyForLeave(String start, String end, String reason) {
        String body = String.format("{\"startDate\":\"%s\",\"endDate\":\"%s\",\"reason\":\"%s\"}", start, end, reason);
        Response resp = RestAssuredClient.authenticatedSpec().body(body).post("/leave/apply");
        ResponseContext.set(resp);
    }
}