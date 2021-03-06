@UI
Feature: Create new user and Buy a Blouse Using BDD
#As a user I want to register in this web and buy a blouse to my cart
#-------------------------------------------------------------------------------
#Create new user 
Scenario: Create new user in automationpractice Werbsite
Given User navigate to automationpractice web
When Enter email and click on Create button 
And User Fill the required fields with valid data
And user navigate to my account page and signout
Then user returned to the homepage
#Login with the new user and add blouse to cart 
Given User Login with the new credentials
When Select the blouses and change its color and size  
And Proceed checkout steps with bank wire payment option
Then Assert this order in the history page