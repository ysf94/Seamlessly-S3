@SEAMLES-2378
Feature: Seamlessly Login functionality

  @SEAMLES-2402
  Scenario Outline: User should be able to login successfully with valid credentials

    Given User goes to Seamlessly login page
    When User types username as "<username>"
    And User enters password as "<password>"
    And User clicks "<ButtonType>"
    Then Verify that User lands on user dashboard
    Examples:
      | username   | password    | ButtonType |
      | Employee41 | Employee123 | ENTER      |
      | Employee44 | Employee123 | LoginBtn   |
      | Employee42 | Employee123 |            |

  @SEAMLES-2418
  Scenario Outline: Verify that User can not login with any invalid credentials
    Given User goes to Seamlessly login page
    When User types username as "<username>"
    And User enters password as "<password>"
    And User clicks "<ButtonType>" "<errorOrAlertMessage>"
    Then Verify that User sees "<errorOrAlertMessage>"
    Examples:
      | username   | password    | ButtonType | errorOrAlertMessage         |
      | Employe41  | Employee123 | ENTER      | Wrong username or password. |
      | Employee41 | Employee13  | LoginBtn   | Wrong username or password. |
      | Employe41  | Employee13  |            | Wrong username or password. |
      | Employee41 |             |            | Please fill out this field  |
      |            | Employee123 |            | Please fill out this field  |

  @SEAMLES-2431
  Scenario: Verify that user can see the password in a form of dots by default(when empty and filled )

    Given User goes to Seamlessly login page
    When Verify that the default visibility of the password input box is dot
    And User clicks password visibility button
    And Verify that visibility of the password input box is now text
    And User clicks password visibility button
    And Verify that visibility of the password input box is dots again
    And User enters password as "anyPassword123"
    And Verify that the default visibility of the password input box is dot
    And User clicks password visibility button
    And Verify that visibility of the password input box is now text
    And User clicks password visibility button
    Then Verify that visibility of the password input box is dots again


  @SEAMLES-2432
  Scenario: Verify that user can see the password explicitly if needed

    Given User goes to Seamlessly login page
    When Verify that the default visibility of the password input box is dot
    And User enters password as "anyPassword123"
    And Verify that user clicks password visibility button
    And User clicks password visibility button
    And Verify that visibility of the password input box is now text
    And User clicks password visibility button
    Then Verify that visibility of the password input box is dots again

  @SEAMLES-2433
  Scenario: Forgot password? Verify that the link can be used by the user

    Given User goes to Seamlessly login page
    When Forgot password? Verify visibility.
    And User clicks on Forgot password? link text
    And Verify that user goes to the reset password page
    And User types username as "<Employee>"
    And User clicks reset button
    And Verify that user sees reset message
    And User clicks Back to login link text
    Then Verify that user goes back to the login page
