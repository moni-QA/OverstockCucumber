Feature: Test register functionalities of overstock website
  Background:
    Given a user is on the home page

  @CreateAccount
  Scenario: Create a new account for overstock website
    And user navigate to Create Account page
    When user enters email "moniara35@gmail.com" and password "khoko444"
    And click on create account button
    Then user is navigated to home page

  @InvalidEmail
  Scenario: Check create account is unsuccessful with invalid email
    And user navigate to Create Account page
    When user enters email "moniara35gmailcom" and password "khoko444"
    And click on create account button
    Then user is failed to create account for invalid email

  @InvalidPassword
  Scenario: Check create account is unsuccessful with invalid password
    And user navigate to Create Account page
    When user enters email "moniara35@gmail.com" and password "khoko"
    And click on create account button
    Then user is failed to create account for invalid password