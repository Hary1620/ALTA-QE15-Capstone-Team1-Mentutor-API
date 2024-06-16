@tugas
  Feature: Get delayed response in API
   Scenario Outline: Handle delayed response
      Given Get dellayed responsed of time <ResponedTime>
      And I send a request to the delayed API
      When I wait for the response
      Then Status code should be 200
      And The response should be received after a delay
      And validate json schema "delayed_response_json_schema.json"

     Examples:
     |ResponedTime|
     | 1 |
     | 2 |
     | 3 |
