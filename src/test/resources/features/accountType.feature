
Feature: Account Type

  Background: # burasi tekrarlananlari aliyor
    Given The user is on the login page

  Scenario: Teacher navigates to All Posts Menu
    When The user logs in using "eurotech@gmail.com" and "Test12345!"
    Then The welcome message contains "Teacher"

  Scenario: Student navigates to All Posts Menu
    When The user logs in using "batch11test@gmail.com" and "Yilmaz.1234"
    Then The welcome message contains "b11Test"

  Scenario: Developer navigates to My Account Menu
    When The user logs in using "jackbauer@gmail.com" and "Admin123"
    Then The welcome message contains "Jack Bauer"


  Scenario Outline: Different userType
    When The user logs in using "<userType>" and "<password>"
    Then The welcome message contains "<name>"
    Examples:
      | userType              | password    | name       |
      | eurotech@gmail.com    | Test12345!  | Teacher    |
      | batch11test@gmail.com | Yilmaz.1234 | b11Test    |
      | jackbauer@gmail.com   | Admin123    | Jack Bauer |



