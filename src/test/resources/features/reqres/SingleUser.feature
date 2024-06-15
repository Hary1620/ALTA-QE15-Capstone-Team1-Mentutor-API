@tugas
Feature: Get Single User API
  Scenario Outline: Get Single user with valid id
    Given Get single user with valid id <id>
    When Send request get single user
    Then Status code should be 200
    And Response body id should be <id>

    Examples:
    | id |
    | 1 |
    | 2 |