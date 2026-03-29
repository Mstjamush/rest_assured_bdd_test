package leave.stepdefinitions;

import io.cucumber.java.en.When;
import io.restassured.response.Response;
import leave.utils.RestAssuredClient;

public class HolidaySteps {

    @When("I create holiday named {string} on {string} with description {string}")
    public void iCreateHoliday(String name, String date, String desc) {
        String body = String.format("{\"name\":\"%s\",\"date\":\"%s\",\"description\":\"%s\"}", name, date, desc);
        Response resp = RestAssuredClient.authenticatedSpec().body(body).post("/holidays");
        ResponseContext.set(resp);
    }

    @When("I get all holidays")
    public void iGetAllHolidays() {
        Response resp = RestAssuredClient.authenticatedSpec().get("/holidays");
        ResponseContext.set(resp);
    }
}