Feature: Add Task by Mentor
  Scenario: Add task with valid data
    Given Add task with valid data json "add_task.json"
    When Send request add task by mentor
    Then Status code should be 200
    And Response body message should be "success insert task"
    And Validate json schema should be "add_task_schema.json"

  Scenario: Add task with invalid type data
    Given Add task with invalid type data json "add_task_invalid_type_data.json"
    When Send request add task by mentor
    Then Status code should be 400
    And Response body message should be "Invalid Input From Client"
    And Validate json schema should be "add_task_schema_invalid.json"

  Scenario: Add task with invalid data
    Given Add task with invalid type data json "add_task_invalid_data.json"
    When Send request add task by mentor
    Then Status code should be 400
    And Response body message should be "Invalid Input From Client"
    And Validate json schema should be "add_task_schema_invalid.json"