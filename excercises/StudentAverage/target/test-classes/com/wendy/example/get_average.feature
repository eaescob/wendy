Feature: Average

Background: This is just an example application

Scenario: Get average score of grades for a student
Given I have a student with a bunch of grades
When I add score 98,99,70,64,86,78
Then the average score is 82.00

Scenario: Get minimum score
Given I have a student with a bunch of grades
When I add score 98,79,60,23,10
Then the minimum score is 10