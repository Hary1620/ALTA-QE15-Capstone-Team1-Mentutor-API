Feature: Get all tasks by id mentor
  Scenario: Get all task with valid parameter
    Given Get all task with valid parameter
    When Send request get all task
    Then Status code should be 201
    And Response body message should be "success get all task"
    And Validate json schema should be "get_all_task_schema.json"