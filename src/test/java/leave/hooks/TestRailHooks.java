package leave.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import leave.utils.TestRailReporter;

public class TestRailHooks {

    @After
    public void afterScenario(Scenario scenario) {
        int caseId = extractTestRailCaseId(scenario);
        if (caseId == -1) return; // no @Cxxx tag → skip

        int statusId = scenario.isFailed() ? 5 : 1; // 5 = Failed, 1 = Passed
        String comment = scenario.isFailed() ? scenario.getName() + " FAILED" : "PASSED";

        TestRailReporter.addResult(caseId, statusId, comment);
    }

    private int extractTestRailCaseId(Scenario scenario) {
        for (String tag : scenario.getSourceTagNames()) {
            if (tag.startsWith("@C")) {
                try {
                    return Integer.parseInt(tag.substring(2));
                } catch (NumberFormatException e) {
                    return -1;
                }
            }
        }
        return -1;
    }
}