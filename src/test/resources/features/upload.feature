Feature: Upload

  Scenario: Upload a picture to a test case
    Given login page is opened
    When logged in with correct credentials
    And project is created
    Then upload a file to a test case in a project