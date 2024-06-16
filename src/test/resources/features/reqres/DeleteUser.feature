Feature: Delete a user
  Scenario: Delete user with valid parameter id
    Given Delete user with id 2
    When Send request delete user
    Then Status code should be 204


    Scenario: Delete user with invalid parameter id
      Given Delete user with id "?"
      When Send request delete user
      Then Status code should be 404