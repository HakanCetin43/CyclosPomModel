Feature: CyclosBank login page

  Scenario Outline: The user cannot login with an invalid username and/or password
    Given the user navigates to "https://demo.cyclos.org/#login"
    When user enters username "<username>"
    And user enters password  "<password>"
    And user clicks sign in button
    Then user views errorMessage "<errorMessage>"
    Examples:
      | username | password | errorMessage                                               |
      | demo     | 12345    | The given name / password are incorrect. Please, try again |
      | demooo   | 1234     | The given name / password are incorrect. Please, try again |
      | demo     |          | Password is required                                       |
      |          | 1234     | Login name is required                                     |
      |          |          | Login name is required\nPassword is required               |
