Feature: Contact Us
  Scenario: Validate Successful Submission
    Given Go to the webdriver university contact us page
    When I enter first name
    And I enter last name
    And I enter email address
    And I enter comment
    When I click submit
    Then I should see "Thank You for your Message"