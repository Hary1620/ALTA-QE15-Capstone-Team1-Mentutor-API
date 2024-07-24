Feature: Register new class in mentutor API
  Scenario Outline: register new class with valid json
    Given register new class with valid json "<FileName>"
    When send request post register new class
    Then Status code should be 201
    And Validate json schema should be "register_class_schema.json"

    Examples:
    |FileName|
    |Register_Class.json|
    |Register_Class1.json|

Scenario Outline: register new class with invalid json
  Given register new class with invalid json "<fileName>"
  When send request post register new class
  Then Status code should be 400
  And Validate json schema should be "register_invclass_schema.json"

  Examples: 
  |fileName|
  |Register_class_invalid.json|