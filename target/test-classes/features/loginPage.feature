Feature: KOEL Login Page Feature

  Background: Given User navigates login Page

  Scenario: Login With Correct Credentials Test

    When User types correct credentials
      | email                  | password    |
      | dimagadjilla@gmail.com | te$t$tudent |
    Then User successfully logs in "Home"
    And User navigates on the main page

  Scenario: Login With Incorrect Credentials Test
    When User types incorrect credentials
      | email                   | password     |
      | dimagadjilla_@gmail.com | te$t_$tudent |
    Then Pop up error is showed up

  Scenario: Register A New Student Test
    When User clicks on the registration button
    And User types email for registration
    Then Successful registration message should be "Registration Successful"