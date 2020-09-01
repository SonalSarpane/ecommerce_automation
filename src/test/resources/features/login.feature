@login
Feature: Login/Logout Feature

  Scenario: User is on Home Page
    When I click on signin button
    Then I enter valid Username and Password
    Then I clicked on signin button
    Then I should see my account name is displayed

