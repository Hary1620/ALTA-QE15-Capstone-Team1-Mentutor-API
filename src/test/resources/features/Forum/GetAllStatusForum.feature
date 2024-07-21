Feature: Get all status
  Scenario: Get all forum status
    Given Get all status by mentor and mentee
    When Send request get all status
    Then Status code should be 200