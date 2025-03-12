@SearchAnalyst
Feature: Search Analyst

Scenario: Search Analyst
    Given I am on the Civil Service Jobs Page
    When I enter search criteria "<keyword>" and "<location>"
    Then I should see all correct job listings for "<keyword>" and "<location>"

Examples:
| keyword           |      location |
| Analyst           |      London   |
