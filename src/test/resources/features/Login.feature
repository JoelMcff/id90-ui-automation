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