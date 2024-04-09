@Regression @ui @login
  Feature: User should be able to login

    Background: User is on the login page
      Given the user is on the login page

      Scenario: Verify login as a user
        Given the user logged in
        Then user is able to access the home page