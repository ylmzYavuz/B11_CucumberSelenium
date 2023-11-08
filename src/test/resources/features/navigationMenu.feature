@navigationMenu @regression
Feature:Navigation menu
# -Write scenarios in navigationMenu.feature
#-Create step definitions
#-No need to use any JAVA code.
#-Just implement the step definitions by adding print statement.
#-Create new class NavigationMenuStepDefs

# Scenario: Developer page test
#Login as Developer
#At first get the text of welcome
#Then go to Developers menu and get the text of Developers

#Scenario: Posts page test
#Login as Student
#Get the text of welcome
#Then go to All Posts menu and get the text of Posts

#Scenario: Dashboard page test
#Login as Teacher
#Get the text of welcome
#Then go to My Account menu and get the text of Dashboard
  @developer @db
  Scenario:Navigation to Developers Menu
    Given The user is on the login page
    When The user enters developer credentials
    Then The user should be able to see welcome message
    When The user navigates to Developer Menu
    Then The user able to see developer text
  @student
  Scenario:Navigation to All Posts Menu
    Given The user is on the login page
    When The user enters student credentials
    Then The user should be able to see welcome message
    When The user navigates to All Posts Menu
    Then The user able to see Posts text
  @teacher
  Scenario:Navigation to My Account Menu
    Given The user is on the login page
    When The user enters teacher credentials
    Then The user should be able to see welcome message
    When The user navigates to My Account Menu
    Then The user able to see Dashboard text