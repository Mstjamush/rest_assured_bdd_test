package leave.stepdefinitions;

import io.cucumber.java.en.When;
import io.restassured.response.Response;
import leave.utils.RestAssuredClient;

public class LeaveApproveSteps {

    @When("I approve leave with leaveId {int} approved {string} and comment {string}")
    public void iApproveLeave(int leaveId, String approved, String comment) {
        String body = String.format("{\"leaveId\":%d,\"approved\":%s,\"comment\":\"%s\"}", leaveId, approved, comment);
        Response resp = RestAssuredClient.authenticatedSpec().body(body).post("/leave/approve");
        ResponseContext.set(resp);
    }
}