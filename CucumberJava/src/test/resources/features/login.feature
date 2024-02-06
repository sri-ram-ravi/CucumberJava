@login
Feature: Login

  Background:
    Given Login page url

  Scenario Outline: Validating Sucessfull and unSucessfull login
    When I enter username "<username>"
    And I enter password  "<password>"
    When I click login button
    Then alert should shown with "<errormessage>" message
    And username and password field should be empty once the alert popup closed

    Examples:
      | username   | password      | errormessage         |
      | webdriver  | webdriver123  | validation succeeded |
      | webdriver  | webdriver1234 | validation failed    |
      | webdrivers | webdriver123  | validation failed    |
      | webdrivers | webdriver1234 | validation failed    |
      |            |               | validation failed    |
      | webdrivers |               | validation failed    |
      |            | webdriver123  | validation failed    |

#  Scenario: Attempt login with valid username and valid password credentials
#    Given Login page url
#    When I enter username "webdriver"
#    And I enter password  "webdriver123"
#    When I click login button
#    Then alert should shown with "validation succeeded" message
#    And username and password field should be empty once the alert popup closed
#
#  Scenario: Attempt login with valid username and invalid password credentials
#    Given Login page url
#    When I enter username "webdriver"
#    And I enter password  "webdriver1234"
#    When I click login button
#    Then alert should shown with "validation failed" message
#    And username and password field should be empty once the alert popup closed
#
#  Scenario: Attempt login with invalid username and valid password credentials
#    Given Login page url
#    When I enter username "webdrivers"
#    And I enter password  "webdriver123"
#    When I click login button
#    Then alert should shown with "validation failed" message
#    And username and password field should be empty once the alert popup closed
#
#  Scenario: Attempt login with invalid username and invalid password credentials
#    Given Login page url
#    When I enter username "webdrivers"
#    And I enter password  "webdriver1234"
#    When I click login button
#    Then alert should shown with "validation failed" message
#    And username and password field should be empty once the alert popup closed


#  Scenario: Attempt login without entering the username and password credentials
#    Given Login page url
#    When I click login button
#    Then alert should shown with "validation failed" message
#    And username and password field should be empty once the alert popup closed
#
#  Scenario: Attempt login with username and without password
#    Given Login page url
#    When I enter username "webdrivers"
#    When I click login button
#    Then alert should shown with "validation failed" message
#    And username and password field should be empty once the alert popup closed
#
#  Scenario: Attempt login without username and with password
#    Given Login page url
#    And I enter password  "webdriver1234"
#    When I click login button
#    Then alert should shown with "validation failed" message
#    And username and password field should be empty once the alert popup closed


