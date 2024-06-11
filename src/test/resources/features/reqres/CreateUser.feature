Feature: Create new user API
  Scenario: Create new user with valid json
    Given Create new user with valid json "create_user.json"
    When Send request post create user
    Then Status code should be 201