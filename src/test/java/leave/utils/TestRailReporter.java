package leave.utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import leave.config.Config;

public class TestRailReporter {

    private static final String TESTRAIL_BASE = Config.get("testrail.url") + "/index.php?/api/v2/";
    private static final String USERNAME = Config.get("testrail.username");
    private static final String API_KEY = Config.get("testrail.api_key");
    private static final int RUN_ID = Integer.parseInt(Config.get("testrail.run_id"));

    public static void addResult(int caseId, int statusId, String comment) {
        String body = String.format("{\"status_id\": %d, \"comment\": \"%s\"}", statusId, comment.replace("\"", "\\\""));

        Response resp = RestAssured.given()
                .auth().preemptive().basic(USERNAME, API_KEY)
                .baseUri(TESTRAIL_BASE)
                .contentType(ContentType.JSON)
                .body(body)
                .post("add_result_for_case/" + RUN_ID + "/" + caseId);

        if (resp.statusCode() != 200) {
            System.err.println("TestRail update failed: " + resp.asString());
        }
    }
}