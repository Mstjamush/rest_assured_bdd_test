Feature: Leave - Balance Endpoints

  @C1019
  Scenario: USER gets own balance
    Given I am logged in as USER
    When I get my leave balance
    Then the response status should be 200

  @C1020
  Scenario: MANAGER gets balance for another user
    Given I am logged in as MANAGER
    When I get leave balance for userId 5
    Then the response status should be 200

  @C1021
  Scenario: Get balance history (paginated)
    Given I am logged in as USER
    When I get leave balance history with page 0 and size 10
    Then the response status should be 200

  @C1022
  Scenario: Get balance history without authentication
    Given I am not logged in
    When I get leave balance history with page 0 and size 10
    Then the response status should be 401