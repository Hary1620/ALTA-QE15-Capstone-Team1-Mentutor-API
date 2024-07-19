Feature: Update profile mentor
  Scenario: Update profile with valid data
    Given Update profile with valid data "jacob" "jacob@gmail.com" "jacob1234" "contoh.jpg"
    When Send request update profile mentor
    Then Status code should be 200
    And Response body message should be "success update profile"
    And Validate json schema should be "update_profile_mentor_schema.json"

#  negative case
#  Scenario: Update user with invalid input type data
#    Given Update profile with invalid type data "update_profile_mentor_invalid_type_data.json"
#    When Send request update profile mentor
#    Then Status code should be 400
#    And Response body message should be "Invalid Input From Client"
#    And Validate json schema should be "update_profile_mentor_schema_invalid.json"
#
#  Scenario: Update user with invalid input data
#    Given Update profile with invalid input data "update_profile_mentor_invalid_data.json"
#    When Send request update profile mentor
#    Then Status code should be 400
#    And Response body message should be "Invalid Input From Client"
#    And Validate json schema should be "update_profile_mentor_schema_invalid.json"