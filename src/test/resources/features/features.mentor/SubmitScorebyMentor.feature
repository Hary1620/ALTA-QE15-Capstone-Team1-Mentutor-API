Feature: Submit score by mentor
  Scenario: Submit score with valid id submission & valid data
    Given Submit score with valid id submission 1 & valid data "submit_submission.json"
    When Send request submit score
    Then Status code should be 201
    And Response body message should be "success submit score"
    And Validate json schema should be "sumbit_submission_schema.json"