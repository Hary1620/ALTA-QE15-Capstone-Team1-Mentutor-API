Feature: Post status on forum by mentee
  Scenario: Post forum status
    Given Add status on forum with data "add_status_forum.json"
    When Send request add status
    Then Status code should be 201
    And Validate json schema "add_status_schema.json"

  #negative test
  Scenario: Post forum status without caption
    Given Add status on forum with data "invalid_status_caption.json"
    When Send request add status
    Then Status code should be 400

  Scenario: Post forum status with only images
    Given Add status on forum with data "invalid_status_images.json"
    When Send request add status
    Then Status code should be 400