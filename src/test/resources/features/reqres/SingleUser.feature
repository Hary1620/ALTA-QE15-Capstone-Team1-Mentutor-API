@tugas
Feature: Get Single User API
  Scenario Outline: Get Single user with valid id
    Given Get single user with valid id <id>
    When Send request get single user
    Then Status code should be 200
    And Response body id should be <id>
    And validate json schema "single_users_json_schema.json"

    Examples:
    | id |
    | 1 |
    | 2 |

   Scenario Outline: Get Single user with unknown id
      Given Get single user with unknown id <id>
      When Send request get single user
      Then Status code should be 404
      And Response body json should be "{}"

     Examples:
     |id|
     |99|
     |55|

     Scenario: Get single user with special character id
       Given Get single user with invalid id "#@"
       When Send request get single user
       Then Status code should be 404
       And Response body json should be "{}"