Feature: Get detail task
  Scenario: Get detail task with valid id
    Given Get detail task with valid id 3
    When Send request get detail task
    Then Status code should be 201
    And Response body message should be "success get single task"
    And Validate json schema should be "get_detail_task_schema.json"

  Scenario: Get detail task with not exist id
    Given Get detail task with valid id 100
    When Send request get detail task
    Then Status code should be 404
    And Response body message should be "Task not found"
    And Validate json schema should be "get_detail_task_invalid_schema.json"

  Scenario: Get detail task with invalid id
    Given Get detail task with valid id "satu"
    When Send request get detail task
    Then Status code should be 400
    And Response body message should be "Task not found"
    And Validate json schema should be "get_detail_task_invalid_schema.json"