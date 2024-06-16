@tugas
Feature: Create new user API
  Scenario Outline: Create new user with valid json
    Given Create new user with valid json "<fileName>"
    When Send request post create user
    Then Status code should be 201
    And Response body name should be "<name>" and job should be "<job>"
    And validate json schema "create_users_json_schema.json"

    Examples:
    |fileName | name | job |
    |create_user1.json|Hary Indra 1 | QA Engineer 1 |
    |create_user2.json|Hary Indra 2 | QA Engineer 2|