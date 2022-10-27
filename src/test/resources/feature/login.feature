@FIDE-1430
Feature: Login Functionality

  Background:
    Given user is on the login page

@FIDE-1424
  Scenario Outline: Users can log in with valid credential
    When user enters valid username "<username>"
    Then user enters valid password "<password>"
    When user click on the login button
    And user can see their "<userID>"

    Examples:
      | username                | password     | userID         |
      | posmanager17@info.com   | posmanager   | POSManager17   |
      | salesmanager17@info.com | salesmanager | SalesManager17|
@FIDE-1425
  Scenario: Wrong login/password" should be displayed for invalid  credentials (valid username-invalid password)
    When Posmanager enters valid username and invalid password
    When user click on the login button
    Then user wrong Login password message is displayed

@FIDE-1426
  Scenario: Wrong login/password" should be displayed for invalid  credentials (invalid username-valid password)
    When SalesManager enters invalid username and valid password
    When user click on the login button
    Then user wrong Login password message is displayed

@FIDE-1427
  Scenario: Please fill out this field" message should be displayed if the password or username is empty
    When user enter valid username
    When user click on the login button
    Then Please fill out this field message is displayed

 @FIDE-1428
  Scenario: User should see the password in bullet signs by default
    Then user input valid password
    And user sees password in bullet sign by default

@FIDE-1429
  Scenario: Verify if the ‘Enter’ key of the keyboard is working correctly on the login page
    When user enter valid username
    And user enter valid password and user presses Enter Key on the  keyboard
    Then user  is on the home page


















