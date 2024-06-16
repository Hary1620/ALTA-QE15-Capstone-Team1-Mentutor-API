@tugas
Feature: Login user Reqres API
  Scenario Outline: Login user with valid json
    Given Login user with valid json "<fileName>"
    When Send request post login user
    Then Status code should be 200
    And Response body token should be a valid token
    And validate json schema "login_users_json_schema.json"

    Examples:
    |fileName |
    |login_user1.json|
    |login_user2.json|

    Scenario Outline: Login user with unregistered account
      Given Login user with invalid json "<fileName>"
      When Send request post login user
      Then Status code should be 400
      And Response body should be "user not found"

      Examples:
      |fileName|
      |login_unregisteredUser1.json|
      |login_unregisteredUser2.json|


      Scenario Outline: Login user without password
        Given Login user with invalid json "<fileName>"
        When Send request post login user
        Then Status code should be 400
        And Response body should be "Missing password"
        
        Examples:
        |fileName|
        |login_withoutPassword1.json|
        |login_withoutPassword2.json|
        
        Scenario Outline: Login user without email
          Given Login user with invalid json "<fileName>"
          When Send request post login user
          Then Status code should be 400
          And Response body should be "Missing email or username"

          Examples:
            |fileName|
            |login_withoutEmail1.json|
            |login_withoutEmail2.json|