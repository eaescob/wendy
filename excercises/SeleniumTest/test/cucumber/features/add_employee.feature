Feature: Add an employee to the application

Scenario: Add a new employee
Given  I visit "/SeleniumExample/employees/createEmployee.do"
When I should enter "Test" in the "firstName" field
And I enter "User" in the "lastName" field
And I enter "20000" in the "salary" field
And I press the "Save" button
Then I should see the "All Employees" page
