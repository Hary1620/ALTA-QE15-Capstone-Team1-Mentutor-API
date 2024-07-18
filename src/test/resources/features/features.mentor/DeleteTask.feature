Feature: Delete task by mentor
  Scenario: Delete task with valid id
    Given Delete task with valid id 3
    When Send request delete task
    Then Status code should be 201
    And Response body message should be "Delete success"
    And Validate json schema should be "delete_task_schema.json"