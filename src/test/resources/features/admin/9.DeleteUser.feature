Feature: Delete user on mentutor API
  Scenario: Delete user with valid ID
    Given Delete user with id 24
    When Send request delete user
    Then Status code should be 200

    Scenario: Delete user with invalid id
      Given Delete user with id 5
      When Send request delete user
      Then Status code should be 400
      And Validate json schema should be "invalid_input_schema.json"


  Scenario: Delete user with invalid id
    Given Delete user with Special id "%$^"
    When Send request delete user
    Then Status code should be 400
    And Validate json schema should be "invalid_input_schema.json"



