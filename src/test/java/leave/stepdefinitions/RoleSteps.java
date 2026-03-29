package leave.stepdefinitions;

import io.cucumber.java.en.When;
import io.restassured.response.Response;
import leave.utils.RestAssuredClient;

public class RoleSteps {

    @When("I create role named {string}")
    public void iCreateRole(String name) {
        String body = String.format("{\"name\":\"%s\"}", name);
        Response resp = RestAssuredClient.authenticatedSpec().body(body).post("/roles");
        ResponseContext.set(resp);
    }

    @When("I assign role {string} to userId {int}")
    public void iAssignRoleToUser(String roleName, int userId) {
        Response resp = RestAssuredClient.authenticatedSpec()
                .queryParam("userId", userId)
                .queryParam("roleName", roleName)
                .post("/roles/assign");
        ResponseContext.set(resp);
    }
}