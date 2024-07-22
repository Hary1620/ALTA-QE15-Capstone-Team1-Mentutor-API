Feature: Update class name or status class on mentutor API
 Scenario Outline: Update class name
    Given Update class with parameter class id 8 and valid json "<FileName>".
    When Send Request put update class
    Then Status code should be 201

   Examples:
   |FileName|
   |update_classNameAndStatus.json|
   |update_className.json         |
   |update_classStatus.json       |


