Feature: Add Task by Mentor
  Scenario: Add task with valid data
    Given Add task with valid data json "add_task.json"
    When Send request add task by mentor
    Then Status code should be 200
    And Response body message should be "success insert task"
    And Validate json schema should be "add_task_schema.json"