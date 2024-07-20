Feature: Delete task by mentor
  Scenario: Delete task with valid id
    Given Delete task with valid id 3
    When Send request delete task
    Then Status code should be 201
    And Response body message should be "Delete success"
    And Validate json schema should be "delete_task_schema.json"

  Scenario: Delete task with not exist id
    Given Delete task with valid id 100
    When Send request delete task
    Then Status code should be 400
    And Response body message should be "Invalid Input From Client"
    And Validate json schema should be "delete_task_invalid_schema.json"

  Scenario: Delete task with invalid id
    Given Delete task with valid id "satu"
    When Send request delete task
    Then Status code should be 400
    And Response body message should be "Invalid Input From Client"
    And Validate json schema should be "delete_task_invalid_schema.json"