Feature: Contact Us
  Scenario: Validate Successful Submission
    Given Go to the webdriver university contact us page
    When I enter first name "sriram"
    And I enter last name "ravi"
    And I enter email address "sri@yopmail.com"
    And I enter comment "please do contact"
    When I click submit
    Then I should see "Thank You for your Message!"