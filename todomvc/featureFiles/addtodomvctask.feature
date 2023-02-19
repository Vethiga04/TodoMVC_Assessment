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
Feature: Todomvc list features

  @functionalTest
  Scenario: Added item will be included in the todo list
    Given user navigates to Todomvc site
    When user types "todo item 1" and press enter key on the item area
    Then user should be able to view "todo item 1" as the added item in the list
    And the list summary is shown as 1 item left
    
  @functionalTest
  Scenario: Added multiple items will be included in the todo list
    Given user navigates to Todomvc site
    When user types below items as todo item in the list and pressing enter key
    |todo item 1n|
    |todo item 2n|
    Then user should be able to view the below items as the added item in the list
    |todo item 1n|
    |todo item 2n|
    And the list summary is shown as 2 items left  
    
    
  @functionalTest
  Scenario: Added item can be edited  in the todo list
    Given user navigates to Todomvc site
    And Type todo item in the list as "todo item 1m"
    When user double clicks on the added item
    And user appends new word into todo item as " editted" 
    And user clickcs on enter key
    Then user should be able to view the edited item as "todo item 1m editted" in the list
    And the list summary is shown as 1 item left 
    
    
  @functionalTest
  Scenario: Added item can be removed  in the todo list
    Given user navigates to Todomvc site
    And Type todo item in the list as "todo item 1k"
    When user clicks on close icon 
    Then user shouldnt be able to view the removed items in the list
    And the list summary is not shown at the bottom
    
    
  @functionalTest
  Scenario: Upon completing items Count will be minimized and Clear Completed text will be shown
    Given user navigates to Todomvc site
    And Type todo item in the list as "todo item 1h"
    When user clicks on radiobutton of the item 
    Then user should be able to view the text at bottom as "Clear completed"
    And the list summary is shown as 0 items left 
    
    
    
    
    