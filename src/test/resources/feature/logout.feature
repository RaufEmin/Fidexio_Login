Feature: Log out Functionality

  Background:
    Given  user is on the homepage
  @wip
    Scenario: User can log out and ends up in login page.
      When user clicks on the username modul
      Then user click Log out options
      And user goes to the Login Page


      Scenario: The user can not go to the home page again by clicking the step back button after successfully logged out
        When user clicks on the username modul
        Then user click Log out options
        And user goes to the Login Page
        And user click on the go back button
        Then user can not go to the homepage again