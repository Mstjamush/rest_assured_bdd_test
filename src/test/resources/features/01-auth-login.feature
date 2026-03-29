Feature: Auth - Login Endpoint

  @C1001
  Scenario: Successful login (public endpoint)
    Given I login with username "alice" and password "secret123"
    When I call the login endpoint
    Then the response status should be 200

  @C1002
  Scenario: Login with invalid credentials
    Given I login with username "alice" and password "wrongpass"
    When I call the login endpoint
    Then the response status should be 401

  @C1003
  Scenario: Login with missing password
    Given I login with username "alice" and password ""
    When I call the login endpoint
    Then the response status should be 400