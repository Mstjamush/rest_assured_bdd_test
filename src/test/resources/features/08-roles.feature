Feature: Roles Endpoints

  @C1023
  Scenario: ADMIN creates role successfully
    Given I am logged in as ADMIN
    When I create role named "MANAGER"
    Then the response status should be 201

  @C1024
  Scenario: Create role without authentication
    Given I am not logged in
    When I create role named "MANAGER"
    Then the response status should be 401

  @C1025
  Scenario: Assign role to user
    Given I am logged in as ADMIN
    When I assign role "MANAGER" to userId 5
    Then the response status should be 200