@SearchDepartment
Feature: Search department

Scenario: Search department
    Given I am on the Civil Service Jobs Page
    When I enter search criteria "<keyword>" and "<location>"
    And I should see all correct job listings for "<keyword>" and "<location>"
    And I filter based on department "<department>"
    And I select MHRA "<department>"
    And I select the first job in search & find no of positions

Examples:
| keyword           |      location      |     department   |
| Analyst           |      London        |     Medicines and Healthcare Products Regulatory Agency |
