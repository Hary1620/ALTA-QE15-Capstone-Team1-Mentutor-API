Feature: Delete user on mentutor API
  Scenario: Delete user with valid ID
    Given Delete user with id 23
    When Send request delete user
    Then Status code should be 200