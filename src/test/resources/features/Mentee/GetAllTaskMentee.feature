Feature: Get all tasks assign to mentee
  Scenario: Get all task with valid parameter
#    Given Login mentee with valid account "login_mentee.json"
#    When Send request login mentee
    Given Get all task from mentee
    When Send request get all mentee task
    Then Status code should be 200
    And Response body message should be "success get all status"
    And Validate json schema "get_all_task_mentee_schema.json"