@login
Feature: Login
  Scenario: Attempt login with valid username and valid password credentials
    Given Login page url
    When I enter username "webdriver"
    And I enter password  "webdriver123"
    When I click login button
    Then alert should shown with "validation succeeded" message
    And username and password field should be empty once the alert popup closed

  Scenario: Attempt login with valid username and invalid password credentials
    Given Login page url
    When I enter username "webdriver"
    And I enter password  "webdriver1234"
    When I click login button
    Then alert should shown with "validation failed" message
    And username and password field should be empty once the alert popup closed

  Scenario: Attempt login with invalid username and valid password credentials
    Given Login page url
    When I enter username "webdrivers"
    And I enter password  "webdriver123"
    When I click login button
    Then alert should shown with "validation failed" message
    And username and password field should be empty once the alert popup closed

  Scenario: Attempt login with invalid username and invalid password credentials
    Given Login page url
    When I enter username "webdrivers"
    And I enter password  "webdriver1234"
    When I click login button
    Then alert should shown with "validation failed" message
    And username and password field should be empty once the alert popup closed

  Scenario: Attempt login without entering the username and password credentials
    Given Login page url
    When I click login button
    Then alert should shown with "validation failed" message
    And username and password field should be empty once the alert popup closed


