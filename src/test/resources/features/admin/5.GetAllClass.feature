Feature: Get All class on Mentutor Website
  Scenario: Get All class with valid json
    Given get all class with valid json
    When send request get all class
    Then Status code should be 200
    And Response body name should be "Success Get All Class"
    Then Validate json schema should be "all_class_schema.json"