package leave.stepdefinitions;

import io.cucumber.java.en.When;
import io.restassured.response.Response;
import leave.utils.RestAssuredClient;

public class LeaveBalanceSteps {

    @When("I get my leave balance")
    public void iGetMyLeaveBalance() {
        Response resp = RestAssuredClient.authenticatedSpec().get("/leave/balance/me");
        ResponseContext.set(resp);
    }

    @When("I get leave balance for userId {int}")
    public void iGetLeaveBalanceForUser(int userId) {
        Response resp = RestAssuredClient.authenticatedSpec().get("/leave/balance/" + userId);
        ResponseContext.set(resp);
    }

    @When("I get leave balance history with page {int} and size {int}")
    public void iGetLeaveBalanceHistory(int page, int size) {
        Response resp = RestAssuredClient.authenticatedSpec()
                .queryParam("page", page)
                .queryParam("size", size)
                .get("/leave/balance/history");
        ResponseContext.set(resp);
    }
}