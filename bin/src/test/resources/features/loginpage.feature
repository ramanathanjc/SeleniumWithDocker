Feature:  Login Functionality for OpenCart E-commerce Website
 
 Scenario: Successful login with valid credentials
  Given I am on the OpenCart login page
  When I get the Page Title
  Then I get the message in login Page
  And I have entered a valid username and password 
  Then I click on the login button