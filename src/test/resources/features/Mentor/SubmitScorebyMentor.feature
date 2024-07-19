Feature: Submit score by mentor
  Scenario: Submit score with valid id submission & valid data
    Given Submit score with valid id submission 5 & valid data "submit_submission.json"
    When Send request submit score
    Then Status code should be 201
    And Response body message should be "success insert score"
    And Validate json schema should be "submit_submission_schema.json"

  Scenario: Submit score with not exist id submission & valid data
    Given Submit score with not exist id submission 100 & valid data "submit_submission.json"
    When Send request submit score
    Then Status code should be 400
    And Response body message error should be "Invalid Input From Client"
    And Validate json schema should be "submit_submission_invalid_schema.json"

  Scenario: Submit score with invalid id submission & valid data
    Given Submit score with invalid id submission "satu" & valid data "submit_submission.json"
    When Send request submit score
    Then Status code should be 400
    And Response body message error should be "Invalid Input From Client"
    And Validate json schema should be "submit_submission_invalid_schema.json"

  Scenario: Submit score with valid id submission & invalid type data
    Given Submit score with valid id submission 1 & invalid type data "submit_submission_invalid_type_data.json"
    When Send request submit score
    Then Status code should be 400
    And Response body message error should be "Invalid Input From Client"
    And Validate json schema should be "submit_submission_invalid_schema.json"

  Scenario: Submit score with valid id submission & invalid data
    Given Submit score with valid id submission 1 & invalid data "submit_submission_invalid_data.json"
    When Send request submit score
    Then Status code should be 400
    And Response body message error should be "Invalid Input From Client"
    And Validate json schema should be "submit_submission_invalid_schema.json"