Feature: Register new class in mentutor API
  Scenario Outline: register new class with valid json
    Given register new class with valid json "<FileName>"
    When send request post register new class
    Then Status code should be 201

    Examples:
    |FileName|
    |Register_Class.json|
    |Register_Class1.json|