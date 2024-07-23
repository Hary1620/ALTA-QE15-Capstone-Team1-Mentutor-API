Feature: Post submit task
  Scenario: Submit task with valid task id and data
    Given Submit task with valid task id 21 & valid data "submit_task.json"
    When Send request submit task
    Then Status code should be 201
    And Response body message should be "success insert submission"
    And Validate json schema "submit_task_schema.json"

  Scenario: Submit task with valid task id and data more than once
    Given Submit task with valid task id 8 & valid data "submit_task.json"
    When Send request submit task
    Then Status code should be 400