Feature: Update profile mentee
  Scenario: Update profile with valid data
    Given Update profile mentee with valid data "update_profile_mentee.json"
    When Send request update profile mentee
    Then Status code should be 201
    And Response body message should be "success update profile"
    And Validate json schema should be "update_profile_mentee_schema.json"

#  negative case
  Scenario: Update profile with empty required password
    Given Update profile mentee with valid data "update_profile_mentee_invalid.json"
    When Send request update profile mentee
    Then Status code should be 400