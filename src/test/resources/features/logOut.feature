@Wip
Feature: As a user, I should be able to log out.

  Background:
    Given User goes to Seamlessly login page

    @SEAMLES-2486
  Scenario: User can log out and ends up in login page

    When User goes to user homepage
    And User clicks profile button
    And User sees Log out Button
    And User clicks Log out button
    Then Verify that user is logged out of the user homepage


  @SEAMLES-2487
  Scenario: User can not go to home page again by clicking step back button after successfully logged out.

    When User goes to user homepage
    And User clicks profile button
    And User sees Log out Button
    And User clicks Log out button
    And Verify that user is logged out of the user homepage
    And User clicks to back button
    Then Verify that you are on the login page
