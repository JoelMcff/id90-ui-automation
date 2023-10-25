@smoke
@login
Feature: Login
  As a registered user
  I want to be able to log in
  So that I can access my account

  Background:
    Given I am on the home page

  @successful-login
  Scenario: Successful Login
    When I enter valid credentials
    And I click the login button
    Then I should be logged in

  @unsuccessful-login
  Scenario: Unsuccessful Login (Incorrect Credentials)
    When I enter invalid credentials
    And I click the login button
    Then I should see an alert

  @unsuccessful-login-examples
  Scenario Outline: Unsuccessful Login (Invalid combination credentials)
    When I enter the invalid combination credentials "<username>" "<password>" "<company>"
    And I click the login button
    Then I should see an alert
    Examples:
      | username        | password        | company              |
      | nkmauqa         | invalidPassword | Spirit Airlines (NK) |
      | invalidUsername | B432532r!       | Spirit Airlines (NK) |

  @empty-fields-login
  Scenario: Unsuccessful Login (Empty Fields)
    When I click the login button
    Then I should see an error message that reads "Company is required"
    And I should see an error message that reads "Email or Employee Number is required"
    And I should see an error message that reads "Password is required"

  @show-password-login
  Scenario: Show and hide password
    When I enter valid credentials
    And I see the password field as password
    And I click the show password button
    Then I see the password field as text
    And I should see the password I wrote

  @dashboard-view
  Scenario: Dashboard page view validation
    When I enter valid credentials
    And I click the login button
    Then I should see the dashboard page displayed correctly