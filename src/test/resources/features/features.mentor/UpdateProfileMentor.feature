Feature: Update profile mentor
  Scenario: Update profile with valid data
    Given Update profile with valid data "update_profile_mentor.json"
    When Send request update profile mentor
    Then Status code should be 201
    And Response body message should be "success update profile"
    And Validate json schema should be "update_profile_mentor_schema.json"
