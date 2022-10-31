@FIDE-1401
Feature: Log out Functionality

  Background:
    Given  user is on the homepage after login with valid credentials.

    @FIDE-1451
    Scenario: User can log out and ends up in login page.
      When user clicks on the username modul
      Then user click Log out options
      And user goes to the Login Page

     @FIDE-1452
      Scenario: The user can not go to the home page again by clicking the step back button after successfully logged out
        And user click on the go back button
        Then user can not go to the homepage again