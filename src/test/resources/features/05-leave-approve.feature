Feature: Leave - Approve Endpoint

  @C1014
  Scenario: MANAGER approves leave successfully
    Given I am logged in as MANAGER
    When I approve leave with leaveId 12 approved "true" and comment "Approved"
    Then the response status should be 200

  @C1015
  Scenario: Approve without authentication
    Given I am not logged in
    When I approve leave with leaveId 12 approved "true" and comment "Approved"
    Then the response status should be 401

  @C1016
  Scenario: USER tries to approve leave (forbidden)
    Given I am logged in as USER
    When I approve leave with leaveId 12 approved "true" and comment "Approved"
    Then the response status should be 403