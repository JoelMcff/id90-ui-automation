@smoke
@login
Feature: Login
  As a registered user
  I want to be able to log in
  So that I can access my account

  @successful-login
  Scenario: Successful Login
    Given I am on the home page
    When I enter valid credentials
    And I click the login button
    Then I should be logged in

  @unsuccessful-login
  Scenario: Unsuccessful Login (Incorrect Credentials)
    Given I am on the home page
    When I enter invalid credentials
    And I click the login button
    Then I should see an alert

  @empty-fields-login
  Scenario: Unsuccessful Login (Empty Fields)
    Given I am on the home page
    When I click the login button
    Then I should see an error message that reads "Company is required"
    And I should see an error message that reads "Email or Employee Number is required"
    And I should see an error message that reads "Password is required"