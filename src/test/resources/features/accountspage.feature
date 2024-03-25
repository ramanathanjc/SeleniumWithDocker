Feature:  Account Page Feature

Background:
Given user has already logged in to application
|username|password|
|ramanathan1106@gmail.com|Password1|

Scenario: Account section count
Given user is on account page and should be "My Account"
Then user get account section
|My Account|
|My Orders|
|My Affiliate Account|
|Newsletter|
And Account section count shoul be 4 
