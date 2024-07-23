Feature: Login mentee
  Scenario: Login mentee with valid account
    Given Login mentee with valid account "login_mentee.json"
    When Send request login mentee
    Then Status code should be 200
    And Response body name login should be "Jangan terubah"
