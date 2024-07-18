Feature: Add comment on status
  Scenario: Add comment on forum with valid id status & valid data
    Given Add comment on forum with valid id 1 status & valid data "add_comment.json"
    When Send request add comment
    Then Status code should be 201
    And Response body message should be "success insert comment"
    And Validate json schema should be "add_comment_schema.json"