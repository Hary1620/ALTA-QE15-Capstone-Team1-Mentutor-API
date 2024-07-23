Feature: Update profile mentor
  Scenario: Update profile with valid data
    Given Update profile with valid data "Jacob Martin" "jacob@gmail.com" "Mentor123$" "contoh.jpg"
    When Send request update profile mentor
    Then Status code should be 201
    And Response body message should be "success update profile"
    And Validate json schema should be "update_profile_mentor_schema.json"

  Scenario: Update user with invalid input type data
    Given Update profile with invalid type data "contoh.jpg"
    When Send request update profile mentor
    Then Status code should be 400
#    And Response body message error should be "Invalid Input From Client"
    And Validate json schema should be "update_profile_mentor_schema_invalid.json"

  Scenario: Update user with invalid input data
    Given Update profile with invalid input data name "Jacob Martin" "jacob@gmail.com" "Mentor123$" "contoh.jpg"
    When Send request update profile mentor
    Then Status code should be 400
#    And Response body message error should be "Invalid Input From Client"
    And Validate json schema should be "update_profile_mentor_schema_invalid.json"