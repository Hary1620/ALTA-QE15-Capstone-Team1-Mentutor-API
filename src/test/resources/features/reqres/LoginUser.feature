@tugas
Feature: Login user API
  Scenario Outline: Login user with valid json
    Given Login user with valid json "<fileName>"
    When Send request post login user
    Then Status code should be 200
    And Response body token should be "QpwL5tke4Pnpja7X4"
    And validate json schema "login_users_json_schema.json"

    Examples:
    |fileName |
    |login_user1.json|