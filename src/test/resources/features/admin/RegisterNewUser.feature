Feature: Register New User  in Mentutor API
 Scenario Outline: Register New user with valid json
   Given register new user with valid json "<FileName>"
   When send request post register new user
   Then Status code should be 201


   Examples:
   |FileName|
   |Register_User.json|
   |Register_User1.json|