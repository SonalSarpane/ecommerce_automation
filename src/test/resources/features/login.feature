@login
Feature: YourLaga Login/Logout Feature

  Background: User is on Login Page
    When I entered valid Username and Password
    And I click on signin button
    Then I should see my account page

