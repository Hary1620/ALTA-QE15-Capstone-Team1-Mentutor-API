Feature: Update user on mentutor API
  Scenario: Update user of mentee with valid data
    Given Update user with parameter userId 17 and valid json "update_user.json"
    When Send Request put update user
    Then Status code should be 201

    
    Scenario: Update user with invalid data
      Given Update user with parameter userId 17 and valid json "update_invuser.json"
      When Send Request put update user
      Then Status code should be 400
      And Validate json schema should be "invalid_input_schema.json"


  Scenario: Update invalid user of mentee 
    Given Update user with parameter userId 5 and valid json "update_user.json"
    When Send Request put update user
    Then Status code should be 400
    And Validate json schema should be "message_error_schema.json"
      