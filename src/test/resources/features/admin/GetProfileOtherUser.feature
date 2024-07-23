Feature: Get Profil user on mentutor website
  Scenario Outline: Get Profil user with Id
    Given Get profil user with valid id <UserID>
    When send request get profil user
    Then Status code should be 200
    And Validate json schema should be "other_user_schema.json"

    Examples:
    |UserID|
    | 2   |
    | 3   |
    | 5   |

    Scenario Outline: Get profil user with invalid id
      Given get profil user with invalid id "<UserId>"
      When send request get profil user
      Then Status code should be 400
      And Validate json schema should be "other_user_invalid_schema.json"

      Examples:
      |UserId|
      | %$ |
      |$*  |