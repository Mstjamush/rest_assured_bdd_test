Feature: Users Endpoints

  @C1026
  Scenario: ADMIN creates user successfully
    Given I am logged in as ADMIN
    When I create user with username "bob" password "secret123" employmentDate "2026-03-20" managerId 2
    Then the response status should be 201

  @C1027
  Scenario: Get all users (paginated) as ADMIN
    Given I am logged in as ADMIN
    When I get all users with page 0 and size 20
    Then the response status should be 200

  @C1028
  Scenario: Get my own user details
    Given I am logged in as USER
    When I get my user details
    Then the response status should be 200

  @C1029
  Scenario: Delete user as ADMIN
    Given I am logged in as ADMIN
    When I delete user with userId 10
    Then the response status should be 204