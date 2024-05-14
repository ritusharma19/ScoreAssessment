@FindPlayerTeamLeague
Feature: Find Player, Team or League
Scenario Outline: Validate correct data is displayed on search
Given theScore Application is installed and the user navigated till Homepage
When The user is on HomeScreen
And The user searches for "<SearchEntity>"
Then Verify expected page opens correctly for "<SearchEntity>"
And  The user selects subTab and Verify Correct data for "<SearchEntity>" is displayed
And The user navigates back to Team Page
  Examples:
    | SearchEntity |
    | Toronto Raptors |