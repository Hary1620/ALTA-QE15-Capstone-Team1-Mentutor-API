Feature: Login admin
  Scenario: Login admin with valid account
    Given Login admin with valid account "login_admin.json"
    When Send request login admin
    Then Status code should be 200
    And Response body name should be "admin"
