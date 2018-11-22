#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Testing Search Feature
  I want to use this template for my feature file

  @SmokeTest
  Scenario Outline: Testing Succesful Launch of Iceland Grocery search page
    Given I want to launch Iceland Grocery page with Chrome Browser
    And I enter the url "<URL>" as input
    Then I am able to see the Iceland Groceries page "<Title>"

    Examples: 
      | URL                              | Title                                                 |
      | https://groceries.iceland.co.uk/ | Shop Now \| Online Food Shopping \| Iceland Groceries |

  @RegressionTest1
  Scenario Outline: Testing typing search text and getting suggestions with the same text
    Given I type "<SearchString>" in the searchbox
    Then The suggested groceries should contain the "<SearchString>"

    Examples: 
      | SearchString |
      | cho          |

  @RegressionTest2
  Scenario Outline: Testing when I select the search suggestions, the search results contain this search suggestion
    Given I select "<SearchSuggestion>" from the suggestions displayed
    Then The displayed groceries should contain the "<SearchSuggestion>"

    Examples: 
      | SearchSuggestion |
      | cho              |
