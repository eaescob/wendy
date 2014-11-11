Feature: Add a new student

Background: As an application, I want to be able to add a new student.

Scenario: I want to add Emilio as a new student.
Given I have a student to add
When I add the following data for new student:
    | firstname | lastname | ssn         | addr1      | state | country | department | degree |
	| Emilio   | Escobar   | 987-65-4321 | 123 Elm St | CA | US | Engineering | Computer Science |
Then Student "Emilio" is added to database