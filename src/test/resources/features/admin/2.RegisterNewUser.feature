Feature: Register New User  in Mentutor API
 Scenario Outline: Register New user with valid json
   Given register new user with valid json "<FileName>"
   When send request post register new user
   Then Status code should be 201
   And Validate json schema should be "register_user_schema.json"



   Examples:
   |FileName|
   |Register_User.json|
   |Register_User1.json|

   Scenario: Register new user with empty password
     Given register new user with invalid json "register_user_empty_password.json"
     When send request post register new user
     Then Status code should be 400
     And Validate json schema should be "invalid_input_schema.json"


  Scenario: Register new user with empty email
    Given register new user with invalid json "register_user_empty_email.json"
    When send request post register new user
    Then Status code should be 400
    And Validate json schema should be "invalid_input_schema.json"


  Scenario: Register new user with empty password
    Given register new user with invalid json "register_user_admin.json"
    When send request post register new user
    Then Status code should be 400
    And Validate json schema should be "invalid_input_schema.json"


