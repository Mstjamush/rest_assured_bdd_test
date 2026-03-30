# Leave Manager – REST Assured BDD Tests

Automated API test suite for the Leave Manager REST API, built with **Cucumber 7**, **REST Assured 5**, and **JUnit 4**. Test results are automatically pushed to **TestRail** after each run.

---

## Prerequisites

| Tool | Minimum Version |
|------|----------------|
| Java JDK | 17 |
| Apache Maven | 3.8+ |
| Leave Manager API | running and accessible |
| TestRail account | with API access enabled |

---

## Setup

### 1. Configure `testrail.properties`

Edit `src/test/resources/testrail.properties` with your environment values:

```properties
# TestRail
testrail.url=https://YOUR_INSTANCE.testrail.io
testrail.username=your.email@company.com
testrail.api_key=your_testrail_api_key      # My Profile → API Keys in TestRail
testrail.project_id=1                        # Your TestRail project ID
testrail.run_id=123                          # A test run you created in TestRail

# Leave Manager API
api.base.url=http://localhost:8080           # Base URL of the running API
```

> **TestRail API key:** log in to TestRail → top-right avatar → *My Profile* → *API Keys* → *Add Key*.

> **Run ID:** in TestRail create a Test Run that includes the cases tagged in the feature files (e.g. `@C1001`), then copy its numeric ID from the URL.

### 2. Install dependencies

```bash
mvn dependency:resolve
```

---

## Running the Tests

### Run all tests

```bash
mvn test
```

### Run a specific feature tag

```bash
mvn test -Dcucumber.filter.tags="@C1001"
```

### Run all scenarios in a feature area

```bash
mvn test -Dcucumber.filter.tags="@auth"
```

### Skip TestRail reporting (dry run, no API side-effects)

```bash
mvn test -Dcucumber.filter.tags="not @ignore" -Dtestrail.disabled=true
```

> If you want to suppress TestRail pushes during local development, add a `testrail.disabled` guard in `TestRailHooks.java`.

---
## Test Reports

After a run, reports are generated in the `target/` directory:

| Report | Path |
|--------|------|
| HTML report | `target/cucumber-html-report/index.html` |
| JSON report | `target/cucumber.json` |

Open the HTML report in any browser:

```bash
open target/cucumber-html-report/index.html      # macOS
xdg-open target/cucumber-html-report/index.html  # Linux
start target/cucumber-html-report/index.html     # Windows
```

---

## TestRail Integration

- Each scenario tagged with `@C<id>` (e.g. `@C1001`) is automatically reported to the configured TestRail run after it executes.
- **Passed** scenarios post status `1` (Passed); **failed** scenarios post status `5` (Failed).
- Scenarios without a `@C<id>` tag are silently skipped by the reporter.

---

## Skipping Scenarios

Tag any scenario with `@ignore` to exclude it from the run (handled by `tags = "not @ignore"` in `TestRunner`):

```gherkin
@ignore
Scenario: Work in progress
  ...
```

