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

# login as a teacher
  # verify welcome header
  # go to developer page
  # verify "Filter Profiles by Skill or by Location"

  Scenario: Teacher navigates to All Posts Menu
   #Given The user is on the login page
    When The user logs in using "eurotech@gmail.com" and "Test12345!"
    Then The welcome message contains "Teacher"
    When The user navigates to "Developers" menu
    Then The user should be able to see header as "Filter Profiles by Skill or by Location"

  @wip
  Scenario Outline: Different user navigate different menu
    When The user logs in using "<userType>" and "<password>"
    Then The welcome message contains "<name>"
    When The user navigates to "<menu>" menu
    Then The user should be able to see header as "<header>"

    #Class Task --> Create navigate to menu with parameters feature test with scenario outline
    Examples:
      | userType              | password    | name       | menu       | header                                  |
      | eurotech@gmail.com    | Test12345!  | Teacher    | All Posts  | Posts                                   |
      | jackbauer@gmail.com   | Admin123    | Jack Bauer | My Account | Dashboard                               |
      | batch11test@gmail.com | Yilmaz.1234 | b11Test    | Developers | Filter Profiles by Skill or by Location |
