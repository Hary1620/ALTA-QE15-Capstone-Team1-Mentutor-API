Feature: Login user
  Scenario: Login with nonexist user
    Given Login with invalid account "login_nonexist.json"
    When Send request login invalid
    Then Status code should be 404
