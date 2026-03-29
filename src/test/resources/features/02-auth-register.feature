Feature: Auth - Register Endpoint

  @C1004
  Scenario: Successful registration (public)
    Given I register a new user with username "newuser" password "secret123" employmentDate "2026-04-01" managerId 2
    When I call the register endpoint
    Then the response status should be 201

  @C1005
  Scenario: Register with duplicate username
    Given I register a new user with username "alice" password "secret123" employmentDate "2026-04-01" managerId 2
    When I call the register endpoint
    Then the response status should be 409

  @C1006
  Scenario: Register with missing mandatory field
    Given I register a new user with username "bob" password "" employmentDate "2026-04-01" managerId 2
    When I call the register endpoint
    Then the response status should be 400