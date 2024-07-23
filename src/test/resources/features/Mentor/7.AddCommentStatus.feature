Feature: Add comment on status
  Scenario: Add comment on forum with valid id status & valid data
    Given Add comment on forum with valid id 4 status & valid data "add_comment.json"
    When Send request add comment
    Then Status code should be 201
    And Response body message should be "success insert comment"
    And Validate json schema should be "add_comment_schema.json"

  Scenario: Add comment on forum with not exist id status & valid data
    Given Add comment on forum with not exist id 100 status & valid data "add_comment.json"
    When Send request add comment
    Then Status code should be 400
#    And Response body message error should be "Not Found"
    And Validate json schema should be "add_comment_invalid_schema.json"

  Scenario: Add comment on forum with invalid id status & valid data
    Given Add comment on forum with invalid id "empat" status & valid data "add_comment.json"
    When Send request add comment
    Then Status code should be 400
#    And Response body message error should be "Not Found"
    And Validate json schema should be "add_comment_invalid_schema.json"

  Scenario: Add comment on forum with valid id status & invalid type data
    Given Add comment on forum with valid id 4 status & valid data "add_comment_invalid_type_data.json"
    When Send request add comment
    Then Status code should be 400
#    And Response body message error should be "Not Found"
    And Validate json schema should be "add_comment_invalid_schema.json"

  Scenario: Add comment on forum with valid id status & invalid data
    Given Add comment on forum with valid id 4 status & invalid data "add_comment_invalid_data.json"
    When Send request add comment
    Then Status code should be 400
#    And Response body message error should be "Not Found"
    And Validate json schema should be "add_comment_invalid_schema.json"