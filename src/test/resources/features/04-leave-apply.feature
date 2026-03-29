Feature: Leave - Apply Endpoint

  @C1011
  Scenario: USER applies for leave successfully
    Given I am logged in as USER
    When I apply for leave from "2026-04-06" to "2026-04-10" with reason "Annual leave"
    Then the response status should be 201

  @C1012
  Scenario: Apply without authentication
    Given I am not logged in
    When I apply for leave from "2026-04-06" to "2026-04-10" with reason "Annual leave"
    Then the response status should be 401

  @C1013
  Scenario: Apply with invalid dates (end before start)
    Given I am logged in as USER
    When I apply for leave from "2026-04-10" to "2026-04-06" with reason "Annual leave"
    Then the response status should be 400