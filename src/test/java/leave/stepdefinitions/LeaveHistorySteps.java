package leave.stepdefinitions;

import io.cucumber.java.en.When;
import io.restassured.response.Response;
import leave.utils.RestAssuredClient;

public class LeaveHistorySteps {

    @When("I get my leave history")
    public void iGetMyLeaveHistory() {
        Response resp = RestAssuredClient.authenticatedSpec().get("/leave/history");
        ResponseContext.set(resp);
    }
}