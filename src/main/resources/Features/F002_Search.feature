Feature: Search Feature Test case 3 and 4
  Background:
    Given go to Login Page
    And  User Should login with email and password
    Then User login Successfully
  Scenario: Verify that the search bar returns relevant product results
    Given Enter a product keyword in the search bar
    When User Click the search icon.
    Then  the products displayed related to the keyword
Scenario: Verify that clicking on a product opens the product details page
  Given Click on a random product displayed on the home page
