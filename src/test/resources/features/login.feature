@regression
Feature: DevEx log in test
  #Agile Story: As a user, I should be able to log in, so that I can see my dashboard.

  @teacher @smoke
  Scenario: Log in as a teacher
    Given The user is on the login page
    When The user enters teacher credentials
    Then The user should be able to login

    @student
  Scenario: Log in as a student
    Given The user is on the login page
    When The user enters student credentials
    Then The user should be able to login

  @developer @db
    #Log in as a developer
  Scenario: Log in as a developer
    Given The user is on the login page
    When The user enters developer credentials
    Then The user should be able to login


