@loginwithparameter
Feature: Navigate to Menu with Parameters
Background: # burasi tekrarlananlari aliyor
  Given The user is on the login page
@smoke
  Scenario: Teacher navigates to All Posts Menu
   #Given The user is on the login page
    When The user logs in using "eurotech@gmail.com" and "Test12345!"
    Then The welcome message contains "Teacher"
    When The user navigates to "All Posts" menu
    Then The user should be able to see header as "Posts"

    Scenario: Developer navigates to My Account Menu
      #Given The user is on the login page
      When The user logs in using "jackbauer@gmail.com" and "Admin123"
      Then The welcome message contains "Jack Bauer"
      When The user navigates to "All Posts" menu
      When The user navigates to "My Account" menu
      Then The user should be able to see header as "Dashboard"

