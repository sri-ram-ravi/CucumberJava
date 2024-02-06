@contact_us

Feature: Contact Us
  Scenario: Validate Successful Submission
    Given Go to the webdriver university contact us page
    When I enter first name "sriram"
    And I enter last name "ravi"
    And I enter email address "sri@yopmail.com"
    And I enter comment "please do contact"
    When I click submit
    Then I should see "Thank You for your Message!"

  Scenario: Validate Successful Reset
    Given Go to the webdriver university contact us page
    When I enter first name "sriram"
    And I enter last name "ravi"
    And I enter email address "sri@yopmail.com"
    And I enter comment "please do contact"
    When I click reset
    Then first name should be empty
    And last name should be empty
    And email should be empty
    And comment should be empty
