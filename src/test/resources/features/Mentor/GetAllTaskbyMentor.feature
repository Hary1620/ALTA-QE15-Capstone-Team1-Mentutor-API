Feature: Get all tasks by id mentor
  Scenario: Get all task with valid parameter
    Given Get all task with valid parameter
    When Send request get all task
    Then Status code should be 201
    And Response body message should be "Success get all task"
    And Validate json schema should be "get_all_task_schema.json"

  Scenario: Get all task with invalid parameter
    Given Get all task with invalid parameter
    When Send request get all task
    Then Status code should be 400
    And Response body message should be "Invalid Input From Client"
    And Validate json schema should be "get_all_task_invalid_schema.json"
