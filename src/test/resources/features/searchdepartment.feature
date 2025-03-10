Feature: Search department

Scenario: Search department
    Given I am on the Civil Service Jobs Page
    When I enter search criteria "<keyword>" and "<location>"
    And I should see all correct job listings for "<keyword>" and "<location>"
    And I filter based on department "<department>"
    Then I select MHRA department

Examples:
| keyword           |      location      | 
| Analyst           |      London        | 
