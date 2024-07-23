Feature: Add Task by Mentor
  Scenario: Add task with valid data
    Given Add task with valid data json "perkalian" "tentukan hasil perkalian bilangan berikut ini" "contoh.jpg" "soal.pdf" "2024-08-25"
    When Send request add task by mentor
    Then Status code should be 201
    And Response body message should be "Success insert task"
    And Validate json schema should be "add_task_schema.json"

  Scenario: Add task with invalid type data
    Given Add task with invalid type data "contoh.jpg"
    When Send request add task by mentor
    Then Status code should be 400
#    And Response body message error should be "Invalid Input From Client"
    And Validate json schema should be "add_task_schema_invalid.json"

  Scenario: Add task with invalid data
    Given Add task with invalid data name "perkalian" "tentukan hasil perkalian bilangan berikut ini" "contoh.jpg" "soal.pdf" "2024-08-25"
    When Send request add task by mentor
    Then Status code should be 400
#    And Response body message error should be "Invalid Input From Client"
    And Validate json schema should be "add_task_schema_invalid.json"