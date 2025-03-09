Feature: Search Analyst

Scenario: Search Analyst
    Given I am on the Civil Service Jobs Page
    When I enter search criteria "<keyword>" and "<location>"
    And I should see all correct job listings for "<keyword>" and "<location>"
    And I filter based on department "<department>"

Examples:
| keyword           |      location      |
| Analyst           |      London        |

Examples:
| department |
| Medicines and Healthcare Products Regulatory Agency        |
