Feature: Update class name or status class on mentutor API
 Scenario Outline: Update class name
    Given Update class with parameter class id 8 and valid json "<FileName>"
    When Send Request put update class
    Then Status code should be 201
    And Validate json schema should be "update_class_schema.json"

   Examples:
   |FileName|
   |update_classNameAndStatus.json|
   |update_className.json         |
   |update_classStatus.json       |

   Scenario: Update class with specialcharacter id
     Given Update class with parameter class id "%$^" and valid json "update_classNameAndStatus.json"
     When Send Request put update class
     Then Status code should be 400
     And Validate json schema should be "invalid_input_schema.json"




