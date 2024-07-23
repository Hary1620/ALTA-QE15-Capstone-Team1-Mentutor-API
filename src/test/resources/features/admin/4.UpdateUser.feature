Feature: Update user on mentutor API
  Scenario: Update user of mentee
    Given Update user with parameter userId 17 and valid json "update_user.json"
    When Send Request put update user
    Then Status code should be 201