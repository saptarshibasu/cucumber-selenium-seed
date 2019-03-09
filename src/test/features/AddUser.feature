Feature: Add User

Scenario: Add user with one set of user details
Given User goes to add user page "http://thedemosite.co.uk/savedata.php"
When User enters user details
| username | password |
| test1u   | test1p   |
 And User clicks on Save button
Then The page displays username
 And The page displays password


Scenario: Add user with multiple set of user details
Given User goes to add user page "http://thedemosite.co.uk/savedata.php"
When User enters user details
| username | password |
| test1u   | test1p   |
| test2u   | test2p   |
 And User clicks on Save button
Then The page displays username
 And The page displays password
 