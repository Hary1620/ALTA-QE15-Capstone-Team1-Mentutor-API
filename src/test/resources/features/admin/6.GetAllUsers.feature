Feature: Get All Users in Mentutor Website
  Scenario: Get All User
    Given get all user with valid json
    When send request get all users
    Then  Status code should be 200
    And Response body message should be "success get all users"
    And Validate json schema should be "all_user_schema.json"
