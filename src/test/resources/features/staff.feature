Feature: Staff REST calls
  Tests all staff functionality is working.

  Scenario: Basic
    Given the staff member JSON model 1
    When the staff member is sent to create
    Then the staff member is created