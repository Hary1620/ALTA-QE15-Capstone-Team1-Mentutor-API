Feature: Get Profil user on mentutor website
  Scenario Outline: Get Profil user with Id
    Given Get profil user with valid param <UserID>
    When send request get profil user
    Then Status code should be 200

    Examples:
    |UserID|
    | 2   |
    | 3   |
    | 5   |