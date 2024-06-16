@tugas
Feature: Update user API
  Scenario: Put update user with valid parameter id and valid json
    Given Update user with parameter id 2 and valid json "update_user.json"
    When Send request put update user
    Then Status code should be 200
    And Response body name should be "Hary Indra Edit" and job should be "QA Engineer Edit"
    And validate json schema "Update_users_json_schema.json"


    Scenario: Patch update user with valid parameter id and valid json
      Given Update user with parameter id 3 and valid json "update_user.json"
      When Send request patch update user
      Then Status code should be 200
      And Response body name should be "Hary Indra Edit" and job should be "QA Engineer Edit"
      And validate json schema "Update_users_json_schema.json"