Feature: Holidays Endpoints

  @C1007
  Scenario: ADMIN creates holiday successfully
    Given I am logged in as ADMIN
    When I create holiday named "Labour Day" on "2026-05-01" with description "Public holiday"
    Then the response status should be 201

  @C1008
  Scenario: Create holiday without authentication
    Given I am not logged in
    When I create holiday named "Labour Day" on "2026-05-01" with description "Public holiday"
    Then the response status should be 401

  @C1009
  Scenario: Create holiday as USER (forbidden)
    Given I am logged in as USER
    When I create holiday named "Labour Day" on "2026-05-01" with description "Public holiday"
    Then the response status should be 403

  @C1010
  Scenario: Get all holidays as ADMIN
    Given I am logged in as ADMIN
    When I get all holidays
    Then the response status should be 200
    And the response should be a list with at least 1 item(s)