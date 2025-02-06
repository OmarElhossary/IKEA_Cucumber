Feature: Register  and Login Feature
  Scenario: Verify that a new user can register successfully
    Given User Click on Register and Login Icon
    When User Navigate to the Create Account page
    And Enter a Valid Personal Data
    And User Can register Successfully
    And  User logout
    And  User Should login with Exist email and password
    Then User login Successfully
