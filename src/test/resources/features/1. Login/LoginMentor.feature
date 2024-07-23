Feature: Login mentor
  Scenario: Login mentor with valid account
    Given Login mentor with valid account "login_mentor.json"
    When Send request login mentor
    Then Status code should be 200
    And Response body name should be "Star Kish"
