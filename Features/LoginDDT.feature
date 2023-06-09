Feature: Login Data Driven

  Scenario Outline: Login Data Driven
    Given User Launch browser
    And opens URL "https://tutorialsninja.com/demo"
    When User navigate to MyAccount menu
    And click on Login
    And User enters Email as "<email>" and Password as "<password>"
    And Click on Login button
    Then User navigates to MyAccount Page
    And Click on Logout
    And Click on Continue

    Examples: 
      | email                 | password     |
      | traindevops@gmail.com | Devopstr@!n0 |
      | traindevops@gmail.com | Devopstr@!0  |
