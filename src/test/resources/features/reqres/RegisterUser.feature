@tugas
Feature: Register new user API
  Scenario Outline: Register new user with valid json
    Given Register new user with valid json "<FileName>"
    When Send request post register user
    Then Status code should be 200
    And Response body id should be 4 and token should be "QpwL5tke4Pnpja7X4"
    And validate json schema "register_users_json_schema.json"

    Examples:
    |FileName|
    |register_user1.json|
