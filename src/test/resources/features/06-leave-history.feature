Feature: Leave - History Endpoint

  @C1017
  Scenario: USER gets own leave history
    Given I am logged in as USER
    When I get my leave history
    Then the response status should be 200

  @C1018
  Scenario: Get leave history without authentication
    Given I am not logged in
    When I get my leave history
    Then the response status should be 401