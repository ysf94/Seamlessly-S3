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

