Feature: Update task by mentor
  Scenario: Update task by mentor with valid id & data
    Given Update task by mentor with valid id 3 & data "update_task_mentor.json"
    When Send request update task
    Then Status code should be 201
    And Response body message should be "success get single task"
    And Validate json schema should be "update_task_schema.json"

  ##negative case
  Scenario: Update task with not exist id & valid data
    Given Update task by mentor with not exist id 100 & data "update_task_mentor.json"
    When Send request update task
    Then Status code should be 400
    And Response body message should be "Invalid Input From Client"
    And Validate json schema should be "update_task_invalid_schema.json"

  Scenario: Update task with invalid id & valid data
    Given Update task by mentor with invalid id 100 & data "update_task_mentor.json"
    When Send request update task
    Then Status code should be 400
    And Response body message should be "Invalid Input From Client"
    And Validate json schema should be "update_task_invalid_schema.json"

  Scenario: Update task with valid id & invalid type data
    Given Update task by mentor with invalid id 100 & data "update_task_mentor_invalid_type_data.json"
    When Send request update task
    Then Status code should be 400
    And Response body message should be "Invalid Input From Client"
    And Validate json schema should be "update_task_invalid_schema.json"

  Scenario: Update task with valid id & invalid data
    Given Update task by mentor with invalid id 100 & data "update_task_mentor_invalid_data.json"
    When Send request update task
    Then Status code should be 400
    And Response body message should be "Invalid Input From Client"
    And Validate json schema should be "update_task_invalid_schema.json"