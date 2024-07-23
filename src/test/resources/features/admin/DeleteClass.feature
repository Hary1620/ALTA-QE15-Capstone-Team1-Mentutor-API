Feature: Delete class on mentutor API
  Scenario: Delete class with valid ID
    Given Delete class with id 7
    When Send request delete class
    Then Status code should be 200
    And Validate json schema should be "delete_class_schema.json"


  Scenario: Delete class with special ID
    Given Delete class with id "^%$"
    When Send request delete class
    Then Status code should be 400
    And Validate json schema should be "invalid_input_schema.json"

