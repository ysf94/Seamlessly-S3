Feature: Seamlessly Login functionality

  @SEAMLES-2402
  Scenario Outline: User should be able to login successfully with valid credentials

    Given User goes to Seamlessly login page
    When User types username as "<username>"
    And User enters password as "<password>"
    And User clicks "<ButtonType>"
    Then Verify that User lands on user dashboard
    Examples:
      | ButtonType | username   | password    |
      | ENTER      | Employee41 | Employee123 |
      | LoginBtn   | Employee44 | Employee123 |
      |            | Employee42 | Employee123 |



