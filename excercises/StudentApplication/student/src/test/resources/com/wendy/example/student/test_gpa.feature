Feature: Test gpa feature

Background: As an application, I want to test the gpa feature. 

Scenario: I want to test the gpa feature of a student. 
Given I have a student to add
When I add the following data for new student:
    | firstname | lastname | ssn         | addr1      | state | country | department | degree |
	| Nom   | Nom   | 135-79-4321 | 123 Elm St | CA | US | Engineering | Computer Science |
And I add the following scores "100, 70, 100" to student "Nom"
Then Student "Nom" is added to database 
And Student "Nom" has a gpa of 90