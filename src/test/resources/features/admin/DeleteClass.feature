Feature: Delete class on mentutor API
  Scenario: Delete class with valid ID
    Given Delete class with id 7
    When Send request delete class
    Then Status code should be 200