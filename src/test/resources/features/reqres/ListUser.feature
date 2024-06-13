Feature: Get List Users API
  #untuk scenario Outline Integer < >. jika Scenarionya string maka "< >"
  Scenario Outline: Get list users with valid parameter page
    Given Get list users with parameter page <page>
    When Send request get list users
    Then Status code should be 200
    And Response body page should be <page>
    And validate json schema "list_users_json_schema.json"
    Examples:
    | page |
    | 1    |
    | 2    |